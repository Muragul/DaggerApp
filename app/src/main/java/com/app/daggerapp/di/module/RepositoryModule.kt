package com.app.daggerapp.di.module

import com.apollographql.apollo.ApolloClient
import com.app.daggerapp.data.model.AppDao
import com.app.daggerapp.data.repository.ApolloRepositoryImpl
import com.app.daggerapp.data.repository.ListRepositoryImpl
import com.app.daggerapp.data.repository.RemoteDataStore
import com.app.daggerapp.data.repository.UserRepositoryImpl
import com.app.daggerapp.domain.ApolloRepository
import com.app.daggerapp.domain.ListRepository
import com.app.daggerapp.domain.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(appDao: AppDao): UserRepository = UserRepositoryImpl(appDao)

    @Singleton
    @Provides
    fun provideListRepository(remoteDataStore: RemoteDataStore): ListRepository =
        ListRepositoryImpl(remoteDataStore)

    @Singleton
    @Provides
    fun provideApolloRepository(apolloClient: ApolloClient): ApolloRepository =
        ApolloRepositoryImpl(apolloClient)
}