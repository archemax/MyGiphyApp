package com.example.mygiphyapp.data.dto

data class SearchGifDto(
    val `data`: List<Data>,
    val meta: Meta,
    val pagination: Pagination
)