package com.studyship.application.util

import io.reactivex.subjects.BehaviorSubject

interface BackKeyPressUtil {
    val backKeyBehaviorSubject: BehaviorSubject<Long>

    fun onPressedBackKey()
}