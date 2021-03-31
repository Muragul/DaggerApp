package com.app.daggerapp.domain

import com.app.daggerapp.data.model.Category
import java.util.*
import javax.inject.Inject

class ListUseCase @Inject constructor(private val listRepository: ListRepository) {

    suspend fun loadData(): List<Category> = listRepository.loadData()
}