package com.app.daggerapp.domain

import androidx.lifecycle.LiveData
import com.app.daggerapp.LaunchListQuery


interface ApolloRepository {
    fun getLaunchList(): LiveData<LaunchListQuery.Data>
}