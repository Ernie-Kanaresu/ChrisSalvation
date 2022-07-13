package com.example.dummydictionary.network

import com.example.dummydictionary.network.dto.LoginRequest
import com.example.dummydictionary.network.dto.LoginResponse
import com.example.dummydictionary.network.dto.WordsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WordService {

    @GET("/words")
    suspend fun  getAllWord(): WordsResponse

    @POST("/login")
    suspend fun login(@Body credentials: LoginRequest): LoginResponse
}