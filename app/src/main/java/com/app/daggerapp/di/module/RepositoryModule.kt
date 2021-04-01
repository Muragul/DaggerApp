package com.app.daggerapp.di.module

import com.apollographql.apollo.ApolloClient
import com.app.daggerapp.data.model.AppDao
import com.app.daggerapp.data.repository.*
import com.app.daggerapp.domain.ApolloRepository
import com.app.daggerapp.domain.ListRepository
import com.app.daggerapp.domain.NestedRvRepository
import com.app.daggerapp.domain.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Inject
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

    @Singleton
    @Provides
    fun provideNestedRvRepository(): NestedRvRepository = NestedRvRepositoryImpl()
}