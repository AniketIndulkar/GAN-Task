package com.gan.gan_task.util

import com.gan.gan_task.model.BBCharacter
import com.google.gson.Gson

class Util {

    companion object {

        val CHARACTER_ID= "CharacterID"

        fun getObjectFromString(stringData: String): BBCharacter {
            return Gson().fromJson(stringData, BBCharacter::class.java)
        }
    }
}