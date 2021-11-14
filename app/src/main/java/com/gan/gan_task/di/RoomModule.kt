package com.gan.gan_task.di

import android.content.Context
import androidx.room.Room
import com.gan.gan_task.room.BBCharacterDAO
import com.gan.gan_task.room.BbCharacterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {


    @Singleton
    @Provides
    fun provideBbCharacterDb(@ApplicationContext context: Context): BbCharacterDatabase {
        return Room.databaseBuilder(
            context,
            BbCharacterDatabase::class.java,
            BbCharacterDatabase.DATBASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideDAO(bbCharacterDatabase: BbCharacterDatabase) : BBCharacterDAO{
        return bbCharacterDatabase.getBBCharacterDAO()
    }

}