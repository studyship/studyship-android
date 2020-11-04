package com.tsdev.presentation

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel

class SignUpViewModel : BaseViewModel() {
    private val _email = MutableLiveData<String>()

    val email: LiveData<String>
        get() = _email

    private val _isFinish = MutableLiveData<Boolean>()

    val isFinish: LiveData<Boolean>
        get() = _isFinish

    private val _isSuccess = MutableLiveData<Boolean>()

    val isSuccess: LiveData<Boolean>
        get() = _isSuccess

    init {
        _isSuccess.value = false
        _isFinish.value = false
    }

    fun onClickNextInformation(view: View) {

        _isSuccess.value = false
    }

    fun onClickFinishListener(view: View) {
        //todo 회원가입 api 태워야함.
    }
}