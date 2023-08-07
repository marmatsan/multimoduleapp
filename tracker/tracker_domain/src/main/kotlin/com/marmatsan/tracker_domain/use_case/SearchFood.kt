package com.marmatsan.tracker_domain.use_case

import com.marmatsan.tracker_domain.model.TrackableFood
import com.marmatsan.tracker_domain.repository.RequestState
import com.marmatsan.tracker_domain.repository.TrackerRepository
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single

class SearchFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        page: Int = 1,
        pageSize: Int = 40
    ): RequestState<List<TrackableFood>> {
        return try {
            repository
                .searchFood(
                    page = page,
                    pageSize = pageSize
                )
                .map { requestState ->
                    when (requestState) {
                        is RequestState.Loading -> {
                            RequestState.Loading(requestState.isLoading)
                        }

                        is RequestState.Success -> {
                            RequestState.Success(requestState.data)
                        }

                        is RequestState.Error -> {
                            RequestState.Error(requestState.message ?: "Unknown error")
                        }
                    }
                }.single()
        } catch (e: Exception) {
            RequestState.Error("An error occurred: ${e.message}")
        }
    }
}