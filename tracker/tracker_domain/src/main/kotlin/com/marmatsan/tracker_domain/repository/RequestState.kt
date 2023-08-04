package com.marmatsan.tracker_domain.repository

sealed class RequestState<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : RequestState<T>(data)
    class Error<T>(message: String, data: T? = null) : RequestState<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true) : RequestState<T>()
}