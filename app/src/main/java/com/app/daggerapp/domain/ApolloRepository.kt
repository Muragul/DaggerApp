package com.app.daggerapp.domain

import androidx.lifecycle.LiveData


interface ApolloRepository {
    fun getLaunchList(): LiveData<LaunchListQuery.Data>
}