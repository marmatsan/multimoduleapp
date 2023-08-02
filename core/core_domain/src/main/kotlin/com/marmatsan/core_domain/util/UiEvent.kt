package com.marmatsan.core_domain.util

sealed class UiEvent {
    data class Navigate(val route: String) : UiEvent()
    object NavigateBack : UiEvent()
    data class ShowSnackBar(val message: UiText) : UiEvent()
}