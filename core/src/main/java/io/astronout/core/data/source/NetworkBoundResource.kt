package io.astronout.core.data.source

import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.StatusCode
import com.skydoves.sandwich.message
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import io.astronout.core.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

abstract class NetworkBoundResource<ResultType : Any, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(Resource.Loading)
            createCall().let {
                it.suspendOnSuccess {
                    saveCallResult(data)
                    emitAll(loadFromDB().map { result ->
                        Resource.Success(result)
                    })
                }.suspendOnError {
                    val error = when (statusCode) {
                        StatusCode.InternalServerError -> "InternalServerError"
                        StatusCode.BadGateway -> "BadGateway"
                        else -> "$statusCode(${statusCode.code}): ${message()}"
                    }
                    emit(Resource.Error(error))
                }.suspendOnException {
                    emit(Resource.Error("Oops, something went wrong!"))
                }
            }
        } else {
            emitAll(loadFromDB().map {
                Resource.Success(it)
            })
        }
    }.onStart { emit(Resource.Loading) }.flowOn(Dispatchers.IO)

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): ApiResponse<RequestType>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result
}