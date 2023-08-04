package com.marmatsan.tracker_data.remote.api

import com.marmatsan.tracker_data.util.ErrorState
import com.marmatsan.tracker_data.remote.dto.SearchDataDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject

class OpenFoodApiImpl @Inject constructor(
    private val httpClient: HttpClient
) : OpenFoodApi {

    override suspend fun searchFood(
        page: Int,
        pageSize: Int,
        query: String
    ): SearchDataDto {
        return try {
            httpClient.get {

            }.body()
        } catch (e: ErrorState) {
            e.printStackTrace()

        }
    }


}