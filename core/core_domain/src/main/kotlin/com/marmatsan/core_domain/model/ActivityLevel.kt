package com.marmatsan.core_domain.model

import kotlinx.serialization.Serializable

@Serializable
sealed class ActivityLevel {

    enum class ActivityLevelType {
        LOW, MEDIUM, HIGH
    }

    object Low : ActivityLevel()
    object Medium : ActivityLevel()
    object High : ActivityLevel()

    companion object {
        fun fromType(type: ActivityLevelType): ActivityLevel {
            return when (type) {
                ActivityLevelType.LOW -> Low
                ActivityLevelType.MEDIUM -> Medium
                ActivityLevelType.HIGH -> High
            }
        }
    }
}