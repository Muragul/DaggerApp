package com.app.daggerapp.domain

import com.app.daggerapp.data.model.ParentModel

interface NestedRvRepository {
    fun loadRvData(count: Int): List<ParentModel>
}