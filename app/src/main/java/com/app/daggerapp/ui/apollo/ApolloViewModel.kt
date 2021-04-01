package com.app.daggerapp.ui.apollo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.daggerapp.domain.ApolloUseCase
import javax.inject.Inject

class ApolloViewModel @Inject constructor(private val apolloUseCase: ApolloUseCase) : ViewModel() {
    fun getLaunchList(): LiveData<LaunchListQuery.Data> = apolloUseCase.getLaunchList()
}