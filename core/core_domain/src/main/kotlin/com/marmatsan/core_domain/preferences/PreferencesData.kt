package com.marmatsan.core_domain.preferences

import com.marmatsan.core_domain.model.UserInfo

data class PreferencesData(
    val userInfo: UserInfo,
    val shouldShowOnboarding: Boolean
)
