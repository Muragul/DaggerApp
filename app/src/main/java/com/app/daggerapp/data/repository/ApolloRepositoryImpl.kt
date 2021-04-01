package com.app.daggerapp.data.repository

import LaunchListQuery
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import com.app.daggerapp.domain.ApolloRepository
import javax.inject.Inject

class ApolloRepositoryImpl @Inject constructor(private val apolloClient: ApolloClient) :
    ApolloRepository {
    override suspend fun getLaunchList() {
        apolloClient.query(LaunchListQuery())
            .responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)
            .enqueue(object : ApolloCall.Callback<LaunchListQuery.Data>() {
                override fun onResponse(response: Response<LaunchListQuery.Data>) {
                    Log.e("LaunchList RESULT", response.data.toString())
                }

                override fun onFailure(e: ApolloException) {
                    Log.e("LaunchList", "Failure", e)
                }
            })
    }

/*    override suspend fun getLaunchList(): List<LaunchListQuery.Launch> {
        val result = mutableListOf<LaunchListQuery.Launch>()
        apolloClient.query(LaunchListQuery())
            .responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)
            .enqueue(object : ApolloCall.Callback<LaunchListQuery.Data>() {
                override fun onResponse(response: Response<LaunchListQuery.Data>) {
                    Log.e("LaunchList RESULT", response.data.toString())
                    response.data?.launches?.launches?.filterNotNull().let {
                        if (it != null) {
                            result.addAll(it)
                        }
                    }
                }
                override fun onFailure(e: ApolloException) {
                    Log.e("LaunchList", "Failure", e)
                }
            })
        return result
    }

 */
}
