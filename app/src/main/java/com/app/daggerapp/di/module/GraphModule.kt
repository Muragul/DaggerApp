package com.app.daggerapp.di.module

import com.apollographql.apollo.ApolloClient
import com.app.daggerapp.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class GraphModule {

    companion object {
        private const val BASE_URL = "https://apollo-fullstack-tutorial.herokuapp.com/"
    }

    @Provides
    @Singleton
    fun provideApolloClient(@Named("graphql_client") okHttpClient: OkHttpClient): ApolloClient =
        ApolloClient.builder()
            .serverUrl(BASE_URL)
            .okHttpClient(okHttpClient)
            .build()

    @Provides
    @Singleton
    @Named("graphql_interceptor")
    fun provideInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor()
            .setLevel(
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
            )

    @Provides
    @Singleton
    @Named("graphql_client")
    fun provideOkHttpClient(@Named("graphql_interceptor") httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
}