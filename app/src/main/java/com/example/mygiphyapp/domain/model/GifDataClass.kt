package com.example.mygiphyapp.domain.model

import com.example.mygiphyapp.data.dto.Data
import com.example.mygiphyapp.data.dto.SearchGifDto


class GifDataClass(
    val myId: String,
    val myUrl: String,
)

// 1 map data to gifDataClass
fun Data.toGifDataClass(): GifDataClass {
    return GifDataClass(
        myId = this.id,
        myUrl = this.images.original.url,
    )
}

// 2 map list of gifs to list of gifsDataClass
fun SearchGifDto.toGifDataList(): List<GifDataClass> {
    return this.data.map {
        it.toGifDataClass()
    }
}



