package com.tsdev.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleMutableEvent
import com.tsdev.presentation.ext.isHadBlack
import com.tsdev.presentation.helper.ResourceHelper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.PublishSubject
import tsthec.tsstudy.constant.SignUpRegex
import java.util.concurrent.TimeUnit

class SignUpViewModel(private val resource: ResourceHelper) : BaseViewModel() {

    //2way data-binding
    val nickname = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    //퍼블리쉬 서브젝트 -> 구독하는 순간부터 데이터 발행.
    private val inputBehaviorSubject = PublishSubject.create<String>()

    private val _isFinish = MutableLiveData<Boolean>()

    val isFinish: LiveData<Boolean>
        get() = _isFinish

    private val _isSuccess = MutableLiveData<Boolean>()

    val isSuccess: LiveData<Boolean>
        get() = _isSuccess

    private val _errorMessage = MutableLiveData<String>()

    val errorMessage: LiveData<String>
        get() = _errorMessage

    private val _backButtonState = SingleMutableEvent<Boolean>()

    val backButtonState: SingleEvent<Boolean>
        get() = _backButtonState

    init {
        _isSuccess.value = false
        _isFinish.value = false

        disposable.add(
            inputBehaviorSubject.debounce(2000L, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isNotEmpty()) {
                        _isSuccess.value = true
                    }
                }
        )
    }

    fun onClickNextInformation() {
        _isSuccess.value = false
        inputBehaviorSubject.onNext(EMPTY_STRING)
    }

    fun onClickFinishListener() {
        //todo 회원가입 api 태워야함.
    }

    fun onChangeListener(
        s: CharSequence,
        regex: String
    ) {
        Log.d("TEST", regex)

        if (s.toString().isNotEmpty()) {
            s.toString().isHadBlack { c: Char -> c != ' ' }.let {
                if (it) {
                    inputBehaviorSubject.onNext(s.toString())
                    _errorMessage.value = null
                    Log.d("VALUE", s.toString())
                } else {
                    _isSuccess.value = false
                    _errorMessage.value = resource.getStringRes(R.string.blank_error_message)
                }
            }

            //regex 체크.
            if (!regex.toRegex().matches(s.toString())) {
                _isSuccess.value = false
                _errorMessage.value = resource.getStringRes(R.string.email_regex_error_message)
                return
            }

        }
    }

    fun backButtonClickListener() {
        _backButtonState.event = true
    }

    companion object {
        private const val EMPTY_STRING = ""
    }
}