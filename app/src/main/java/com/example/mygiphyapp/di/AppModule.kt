package com.example.mygiphyapp.di

import android.util.Log
import com.example.mygiphyapp.Constants
import com.example.mygiphyapp.data.repository.GifRepositoryImpl
import com.example.mygiphyapp.data.retrofit.GiphyApi
import com.example.mygiphyapp.data.retrofit.MyLoggingInterceptor
import com.example.mygiphyapp.domain.repository.GifRepository
import com.example.mygiphyapp.domain.useCases.GetRandomGifsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGifApi(okHttpInterceptor: Interceptor): GiphyApi {
        //add interceptor
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(okHttpInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(GiphyApi::class.java)
    }



    @Provides
    @Singleton
    fun provideLoggingInterceptor(): Interceptor {
        return MyLoggingInterceptor()
    }




    @Provides
    @Singleton
    fun provideGifRepository(
        api: GiphyApi
    ): GifRepository {
        return GifRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetRandomGifsUseCase(
        repository: GifRepository
    ): GetRandomGifsUseCase {
        return GetRandomGifsUseCase(repository)
    }
}