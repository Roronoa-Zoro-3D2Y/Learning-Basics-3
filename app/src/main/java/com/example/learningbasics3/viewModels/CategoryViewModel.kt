package com.example.learningbasics3.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningbasics3.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//for ffff's sake don't u dare miss them annotations
@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: AnimeRepository) : ViewModel() {

    val categories : StateFlow<List<String>>
        get() =  repository.categories

    //as soon as an object is created of this class
    // an API is hit and getCategories is executed
    //and the data gotten is stored in the val categories
    //then can be used anywhere
    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}