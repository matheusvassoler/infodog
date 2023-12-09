package com.example.infodog.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.infodog.domain.GetBreedsUseCase
import com.example.infodog.ui.model.BreedUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class BreedViewModel(
    private val getBreedsUseCase: GetBreedsUseCase
) : ViewModel() {

    private val _breedsState: MutableStateFlow<PagingData<BreedUI>> = MutableStateFlow(value = PagingData.empty())
    val breedsState: MutableStateFlow<PagingData<BreedUI>> get() = _breedsState

    fun getBreeds() {
        viewModelScope.launch {
            getBreedsUseCase()
                .cachedIn(viewModelScope)
                .collect {
                    _breedsState.value = it
                }
        }
    }
}
