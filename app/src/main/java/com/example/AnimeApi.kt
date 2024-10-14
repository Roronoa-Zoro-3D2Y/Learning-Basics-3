package com.example

import com.example.learningbasics3.models.Anime
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface AnimeApi {

    @GET("/v3/b/66f134c5acd3cb34a889a0c8?meta=false")
    suspend fun getAnimeNames(@Header("X-JSON-Path") category: String) : Response<List<Anime>>

    @GET("/v3/b/66f134c5acd3cb34a889a0c8?meta=false")
    @Headers("X-JSON-Path: Anime..category")
    suspend fun getCategory() : Response<List<String>>

}