package com.tsdev.presentation

import com.tsdev.presentation.base.BaseViewModel
import name.Activity
import navigation.NavigationAction

class MyProfileViewModel : BaseViewModel() {

    fun onMoveUserInfo() {
        navigationAction.event = NavigationAction.Move(Activity.USER_INFO)
    }
}