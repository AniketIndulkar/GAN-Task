package com.gan.gan_task.repository

import com.gan.gan_task.model.BBCharacter
import com.gan.gan_task.retrofit.BBCharacterAPI
import com.gan.gan_task.retrofit.NetworkMapper
import com.gan.gan_task.room.BBCharacterDAO
import com.gan.gan_task.room.RoomMapper
import com.gan.gan_task.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MainRepository constructor(
    private val bbCharacterDao: BBCharacterDAO,
    private val bbCharacterAPI: BBCharacterAPI,
    private val roomMapper: RoomMapper,
    private val networkMapper: NetworkMapper
) {

    suspend fun getBBCharacters(): Flow<DataState<List<BBCharacter>>> = flow {
        emit(DataState.Loading)
        try{
            val bbCharactersFromNetwork = bbCharacterAPI.getAllCharacters()
            val bbCharacters = networkMapper.mapFromNetworkEntityList(bbCharactersFromNetwork)
            for(character in bbCharacters){
                bbCharacterDao.insertBBCharacter(roomMapper.mapToEntity(character))
            }
            val savedBBCharacter = bbCharacterDao.getAllCharacters()
            emit(DataState.Success(roomMapper.mapFromRoomEntityList(savedBBCharacter)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}