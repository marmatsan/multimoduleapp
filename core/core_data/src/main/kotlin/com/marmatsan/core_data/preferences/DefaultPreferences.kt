package com.marmatsan.core_data.preferences

import androidx.datastore.core.DataStore
import com.marmatsan.core_domain.model.ActivityLevel
import com.marmatsan.core_domain.model.Gender
import com.marmatsan.core_domain.model.WeightGoal
import com.marmatsan.core_domain.model.UserInfo
import com.marmatsan.core_domain.preferences.Preferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultPreferences @Inject constructor(
    private val dataStore: DataStore<UserInfo>
) : Preferences {

    override suspend fun saveGender(gender: Gender) {
        dataStore.updateData {
            it.copy(
                gender = gender,
            )
        }
    }

    override suspend fun saveAge(age: Int) {
        dataStore.updateData {
            it.copy(
                age = age,
            )
        }
    }

    override suspend fun saveWeight(weight: Float) {
        dataStore.updateData {
            it.copy(
                weight = weight,
            )
        }
    }

    override suspend fun saveHeight(height: Int) {
        dataStore.updateData {
            it.copy(
                height = height,
            )
        }
    }

    override suspend fun saveActivityLevel(activityLevel: ActivityLevel) {
        dataStore.updateData {
            it.copy(
                activityLevel = activityLevel,
            )
        }
    }

    override suspend fun saveGoalType(weightGoal: WeightGoal) {
        dataStore.updateData {
            it.copy(
                weightGoal = weightGoal,
            )
        }
    }

    override suspend fun saveCarbRatio(carbRatio: Float) {
        dataStore.updateData {
            it.copy(
                carbRatio = carbRatio,
            )
        }
    }

    override suspend fun saveProteinRatio(proteinRatio: Float) {
        dataStore.updateData {
            it.copy(
                proteinRatio = proteinRatio,
            )
        }
    }

    override suspend fun saveFatRatio(fatRatio: Float) {
        dataStore.updateData {
            it.copy(
                fatRatio = fatRatio,
            )
        }
    }

    override suspend fun loadUserInfo(): Flow<UserInfo> {
        return dataStore.data
    }
}