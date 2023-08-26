package com.marmatsan.tracker_ui.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.marmatsan.core_domain.util.UiEvent
import com.marmatsan.core_ui.LocalSpacing
import com.marmatsan.tracker_ui.R
import com.marmatsan.tracker_ui.search.SearchEvent
import com.marmatsan.tracker_ui.search.SearchState
import com.marmatsan.tracker_ui.search.SearchViewModel

@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    mealName: String,
    dayOfMonth: Int,
    month: Int,
    year: Int,
    onNavigateUp: () -> Unit,
    snackbarHostState: SnackbarHostState,
    viewModel: SearchViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(keyboardController) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                    keyboardController?.hide()
                }

                is UiEvent.NavigateUp -> onNavigateUp()
                else -> Unit
            }
        }
    }
    SearchScreenContent(
        mealName = mealName,
        state = viewModel.state,
        onValueChange = {
            viewModel.onEvent(SearchEvent.OnQueryChange(it))
        },
        onSearch = {
            viewModel.onEvent(SearchEvent.OnSearch)
        },
        onFocusChanged = {
            viewModel.onEvent(SearchEvent.OnSearchFocusChange(it.isFocused))
        }
    )
}

@Composable
fun SearchScreenContent(
    mealName: String,
    state: SearchState,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    onFocusChanged: (FocusState) -> Unit
) {
    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceMedium)
    ) {
        Text(
            text = stringResource(id = R.string.add_meal, mealName),
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(
            modifier = Modifier.height(spacing.spaceMedium)
        )
        SearchTextField(
            text = state.query,
            onValueChange = {
                onValueChange(it)
            },
            onSearch = {
                onSearch()
            },
            onFocusChanged = {
                onFocusChanged(it)
            }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun SearchScreenContentPreview() {
    SearchScreenContent(
        mealName = "Rice",
        state = SearchState(),
        onValueChange = { },
        onSearch = { },
        onFocusChanged = { }
    )
}