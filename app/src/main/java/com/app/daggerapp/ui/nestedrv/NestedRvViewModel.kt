package com.app.daggerapp.ui.nestedrv

import androidx.lifecycle.ViewModel
import com.app.daggerapp.data.model.ParentModel
import com.app.daggerapp.domain.NestedRvUseCase
import javax.inject.Inject

class NestedRvViewModel @Inject constructor(private val nestedRvUseCase: NestedRvUseCase) :
    ViewModel() {
    fun loadRvData(count: Int): List<ParentModel> = nestedRvUseCase.loadRvData(count)
}