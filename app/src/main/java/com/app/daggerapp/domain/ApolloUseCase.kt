package com.app.daggerapp.domain

import com.app.daggerapp.LaunchListQuery
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ApolloUseCase @Inject constructor(private val apolloRepository: ApolloRepository) {
    fun getListRx(): Observable<LaunchListQuery.Data> = apolloRepository.getListRx()
    fun getListRxSingle(): Single<LaunchListQuery.Data> = apolloRepository.getListRxSingle()
}