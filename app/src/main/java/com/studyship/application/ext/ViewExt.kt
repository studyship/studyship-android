package com.studyship.application.ext

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

fun Context.showToast(@StringRes toastText: Int, durationTime: Int) =
    Toast.makeText(
        this,
        toastText, durationTime
    ).show()

interface ViewPagerResource {
    fun getTitle(position: Int): String
}

fun TabLayout.setUpViewPager(
    viewPager2: ViewPager2,
    viewPagerResource: ViewPagerResource,
    autoRefresh: Boolean
) {
    TabLayoutMediator(
        this,
        viewPager2,
        autoRefresh,
        TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = viewPagerResource.getTitle(position)
        }).attach()
}

fun View.showSnackBar(@StringRes message: Int, duration: Int) =
    Snackbar.make(this, message, duration).show()