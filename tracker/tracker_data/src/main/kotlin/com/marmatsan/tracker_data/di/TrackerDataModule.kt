package com.marmatsan.tracker_data.di

import com.marmatsan.tracker_data.remote.OpenFoodApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TrackerDataModule {

    @Singleton
    @Provides
    fun provideKtorClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging)
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    @Singleton
    @Provides
    fun provideApi(httpClient: HttpClient): OpenFoodApi? { // TODO: Implementar
        return null
    }
}