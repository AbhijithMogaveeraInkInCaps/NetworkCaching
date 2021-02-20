package com.abhijith.networkcaching.api

import com.abhijith.networkcaching.api.models.Main
import retrofit2.Call
import retrofit2.http.GET

interface InkInCapsApi {
    @GET("/app/get_all_post")
    fun getAllPost(): Call<Main>
}