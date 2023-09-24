package com.example.mygiphyapp.data.repository

import android.util.Log
import com.example.mygiphyapp.data.dto.search_gif_dto.Data
import com.example.mygiphyapp.data.dto.search_gif_dto.SearchGifDto
import com.example.mygiphyapp.data.retrofit.GiphyApi
import com.example.mygiphyapp.domain.repository.GifRepository
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val api: GiphyApi

):GifRepository {

    override suspend fun getRandomGifs(): SearchGifDto {
        Log.d("AAA", "${api.getRandomGifs()}")
            return api.getRandomGifs()


    }

    override suspend fun getGifById(): Data {
       return api.getGifById("dsds","dsds")
    }
}