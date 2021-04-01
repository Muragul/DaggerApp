package com.app.daggerapp.ui.apollo

import androidx.lifecycle.ViewModel
import com.app.daggerapp.domain.ApolloUseCase
import javax.inject.Inject

class ApolloViewModel @Inject constructor(private val apolloUseCase: ApolloUseCase) : ViewModel() {
//    suspend fun getLaunchList(): List<LaunchListQuery.Launch> = apolloUseCase.getLaunchList()
    suspend fun getLaunchList() = apolloUseCase.getLaunchList()
}