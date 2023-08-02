package com.marmatsan.onboarding_ui.nutrient_goal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.marmatsan.core_domain.R
import com.marmatsan.core_domain.util.UiEvent
import com.marmatsan.core_ui.LocalSpacing
import com.marmatsan.onboarding_ui.components.ActionButton
import com.marmatsan.onboarding_ui.components.UnitTextField

@Composable
fun NutrientGoalScreen(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: NutrientGoalViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                }

                else -> Unit
            }
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.what_are_your_nutrient_goals)
            )
            Spacer(modifier = modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.carbsPct,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnCarbPctEnter(it))
                },
                unit = stringResource(id = R.string.percent_carbs)
            )
            Spacer(modifier = modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.proteinPct,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnProteinPctEnter(it))
                },
                unit = stringResource(id = R.string.percent_proteins)
            )
            Spacer(modifier = modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.fatPct,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnFatPctEnter(it))
                },
                unit = stringResource(id = R.string.percent_fats)
            )
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = {
                viewModel.onEvent(NutrientGoalEvent.OnNextClick)
            },
            modifier = modifier.align(Alignment.BottomEnd)
        )
    }
}