package com.studyship.application.di

import com.studyship.application.helper.Permission
import com.studyship.application.helper.PermissionImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val permissionModule = module {
    factory<Permission> { PermissionImpl(
        androidContext()
    ) }
}