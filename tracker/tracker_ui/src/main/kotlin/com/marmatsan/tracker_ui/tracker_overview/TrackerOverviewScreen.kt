package com.marmatsan.tracker_ui.tracker_overview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun TrackerOverviewScreen(
    viewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    TrackerOverviewScreenContent(
        onExecuteSearch = viewModel::executeSearch
    )
}

@Composable
fun TrackerOverviewScreenContent(
    onExecuteSearch: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = {
                onExecuteSearch()
            }
        ) {
            Text(text = "Make request")
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun TrackerOverviewScreenContentPreview() {
    TrackerOverviewScreenContent(
        onExecuteSearch = { }
    )
}