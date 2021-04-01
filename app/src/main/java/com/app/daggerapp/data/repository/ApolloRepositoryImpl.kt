package com.app.daggerapp.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import com.app.daggerapp.LaunchListQuery
import com.app.daggerapp.domain.ApolloRepository
import javax.inject.Inject
import kotlin.reflect.typeOf

class ApolloRepositoryImpl @Inject constructor(private val apolloClient: ApolloClient) :
    ApolloRepository {

    var result = MutableLiveData<LaunchListQuery.Data>()
    override fun getLaunchList(): LiveData<LaunchListQuery.Data> {
        apolloClient.query(LaunchListQuery())
            .responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)
            .enqueue(object : ApolloCall.Callback<LaunchListQuery.Data>() {
                override fun onResponse(response: Response<LaunchListQuery.Data>) {
                    result.postValue(response.data)
                    Log.e("LaunchList RESULT", response.data?.javaClass.toString())
                }

                override fun onFailure(e: ApolloException) {
                    Log.e("LaunchList", "Failure", e)
                }
            })
        return result
    }
}
