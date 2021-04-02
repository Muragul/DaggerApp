package com.app.daggerapp.data.repository

import com.app.daggerapp.data.model.CategoryResponse
import com.app.daggerapp.domain.ListRepository
import io.reactivex.Observable
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(private val dataStore: RemoteDataStore) :
    ListRepository {
    override fun loadDataRx(): Observable<CategoryResponse> {
        return dataStore.fetchDataRx()
    }
}