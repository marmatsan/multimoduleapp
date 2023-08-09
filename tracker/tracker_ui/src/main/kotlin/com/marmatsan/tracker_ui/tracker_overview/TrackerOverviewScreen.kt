package com.marmatsan.tracker_ui.tracker_overview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.marmatsan.core_domain.util.UiEvent
import com.marmatsan.core_ui.LocalSpacing
import com.marmatsan.tracker_ui.tracker_overview.components.NutrientsHeader

@Composable
fun TrackerOverviewScreen(
    modifier: Modifier = Modifier,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    TrackerOverviewScreenContent(
        modifier = modifier,
        state = viewModel.state
    )
}

@Composable
fun TrackerOverviewScreenContent(
    modifier: Modifier,
    state: TrackerOverviewState
) {
    val spacing = LocalSpacing.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                bottom = spacing.spaceMedium
            )
    ) {
        item {
            NutrientsHeader(
                state = state
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun TrackerOverviewScreenContentPreview() {
    //TrackerOverviewScreenContent()
}

// TODO: Create preview