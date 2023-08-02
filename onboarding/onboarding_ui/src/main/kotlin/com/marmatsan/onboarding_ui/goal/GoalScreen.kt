package com.marmatsan.onboarding_ui.goal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.marmatsan.core_domain.R
import com.marmatsan.core_domain.model.Goal
import com.marmatsan.core_domain.util.UiEvent
import com.marmatsan.core_ui.LocalSpacing
import com.marmatsan.onboarding_ui.components.ActionButton
import com.marmatsan.onboarding_ui.components.SelectableButton

@Composable
fun GoalScreen(
    modifier: Modifier = Modifier,
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GoalViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
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
                text = stringResource(id = R.string.lose_keep_or_gain_weight)
            )
            Spacer(modifier = modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = R.string.lose),
                    isSelected = viewModel.selectedGoal is Goal.LoseWeight,
                    onClick = {
                        viewModel.onGoalTypeSelect(Goal.LoseWeight)
                    }
                )
                Spacer(modifier = modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.keep),
                    isSelected = viewModel.selectedGoal is Goal.KeepWeight,
                    onClick = {
                        viewModel.onGoalTypeSelect(Goal.KeepWeight)
                    }
                )
                Spacer(modifier = modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.gain),
                    isSelected = viewModel.selectedGoal is Goal.GainWeight,
                    onClick = {
                        viewModel.onGoalTypeSelect(Goal.GainWeight)
                    }
                )
            }
        }
        ActionButton(
            text = stringResource(id = R.string.next),
            onClick = viewModel::onNextClick,
            modifier = modifier.align(Alignment.BottomEnd)
        )
    }
}