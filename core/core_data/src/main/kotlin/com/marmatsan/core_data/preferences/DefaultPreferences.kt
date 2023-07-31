package com.marmatsan.core_data.preferences

import com.marmatsan.core_domain.model.ActivityLevel
import com.marmatsan.core_domain.model.Gender
import com.marmatsan.core_domain.model.GoalType
import com.marmatsan.core_domain.model.UserInfo
import com.marmatsan.core_domain.preferences.Preferences

class DefaultPreferences : Preferences {
    override fun saveGender(gender: Gender) {
        TODO("Not yet implemented")
    }

    override fun saveAge(age: Int) {
        TODO("Not yet implemented")
    }

    override fun saveWeight(weight: Float) {
        TODO("Not yet implemented")
    }

    override fun saveHeight(height: Int) {
        TODO("Not yet implemented")
    }

    override fun saveActivityLevel(level: ActivityLevel) {
        TODO("Not yet implemented")
    }

    override fun saveGoalType(type: GoalType) {
        TODO("Not yet implemented")
    }

    override fun saveCarbRatio(ratio: Float) {
        TODO("Not yet implemented")
    }

    override fun saveProteinRatio(ratio: Float) {
        TODO("Not yet implemented")
    }

    override fun saveFatRatio(ratio: Float) {
        TODO("Not yet implemented")
    }

    override fun loadUserInfo(): UserInfo {
        TODO("Not yet implemented")
    }
}