package com.example.mygiphyapp.domain.useCases

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import com.example.mygiphyapp.Resource
import com.example.mygiphyapp.domain.model.GifDataClass
import com.example.mygiphyapp.domain.model.toGifDataList
import com.example.mygiphyapp.domain.repository.GifRepository
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetRandomGifsUseCase @Inject constructor(
    private val repository: GifRepository
) {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
     operator fun invoke()= flow<Resource<List<GifDataClass>>> {
        try {
            emit(Resource.Loading())

            val searchGifDto = repository.getRandomGifs()
            val listOfGifs = searchGifDto.toGifDataList()
            Log.d("AAA", "$listOfGifs")

            emit(Resource.Success(listOfGifs))

        }catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown search error"))

        } catch (e: IOException) {
            emit(Resource.Error("No connection to the server"))
        }
    }
}