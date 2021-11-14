package com.gan.gan_task.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BBCharacterRoomEntity::class],version = 1)
abstract class BbCharacterDatabase: RoomDatabase() {

    abstract fun getBBCharacterDAO(): BBCharacterDAO

    companion object{
        val DATBASE_NAME = "BreakingBadCharacters"
    }
}