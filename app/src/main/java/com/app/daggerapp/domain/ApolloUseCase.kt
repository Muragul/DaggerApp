package com.app.daggerapp.domain

import javax.inject.Inject

class ApolloUseCase @Inject constructor(private val apolloRepository: ApolloRepository) {
//    suspend fun getLaunchList(): List<LaunchListQuery.Launch> = apolloRepository.getLaunchList()
    suspend fun getLaunchList() = apolloRepository.getLaunchList()
}