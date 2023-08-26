package com.marmatsan.tracker_ui.search

data class SearchState(
    val query: String = "", // TODO: Use
    val isHintVisible: Boolean = false,
    val isSearching: Boolean = false,
    val trackableFood: List<TrackableFoodUiState> = emptyList()
)