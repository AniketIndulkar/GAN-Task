package com.gan.gan_task.room

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface BBCharacterDAO {

    @Query("SELECT * FROM BBCharacter ORDER BY NAME")
    suspend fun getAllCharacters() : LiveData<List<BBCharacterRoomEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBBCharacter(bbCharacter : BBCharacterRoomEntity): Long

}