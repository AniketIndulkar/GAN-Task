package com.gan.gan_task.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BBCharacterDAO {

    @Query("SELECT * FROM BBCharacter ORDER BY NAME")
    suspend fun getAllCharacters() : List<BBCharacterRoomEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBBCharacter(bbCharacter : BBCharacterRoomEntity): Long

}