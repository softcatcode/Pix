package com.example.pix.presentation.picturesGrid

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pix.domain.entity.PictureSize
import com.example.pix.domain.usecase.SearchPicturesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PictureListViewModel @Inject constructor(
    private val searchPicturesUseCase: SearchPicturesUseCase
): ViewModel() {

    private val _state = MutableLiveData<PictureGridScreenState>(PictureGridScreenState.Initial)
    val state: LiveData<PictureGridScreenState>
        get() = _state

    private var currentPage: Int = 0
    private val perPageCount: Int = 10
    private var query: String = ""
    private val size = PictureSize.Small

    fun loadPictures(query: String) {
        viewModelScope.launch {
            _state.value = PictureGridScreenState.Loading
        }
        this.query = query
        this.currentPage = 0

        viewModelScope.launch(Dispatchers.IO) {
            searchPicturesUseCase(
                query = query,
                page = currentPage + 1,
                perPage = perPageCount,
                size = size
            ).onSuccess { loadedList ->
                currentPage = 1
                withContext(Dispatchers.Main) {
                    _state.value = PictureGridScreenState.Content(
                        pictures = loadedList,
                        nextLoading = false,
                        errorMessage = null
                    )
                }
            }.onFailure { error ->
                withContext(Dispatchers.Main) {
                    _state.value = PictureGridScreenState.Error(
                        message = error.message.orEmpty()
                    )
                }
            }
        }
    }

    fun nextPage() {
        val currentState = state.value as? PictureGridScreenState.Content ?: return
        viewModelScope.launch {
            _state.value = currentState.copy(
                nextLoading = true
            )
        }
        viewModelScope.launch(Dispatchers.IO) {
            searchPicturesUseCase(
                query = query,
                page = currentPage + 1,
                perPage = perPageCount,
                size = size
            ).onSuccess { loadedList ->
                val pictures = currentState.pictures.toMutableList().apply {
                    addAll(loadedList)
                }
                withContext(Dispatchers.Main) {
                    _state.value = PictureGridScreenState.Content(
                        pictures = pictures,
                        nextLoading = false,
                        errorMessage = null
                    )
                }
                ++currentPage
            }.onFailure {
                withContext(Dispatchers.Main) {
                    _state.value = currentState.copy(
                        nextLoading = false,
                        errorMessage = it.message
                    )
                }
            }
        }
    }
}