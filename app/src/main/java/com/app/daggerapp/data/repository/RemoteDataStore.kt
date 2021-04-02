package com.app.daggerapp.data.repository

import com.app.daggerapp.data.api.ApiService
import com.app.daggerapp.data.model.CategoryResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RemoteDataStore @Inject constructor(private val apiService: ApiService) {

    fun fetchDataRx(): Observable<CategoryResponse> {
        return apiService.getPostList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}