package com.gan.gan_task.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [BBCharacterRoomEntity::class],version = 1)
@TypeConverters(Converters::class)
abstract class BbCharacterDatabase: RoomDatabase() {

    abstract fun getBBCharacterDAO(): BBCharacterDAO

    companion object{
        val DATBASE_NAME = "BreakingBadCharacters"
    }
}