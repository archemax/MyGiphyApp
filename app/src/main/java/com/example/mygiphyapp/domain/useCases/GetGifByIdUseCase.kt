package com.example.mygiphyapp.domain.useCases

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.example.mygiphyapp.Resource
import com.example.mygiphyapp.data.dto.search_gif_dto.Data
import com.example.mygiphyapp.domain.model.GifDataClass
import com.example.mygiphyapp.domain.model.toGifDataClass
import com.example.mygiphyapp.domain.model.toGifDataList
import com.example.mygiphyapp.domain.repository.GifRepository
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class GetGifByIdUseCase @Inject constructor(
    private val repository: GifRepository
) {

     @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
     suspend operator fun invoke()= flow{
            try {
                emit(Resource.Loading())
                //get one gif
                val gifDto = repository.getGifById()
                //change gif to local data class
                val oneGifDataClass =gifDto.toGifDataClass()

                emit(Resource.Success(oneGifDataClass))
            } catch (e: HttpException) {
                emit(Resource.Error(e.localizedMessage ?: "Unexpected Error"))
            } catch (e: IOException) {
                emit(Resource.Error("No connection to server... check your internet connection"))
            }


    }
}