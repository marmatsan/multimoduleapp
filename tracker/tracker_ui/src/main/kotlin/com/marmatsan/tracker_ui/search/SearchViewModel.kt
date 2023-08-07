package com.marmatsan.tracker_ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marmatsan.tracker_domain.use_case.TrackerUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val trackerUseCases: TrackerUseCases
) : ViewModel() {
    fun executeSearch() {
        viewModelScope.launch {
            trackerUseCases.searchFood()
        }
    }
}