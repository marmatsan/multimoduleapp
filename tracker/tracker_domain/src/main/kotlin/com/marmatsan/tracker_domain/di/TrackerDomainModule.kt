package com.marmatsan.tracker_domain.di

import com.marmatsan.tracker_domain.repository.TrackerRepository
import com.marmatsan.tracker_domain.use_case.SearchFood
import com.marmatsan.tracker_domain.use_case.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(repository: TrackerRepository): TrackerUseCases {
        return TrackerUseCases(
            searchFood = SearchFood(repository)
        )
    }
}