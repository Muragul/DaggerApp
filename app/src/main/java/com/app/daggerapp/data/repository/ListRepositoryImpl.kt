package com.app.daggerapp.data.repository

import com.app.daggerapp.data.model.Category
import com.app.daggerapp.domain.ListRepository
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(private val dataStore: RemoteDataStore) :
    ListRepository {
    override suspend fun loadData(): List<Category> {
        return dataStore.fetchData()
    }
}