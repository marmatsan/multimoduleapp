package com.marmatsan.tracker_ui.tracker_overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.marmatsan.core_domain.util.UiEvent
import com.marmatsan.core_ui.LocalSpacing
import com.marmatsan.tracker_domain.model.TrackedFood
import com.marmatsan.tracker_ui.R
import com.marmatsan.tracker_ui.tracker_overview.components.*

@Composable
fun TrackerOverviewScreen(
    modifier: Modifier = Modifier,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(context) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }

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
        },
        onDeleteClick = {
            viewModel.onEvent(
                TrackerOverviewEvent.OnDeleteTrackedFoodClick(it)
            )
        },
        onAddFood = {
            viewModel.onEvent(TrackerOverviewEvent.OnAddFoodClick(it))
        }
    )
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun TrackerOverviewScreenContent(
    modifier: Modifier,
    state: TrackerOverviewState,
    onPreviousDayClick: () -> Unit,
    onNextDayClick: () -> Unit,
    onToggleClick: (MealUi) -> Unit,
    onDeleteClick: (TrackedFood) -> Unit,
    onAddFood: (MealUi) -> Unit
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

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
                modifier = modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = spacing.spaceMedium
                    ),
                date = state.date,
                onPreviousDayClick = onPreviousDayClick,
                onNextDayClick = onNextDayClick
            )
            Spacer(
                modifier = Modifier.height(spacing.spaceMedium)
            )
        }
        items(state.meals) { mealUi ->
            ExpandableMeal(
                modifier = Modifier.fillMaxWidth(),
                meal = mealUi,
                onToggleClick = {
                    onToggleClick(mealUi)
                }
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = spacing.spaceSmall)
                ) {
                    state.trackedFoods.forEach { trackedFood ->
                        TrackedFoodItem(
                            trackedFood = trackedFood,
                            onDeleteClick = {
                                onDeleteClick(trackedFood)
                            }
                        )
                        Spacer(Modifier.height(spacing.spaceMedium))
                    }
                    AddButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(
                            id = R.string.add_meal,
                            mealUi.name.asString(context)
                        ),
                        onClick = {
                            onAddFood(mealUi)
                        }
                    )
                }
            }
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
        onToggleClick = { },
        onDeleteClick = { },
        onAddFood = { }
    )
}