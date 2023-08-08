package com.marmatsan.tracker_domain.repository

import com.marmatsan.tracker_domain.model.TrackableFood
import kotlinx.coroutines.flow.Flow

interface TrackerRepository {

    suspend fun searchFood(
        page: Int,
        pageSize: Int
    ): Flow<RequestState<List<TrackableFood>>>

}