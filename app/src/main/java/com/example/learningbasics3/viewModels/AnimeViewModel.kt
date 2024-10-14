package com.example.learningbasics3.viewModels

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningbasics3.models.Anime
import com.example.learningbasics3.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository,
    private val savedStateHandle : SavedStateHandle) : ViewModel() {

    val animeNames : StateFlow<List<Anime>>
        get() =  repository.animeListPublic

    //as soon as an object is created of this class
    // an API is hit and getCategories is executed
    //and the data gotten is stored in the val categories
    //then can be used anywhere
    init {
        viewModelScope.launch {
            Log.d("1010101", "the category is "+savedStateHandle.get<String>("categoryName"))
            val category = savedStateHandle.get<String>("categoryName") ?: "One Piece"
            repository.getAnimes(category)
        }
    }
}