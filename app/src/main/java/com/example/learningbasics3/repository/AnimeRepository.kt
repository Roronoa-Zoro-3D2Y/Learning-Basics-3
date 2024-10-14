package com.example.learningbasics3.repository

import com.example.AnimeApi
import com.example.learningbasics3.models.Anime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
// repository is responsible for getting data from the API
class AnimeRepository @Inject constructor(private val animeApi: AnimeApi) {

    //this takes up the result passed from the func getCategory which return a list of string
    private val _category = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>>
        get() = _category

    private val _animes = MutableStateFlow<List<Anime>>(emptyList())
    val animeListPublic : StateFlow<List<Anime>>
        get() = _animes

    suspend fun getCategories(){
        val response = animeApi.getCategory()

        // checks if response is successful and that the body os not null
        if(response.isSuccessful && response.body() != null){
                _category.emit(response.body()!!)
        }
    }

    suspend fun getAnimes(category : String){
        val response = animeApi.getAnimeNames("Anime[?(@.category==\"$category\")]")

        // checks if response is successful and that the body os not null
        if(response.isSuccessful && response.body() != null){
            _animes.emit(response.body()!!)
        }
    }
}