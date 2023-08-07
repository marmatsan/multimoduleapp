package com.marmatsan.tracker_data.repository

import com.marmatsan.tracker_data.mapper.toTrackableFood
import com.marmatsan.tracker_data.remote.api.OpenFoodApi
import com.marmatsan.tracker_domain.model.TrackableFood
import com.marmatsan.tracker_domain.repository.RequestState
import com.marmatsan.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TrackerRepositoryImpl(
    private val api: OpenFoodApi
) : TrackerRepository {

    override suspend fun searchFood(
        page: Int,
        pageSize: Int
    ): Flow<RequestState<List<TrackableFood>>> {
        return flow {
            emit(RequestState.Loading(isLoading = true))

            val remoteProducts = try {
                val response = api.searchFood(
                    page = page,
                    pageSize = pageSize
                )
                response.products.mapNotNull { it.toTrackableFood() }
            } catch (e: Exception) { // TODO: Ktor error handling
                emit(RequestState.Error(e.message.orEmpty()))
                null
            }

            emit(RequestState.Success(remoteProducts))

        }
    }

}