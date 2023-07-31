package com.marmatsan.core_domain.model

sealed class ActivityLevel(val name: String) {
    object Low : ActivityLevel(name = "low")
    object Medium : ActivityLevel(name = "medium")
    object High : ActivityLevel(name = "high")

    companion object {
        fun fromString(name: String): ActivityLevel {
            return when (name) {
                "low" ->  Low
                "medium" -> Medium
                "high" -> High
                else -> throw IllegalArgumentException("Only \"low\", \"medium\" and \"high\" are allowed")
            }
        }
    }
}