package com.app.daggerapp.data.repository

import LaunchListQuery
import android.util.Log
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import com.app.daggerapp.domain.ApolloRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApolloRepositoryImpl @Inject constructor(private val apolloClient: ApolloClient) :
    ApolloRepository {
    override fun getLaunchList() {
        CoroutineScope(Dispatchers.IO).launch {
            apolloClient.query(LaunchListQuery())
                .responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)
                .enqueue(object : ApolloCall.Callback<LaunchListQuery.Data>() {
                    override fun onResponse(response: Response<LaunchListQuery.Data>) {
                        Log.e("LaunchList", "Success ${response.data}")
                    }

                    override fun onFailure(e: ApolloException) {
                    }

                })
        }
    }
}