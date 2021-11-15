package com.gan.gan_task.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gan.gan_task.model.BBCharacter

@Dao
interface BBCharacterDAO {

    @Query("SELECT * FROM BBCharacter ORDER BY NAME")
    suspend fun getAllCharacters() : List<BBCharacterRoomEntity>

    @Query("SELECT * FROM BBCharacter WHERE char_id =:charId")
    suspend fun getCharacterById(charId : Int) : BBCharacterRoomEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBBCharacter(bbCharacter : BBCharacterRoomEntity): Long

    @Query("SELECT * FROM BBCharacter WHERE name LIKE '%' || :search || '%'")
    suspend fun searchCharacter(search: String?): List<BBCharacterRoomEntity>

}