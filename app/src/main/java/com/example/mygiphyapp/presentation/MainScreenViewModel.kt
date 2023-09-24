package com.example.mygiphyapp.presentation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygiphyapp.Resource
import com.example.mygiphyapp.domain.useCases.GetRandomGifsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
class MainScreenViewModel @Inject constructor(
    private val getRandomGifsUseCase: GetRandomGifsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(GifListState())
    val state: State<GifListState> = _state

    init {
        getRandomGifs()
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getRandomGifs() {
        getRandomGifsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = GifListState(myGifs = result.data ?: emptyList())
                    Log.d("MainScreenViewModel", "${result.data}")
                }

                is Resource.Error -> {
                    _state.value = GifListState(
                        error = result.message ?: "Error happened",
                        )
                    Log.d("MainScreenViewModel", "${result.message}")
                }

                is Resource.Loading -> {
                    _state.value = GifListState(isLoading = true)
                }

            }

        }.launchIn(viewModelScope)
    }
}