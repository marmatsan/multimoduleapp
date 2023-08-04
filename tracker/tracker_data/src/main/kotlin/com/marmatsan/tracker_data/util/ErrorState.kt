package com.marmatsan.tracker_data.util

sealed class ErrorState(
    override val message: String
) : Exception() {
    data class EmptySearch(
        override val message: String = "The search did not retrieve any product"
    ) : ErrorState(message = message)

    data class ErroneousSearch(
        override val message: String = "The search failed: Unknown error"
    ) : ErrorState(message = message)
}