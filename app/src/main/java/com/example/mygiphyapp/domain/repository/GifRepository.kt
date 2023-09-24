package com.example.mygiphyapp.domain.repository

import com.example.mygiphyapp.data.dto.search_gif_dto.Data
import com.example.mygiphyapp.data.dto.search_gif_dto.SearchGifDto


interface GifRepository {

    suspend fun getRandomGifs(): SearchGifDto


    suspend fun getGifById(): Data

}