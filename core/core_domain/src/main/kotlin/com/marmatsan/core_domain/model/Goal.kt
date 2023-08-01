package com.marmatsan.core_domain.model

import kotlinx.serialization.Serializable

@Serializable
sealed class Goal {

    enum class GoalType {
        LOSE_WEIGHT, KEEP_WEIGHT, GAIN_WEIGHT
    }

    object LoseWeight : Goal()
    object KeepWeight : Goal()
    object GainWeight : Goal()

    companion object {
        fun fromType(type: GoalType): Goal {
            return when (type) {
                GoalType.LOSE_WEIGHT -> LoseWeight
                GoalType.KEEP_WEIGHT -> KeepWeight
                GoalType.GAIN_WEIGHT -> GainWeight
            }
        }
    }
}