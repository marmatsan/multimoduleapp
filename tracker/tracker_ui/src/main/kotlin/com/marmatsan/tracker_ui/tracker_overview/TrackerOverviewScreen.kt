package com.marmatsan.tracker_ui.tracker_overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.marmatsan.core_domain.util.UiEvent
import com.marmatsan.core_ui.LocalSpacing
import com.marmatsan.tracker_ui.tracker_overview.components.DaySelector
import com.marmatsan.tracker_ui.tracker_overview.components.ExpandableMeal
import com.marmatsan.tracker_ui.tracker_overview.components.NutrientsHeader

@Composable
fun TrackerOverviewScreen(
    modifier: Modifier = Modifier,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    TrackerOverviewScreenContent(
        modifier = modifier,
        state = viewModel.state,
        onPreviousDayClick = {
            viewModel.onEvent(TrackerOverviewEvent.OnPreviousDayClick)
        },
        onNextDayClick = {
            viewModel.onEvent(TrackerOverviewEvent.OnNextDayClick)
        },
        onToggleClick = {
            viewModel.onEvent(TrackerOverviewEvent.OnToggleMealClick(it))
        }
    )
}

@Composable
fun TrackerOverviewScreenContent(
    modifier: Modifier,
    state: TrackerOverviewState,
    onPreviousDayClick: () -> Unit,
    onNextDayClick: () -> Unit,
    onToggleClick: (MealUi) -> Unit
) {
    val spacing = LocalSpacing.current

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(
                bottom = spacing.spaceMedium
            )
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            NutrientsHeader(
                state = state
            )
            Spacer(
                modifier = Modifier.height(spacing.spaceMedium)
            )
            DaySelector(
                date = state.date,
                onPreviousDayClick = onPreviousDayClick,
                onNextDayClick = onNextDayClick,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = spacing.spaceMedium
                    )
            )
            Spacer(
                modifier = Modifier.height(spacing.spaceMedium)
            )
        }
        items(state.meals) { meal ->
            ExpandableMeal(
                meal = meal,
                onToggleClick = {
                    onToggleClick(meal)
                },
                content = {

                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackerOverviewScreenContentPreview() {
    TrackerOverviewScreenContent(
        modifier = Modifier,
        state = TrackerOverviewState(),
        onPreviousDayClick = { },
        onNextDayClick = { },
        onToggleClick = { }
    )
}