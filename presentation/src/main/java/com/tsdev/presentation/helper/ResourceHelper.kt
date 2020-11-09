package com.tsdev.presentation.helper

import androidx.annotation.StringRes

interface ResourceHelper {
    fun getStringRes(@StringRes resourceId: Int): String

    fun getDrawableRes()
}