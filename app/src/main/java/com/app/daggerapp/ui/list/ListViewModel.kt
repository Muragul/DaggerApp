package com.app.daggerapp.ui.list

import androidx.lifecycle.ViewModel
import com.app.daggerapp.domain.ListUseCase
import javax.inject.Inject

class ListViewModel @Inject constructor(private val listUseCase: ListUseCase) : ViewModel() {
    suspend fun loadData() = listUseCase.loadData()
}