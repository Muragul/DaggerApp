package com.app.daggerapp.data.api

import com.app.daggerapp.data.model.CategoryResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    suspend fun getPostListCoroutineAsync(): Response<CategoryResponse>
}