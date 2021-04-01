package com.app.daggerapp.data.repository

import com.app.daggerapp.data.model.ParentModel
import com.app.daggerapp.domain.NestedRvRepository

class NestedRvRepositoryImpl : NestedRvRepository {
    override fun loadRvData(count: Int): List<ParentModel> = ParentDataFactory.getParents(count)
}