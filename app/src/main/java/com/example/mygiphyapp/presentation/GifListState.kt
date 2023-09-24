package com.example.mygiphyapp.presentation

import com.example.mygiphyapp.domain.model.GifDataClass

data class GifListState(
    val isLoading: Boolean = false,
    val myGifs: List<GifDataClass> = emptyList(),
    val error: String = ""
)