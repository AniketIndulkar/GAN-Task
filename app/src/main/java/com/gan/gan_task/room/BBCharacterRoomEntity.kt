package com.gan.gan_task.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BBCharacter" )
data class BBCharacterRoomEntity (

    @ColumnInfo(name ="char_id")
    @PrimaryKey(autoGenerate = false)
    var char_id: Int,

    @ColumnInfo(name ="name")
    var name: String,

    @ColumnInfo(name ="birthday")
    var birthday : String,

    @ColumnInfo(name ="occupation")
    var occupation : List<String>,

    @ColumnInfo(name ="img")
    var img : String,

    @ColumnInfo(name ="status")
    var status : String,

    @ColumnInfo(name ="nickname")
    var nickname: String,

    @ColumnInfo(name ="appearance")
    var appearance : List<Int>,

    @ColumnInfo(name ="portrayed")
    var portrayed: String,

    @ColumnInfo(name ="category")
    var category: String,

    @ColumnInfo(name ="better_call_saul_appearance")
    var better_call_saul_appearance: List<Int>
        ){
}