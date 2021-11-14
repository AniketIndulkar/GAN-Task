package com.gan.gan_task.retrofit

import retrofit2.http.GET

interface BBCharacterAPI {

    @GET("characters")
    suspend fun getAllCharacters(): List<BBCharacterNetworkEntity>
}