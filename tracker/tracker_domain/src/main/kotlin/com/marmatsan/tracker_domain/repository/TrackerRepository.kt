package com.marmatsan.tracker_domain.repository

import com.marmatsan.tracker_domain.model.TrackableFood

interface TrackerRepository {

    suspend fun searchFood(
        query: String,
        page: Int,
        pageSize: Int
    ): RequestState<List<TrackableFood>>

}