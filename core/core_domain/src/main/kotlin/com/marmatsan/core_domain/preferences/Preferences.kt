package com.marmatsan.core_domain.preferences

import com.marmatsan.core_domain.model.UserInfo

interface Preferences {
    fun saveUserInfo(userInfo: UserInfo)
    fun loadUserInfo(): UserInfo
}