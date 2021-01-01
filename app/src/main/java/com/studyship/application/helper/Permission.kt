package com.studyship.application.helper

interface Permission {
    fun isAllowedLocationPermission(): Boolean

    fun requestLocationPermission(callback: (permissions: Array<out String>) -> Unit)

    val permissions: Array<out String>

    val REQUEST_CODE: Int
}