package com.app.daggerapp.ui.list

import androidx.lifecycle.ViewModel
import com.app.daggerapp.data.model.CategoryResponse
import com.app.daggerapp.domain.ListUseCase
import io.reactivex.Observable
import javax.inject.Inject

class ListViewModel @Inject constructor(private val listUseCase: ListUseCase) : ViewModel() {
    fun loadDataRx(): Observable<CategoryResponse> = listUseCase.loadDataRx()
}