package com.app.daggerapp.ui.apollo

import androidx.lifecycle.ViewModel
import com.app.daggerapp.LaunchListQuery
import com.app.daggerapp.domain.ApolloUseCase
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ApolloViewModel @Inject constructor(private val apolloUseCase: ApolloUseCase) : ViewModel() {
    fun getListRx(): Observable<LaunchListQuery.Data> = apolloUseCase.getListRx()
    fun getListRxSingle(): Single<LaunchListQuery.Data> = apolloUseCase.getListRxSingle()
}