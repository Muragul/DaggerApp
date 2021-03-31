package com.app.daggerapp.domain

import javax.inject.Inject

class ApolloUseCase @Inject constructor(private val apolloRepository: ApolloRepository) {
    fun getLaunchList() = apolloRepository.getLaunchList()
}