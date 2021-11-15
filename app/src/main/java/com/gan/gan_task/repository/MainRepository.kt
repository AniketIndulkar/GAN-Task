package com.gan.gan_task.repository

import android.util.Log
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
            val bbCharacters = networkMapper.mapFromNetworkEntityList(bbCharactersFromNetwork).sortedBy { it.name }
            for(character in bbCharacters){
                bbCharacterDao.insertBBCharacter(roomMapper.mapToEntity(character))
            }
            val savedBBCharacter = bbCharacterDao.getAllCharacters()
            emit(DataState.Success(roomMapper.mapFromRoomEntityList(savedBBCharacter)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }


    suspend fun searchCharacter(searchString : String): Flow<DataState<List<BBCharacter>>> = flow {
        emit(DataState.Loading)
        try{

            val savedBBCharacter = bbCharacterDao.searchCharacter(searchString)
            emit(DataState.Success(roomMapper.mapFromRoomEntityList(savedBBCharacter)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }

    suspend fun filterCharacter(): Flow<DataState<List<BBCharacter>>> = flow {
        emit(DataState.Loading)
        try{

            val savedBBCharacter = bbCharacterDao.getAllCharacters().sortedBy { it.char_id }
            emit(DataState.Success(roomMapper.mapFromRoomEntityList(savedBBCharacter)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }

    suspend fun updateCharacterData(charData : BBCharacter){
        var affectedData= bbCharacterDao.getCharacterById(31)
        Log.d("MainRepository", "Before: ${affectedData.isFav}")
        val rowAffected= bbCharacterDao.insertBBCharacter(roomMapper.mapToEntity(charData))
        affectedData= bbCharacterDao.getCharacterById(31)
        Log.d("MainRepository", "After: ${affectedData.isFav}")
    }

    suspend fun getCharacterById(charId: Int): BBCharacter{
        val character =bbCharacterDao.getCharacterById(charId)
        return roomMapper.mapFromEntity(character)
    }
}