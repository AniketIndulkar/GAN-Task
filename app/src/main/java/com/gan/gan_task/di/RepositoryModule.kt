package com.gan.gan_task.di

import com.gan.gan_task.repository.MainRepository
import com.gan.gan_task.retrofit.BBCharacterAPI
import com.gan.gan_task.retrofit.NetworkMapper
import com.gan.gan_task.room.BBCharacterDAO
import com.gan.gan_task.room.RoomMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        bbCharacterDao: BBCharacterDAO,
        bbCharacterAPI: BBCharacterAPI,
        roomMapper: RoomMapper,
        networkMapper: NetworkMapper
    ): MainRepository{
        return MainRepository(bbCharacterDao, bbCharacterAPI, roomMapper, networkMapper)
    }
}