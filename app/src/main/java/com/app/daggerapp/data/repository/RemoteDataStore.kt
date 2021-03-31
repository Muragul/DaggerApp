package com.app.daggerapp.data.repository

import com.app.daggerapp.data.api.ApiService
import com.app.daggerapp.data.model.Category
import javax.inject.Inject

class RemoteDataStore @Inject constructor(private val apiService: ApiService) {
    suspend fun fetchData(): List<Category> {
        val response = apiService.getPostListCoroutineAsync()
        return if (response.isSuccessful) {
            response.body()?.categories ?: emptyList()
        } else {
            emptyList()
        }
    }
}