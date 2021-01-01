package com.studyship.application.helper

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_DENIED
import androidx.core.content.ContextCompat

class PermissionImpl(private val context: Context) :
    Permission {
    override fun isAllowedLocationPermission(): Boolean {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PERMISSION_DENIED
        ) {
            return false
        }
        return true
    }

    override fun requestLocationPermission(callback: (permissions: Array<out String>) -> Unit) {
        if (!isAllowedLocationPermission()) {
            callback(permissions)
        } else {
            //todo get current location
            return
        }
    }

    override val permissions: Array<out String>
        get() = arrayOf(Context.LOCATION_SERVICE)


    override val REQUEST_CODE: Int
        get() = 1001
}