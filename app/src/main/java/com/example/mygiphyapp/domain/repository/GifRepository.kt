package com.example.mygiphyapp.domain.repository

import com.example.mygiphyapp.data.dto.SearchGifDto


interface GifRepository {

    suspend fun getRandomGifs(): SearchGifDto



}