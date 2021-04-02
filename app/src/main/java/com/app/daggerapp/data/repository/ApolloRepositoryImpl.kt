package com.app.daggerapp.data.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.app.daggerapp.LaunchListQuery
import com.app.daggerapp.domain.ApolloRepository
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ApolloRepositoryImpl @Inject constructor(private val apolloClient: ApolloClient) :
    ApolloRepository {

    override fun getListRxSingle(): Single<LaunchListQuery.Data> {
        val call = apolloClient.query(LaunchListQuery())
        return Rx2Apollo.from(call)
            .filter { it.data != null }
            .map { it.data!! }
            .singleOrError()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getListRx(): Observable<LaunchListQuery.Data> {
        val call = apolloClient.query(LaunchListQuery())
        return Rx2Apollo.from(call)
            .filter { it.data != null }
            .map { it.data!! }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
