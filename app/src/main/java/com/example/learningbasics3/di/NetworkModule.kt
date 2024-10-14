package com.example.learningbasics3.di

import com.example.AnimeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent ::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit() :Retrofit{

        return  Retrofit.Builder().baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAnimeApi(retrofit: Retrofit) :AnimeApi{
        return retrofit.create(AnimeApi :: class.java)
    }
}