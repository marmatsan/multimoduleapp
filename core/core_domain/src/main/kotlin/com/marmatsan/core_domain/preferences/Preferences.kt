package com.marmatsan.core_domain.preferences

import com.marmatsan.core_domain.model.ActivityLevel
import com.marmatsan.core_domain.model.Gender
import com.marmatsan.core_domain.model.WeightGoal
import com.marmatsan.core_domain.model.UserInfo
import kotlinx.coroutines.flow.Flow

interface Preferences {

    suspend fun saveGender(gender: Gender)
    suspend fun saveAge(age: Int)
    suspend fun saveWeight(weight: Float)
    suspend fun saveHeight(height: Int)
    suspend fun saveActivityLevel(activityLevel: ActivityLevel)
    suspend fun saveGoalType(weightGoal: WeightGoal)
    suspend fun saveCarbRatio(carbRatio: Float)
    suspend fun saveProteinRatio(proteinRatio: Float)
    suspend fun saveFatRatio(fatRatio: Float)

    suspend fun loadPreferencesData(): Flow<PreferencesData>

    suspend fun saveShouldShowOnboarding(shouldShow: Boolean)
}