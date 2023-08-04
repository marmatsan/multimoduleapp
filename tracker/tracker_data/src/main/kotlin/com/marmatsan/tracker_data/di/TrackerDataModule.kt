package com.marmatsan.tracker_data.di


import com.marmatsan.tracker_data.util.ErrorState
import com.marmatsan.tracker_data.remote.api.OpenFoodApi
import com.marmatsan.tracker_data.remote.api.OpenFoodApiImpl
import com.marmatsan.tracker_data.remote.dto.SearchDataDto
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
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
            HttpResponseValidator {
                validateResponse { response ->
                    val searchDto: SearchDataDto = response.body()
                    if (searchDto.products.isEmpty()) {
                        throw ErrorState.EmptySearch()
                    }
                }
            }
        }
    }

    @Singleton
    @Provides
    fun provideApi(httpClient: HttpClient): OpenFoodApi {
        return OpenFoodApiImpl(httpClient)
    }
}