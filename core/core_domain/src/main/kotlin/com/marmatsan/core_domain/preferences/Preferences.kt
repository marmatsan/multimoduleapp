package com.marmatsan.core_domain.preferences

import com.marmatsan.core_domain.model.ActivityLevel
import com.marmatsan.core_domain.model.Gender
import com.marmatsan.core_domain.model.GoalType
import com.marmatsan.core_domain.model.UserInfo

interface Preferences {
    fun saveGender(gender: Gender)
    fun saveAge(age: Int)
    fun saveWeight(weight: Float)
    fun saveHeight(height: Int)
    fun saveActivityLevel(level: ActivityLevel)
    fun saveGoalType(type: GoalType)
    fun saveCarbRatio(ratio: Float)
    fun saveProteinRatio(ratio: Float)
    fun saveFatRatio(ratio: Float)

    fun loadUserInfo(): UserInfo
}