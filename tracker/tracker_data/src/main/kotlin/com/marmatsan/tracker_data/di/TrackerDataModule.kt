package com.marmatsan.tracker_data.di

import com.marmatsan.tracker_data.remote.api.OpenFoodApi
import com.marmatsan.tracker_data.remote.api.OpenFoodApiImpl
import com.marmatsan.tracker_data.repository.TrackerRepositoryImpl
import com.marmatsan.tracker_domain.repository.TrackerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TrackerDataModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Singleton
    @Provides
    fun provideKtorClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging)
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                })
            }
            // TODO: Add HttpResponseValidator at some point: https://ktor.io/docs/response-validation.html
        }
    }

    @Singleton
    @Provides
    fun provideApi(httpClient: HttpClient): OpenFoodApi {
        return OpenFoodApiImpl(httpClient)
    }

    @Singleton
    @Provides
    fun provideTrackerRepository(
        api: OpenFoodApi
    ): TrackerRepository {
        return TrackerRepositoryImpl(api)
    }
}