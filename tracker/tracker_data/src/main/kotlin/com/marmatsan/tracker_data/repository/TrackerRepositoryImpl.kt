package com.marmatsan.tracker_data.repository

import com.marmatsan.tracker_data.remote.api.OpenFoodApi
import com.marmatsan.tracker_domain.model.TrackableFood
import com.marmatsan.tracker_domain.repository.RequestState
import com.marmatsan.tracker_domain.repository.TrackerRepository

class TrackerRepositoryImpl(
    private val api: OpenFoodApi
) : TrackerRepository {

    override suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): RequestState<List<TrackableFood>> {

    }

}