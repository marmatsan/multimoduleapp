package com.marmatsan.core_domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserInfo(
    val gender: Gender,
    val age: Int,
    val weight: Float,
    val height: Int,
    val activityLevel: ActivityLevel,
    val weightGoal: WeightGoal,
    val carbRatio: Float,
    val proteinRatio: Float,
    val fatRatio: Float
)