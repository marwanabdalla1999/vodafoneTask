package com.example.network.diModules

import com.example.network.NetworkHelper
import com.example.network.networkClient.provideOkHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@Module
@InstallIn(SingletonComponent::class)
object ServicesModule {

    @Provides
    fun provideNetworkClient(): HttpClient {
        return provideOkHttpClient()
    }

    @Provides
    fun provideNetworkHelper(): NetworkHelper {
        return NetworkHelper()
    }
}