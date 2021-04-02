package com.app.daggerapp.domain

import com.app.daggerapp.data.model.CategoryResponse
import io.reactivex.Observable
import javax.inject.Inject

class ListUseCase @Inject constructor(private val listRepository: ListRepository) {
    fun loadDataRx(): Observable<CategoryResponse> = listRepository.loadDataRx()
}