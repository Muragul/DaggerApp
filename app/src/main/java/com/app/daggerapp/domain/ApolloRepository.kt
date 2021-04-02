package com.app.daggerapp.domain

import com.app.daggerapp.LaunchListQuery
import io.reactivex.Observable
import io.reactivex.Single

interface ApolloRepository {
    fun getListRx(): Observable<LaunchListQuery.Data>
    fun getListRxSingle(): Single<LaunchListQuery.Data>
}