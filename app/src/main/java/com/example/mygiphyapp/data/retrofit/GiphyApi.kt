package com.example.mygiphyapp.data.retrofit

import com.example.mygiphyapp.Constants
import com.example.mygiphyapp.data.dto.SearchGifDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyApi {
    //search gifs
    @GET("search")
    suspend fun getRandomGifs (
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("q") query: String = "cat",
    ): SearchGifDto



}

