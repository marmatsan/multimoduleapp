package com.marmatsan.onboarding_ui.age

import androidx.compose.foundation.layout.*
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.marmatsan.core_domain.R
import com.marmatsan.core_domain.util.UiEvent
import com.marmatsan.core_ui.LocalSpacing
import com.marmatsan.onboarding_ui.components.ActionButton
import com.marmatsan.onboarding_ui.components.UnitTextField

@Composable
fun AgeScreen(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    onNavigate: (UiEvent.Navigate) -> Unit,
    onNavigateBack: () -> Unit,
    viewModel: AgeViewModel = hiltViewModel()
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

                is UiEvent.NavigateBack -> {
                    onNavigateBack()
                }

                else -> Unit
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_age)
            )
            Spacer(modifier = modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.age,
                onValueChange = {
                    viewModel.onEvent(AgeEvent.OnAgeEnter(it))
                },
                unit = stringResource(id = R.string.years)
            )
        }
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ActionButton(
                text = stringResource(id = R.string.back),
                onClick = {
                    viewModel.onEvent(AgeEvent.OnBackClicked)
                }
            )
            ActionButton(
                text = stringResource(id = R.string.next),
                onClick = {
                    viewModel.onEvent(AgeEvent.OnNextClicked)
                }
            )
        }
    }
}