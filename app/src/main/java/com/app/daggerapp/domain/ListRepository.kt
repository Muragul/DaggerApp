package com.app.daggerapp.domain

import com.app.daggerapp.data.model.CategoryResponse
import io.reactivex.Observable

interface ListRepository {
    fun loadDataRx(): Observable<CategoryResponse>
}