package com.marmatsan.core_domain.model

import kotlinx.serialization.Serializable

@Serializable
sealed class Gender {
    enum class GenderType {
        MALE, FEMALE, UNKNOWN
    }

    object Male : Gender()
    object Female : Gender()
    object Unknown : Gender()

    companion object {
        fun fromType(type: GenderType): Gender {
            return when (type) {
                GenderType.MALE -> Male
                GenderType.FEMALE -> Female
                GenderType.UNKNOWN -> Unknown
            }
        }
    }
}