package io.astronout.core.vo

sealed class Resource<out T: Any> {
    data class Success<out T: Any>(val data: T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
    data object Loading: Resource<Nothing>()
}