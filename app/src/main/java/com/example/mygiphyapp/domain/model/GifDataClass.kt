package com.example.mygiphyapp.domain.model


import com.example.mygiphyapp.data.dto.search_gif_dto.Data
import com.example.mygiphyapp.data.dto.search_gif_dto.SearchGifDto

class GifDataClass(
    val myId: String,
    val myUrl: String,
    //val myWebp: String
)

// 1 map data to gifDataClass
fun Data.toGifDataClass(): GifDataClass {
    return GifDataClass(
        myId = this.id,
        myUrl = this.url,
        //myWebp = this.

    )
}

// 2 map list of gifs to list of gifsDataClass
fun SearchGifDto.toGifDataList(): List<GifDataClass> {
    return this.data.map {
        it.toGifDataClass()
    }
}



