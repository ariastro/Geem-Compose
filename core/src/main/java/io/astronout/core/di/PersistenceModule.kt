package io.astronout.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.astronout.core.data.source.local.room.GameDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideGameDatabase(@ApplicationContext context: Context): GameDatabase {
//        val passphrase: ByteArray = SQLiteDatabase.getBytes("astronout".toCharArray())
//        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(
            context.applicationContext,
            GameDatabase::class.java,
            "game_database"
        ).fallbackToDestructiveMigration()
//            .openHelperFactory(factory)
            .build()
    }
}