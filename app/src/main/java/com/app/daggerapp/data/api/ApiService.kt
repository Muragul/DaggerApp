package com.app.daggerapp.data.api

import com.app.daggerapp.data.model.CategoryResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    fun getPostList(): Observable<CategoryResponse>
}