package com.studyship.application.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

inline fun <reified FRAGMENT : Fragment> AppCompatActivity.loadNavigation(@IdRes fragmentId: Int) =
    supportFragmentManager.findFragmentById(fragmentId) as FRAGMENT?