package com.app.daggerapp.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class ApolloUseCase @Inject constructor(private val apolloRepository: ApolloRepository) {
    fun getLaunchList(): LiveData<LaunchListQuery.Data> = apolloRepository.getLaunchList()
}