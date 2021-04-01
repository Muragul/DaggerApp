package com.app.daggerapp.domain

import com.app.daggerapp.data.model.ParentModel
import javax.inject.Inject

class NestedRvUseCase @Inject constructor(private val nestedRvRepository: NestedRvRepository) {
    fun loadRvData(count: Int): List<ParentModel> = nestedRvRepository.loadRvData(count)
}