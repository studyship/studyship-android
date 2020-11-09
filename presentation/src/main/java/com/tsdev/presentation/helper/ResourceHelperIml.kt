package com.tsdev.presentation.helper

import android.content.Context

internal class ResourceHelperIml(private val context: Context) : ResourceHelper {
    override fun getStringRes(resourceId: Int): String {
        return context.getString(resourceId)
    }

    override fun getDrawableRes() {
        //todo no-op
    }

}