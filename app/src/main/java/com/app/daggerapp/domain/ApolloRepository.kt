package com.app.daggerapp.domain


interface ApolloRepository {
//    suspend fun getLaunchList(): List<LaunchListQuery.Launch>
    suspend fun getLaunchList()
}