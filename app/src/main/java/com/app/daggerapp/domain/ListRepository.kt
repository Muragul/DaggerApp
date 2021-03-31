package com.app.daggerapp.domain

import com.app.daggerapp.data.model.Category

interface ListRepository {
    suspend fun loadData(): List<Category>
}