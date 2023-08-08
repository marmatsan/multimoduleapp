package com.marmatsan.multimoduleapp.navigation

import androidx.navigation.NavController
import com.marmatsan.core_domain.navigation.Route
import com.marmatsan.core_domain.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    navigate(event.route)
}

fun NavController.navigateBack() {
    popBackStack()
}