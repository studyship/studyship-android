package com.tsdev.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.ext.AnimatedMutableLiveData
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
    val checkPassword = MutableLiveData<String>()

    //todo 여럿 LiveData 를 한번에 적용시키는 방법 확인.

    val animatedMutableLiveData = AnimatedMutableLiveData<Boolean>()

    var section = 0

    //퍼블리쉬 서브젝트 -> 구독하는 순간부터 데이터 발행.
    private val inputBehaviorSubject = PublishSubject.create<String>()

    private val _isFinish = MutableLiveData<Boolean>()

    val isFinish: LiveData<Boolean>
        get() = _isFinish

    private val _isSuccess = MutableLiveData<Boolean>()

    val isSuccess: LiveData<Boolean>
        get() = _isSuccess


    private val _backButtonState = SingleMutableEvent<Boolean>()

    val backButtonState: SingleEvent<Boolean>
        get() = _backButtonState

    //error message list

    private val _nickNameErrorMessage = MutableLiveData<String>()

    val nickNameErrorMessage: LiveData<String>
        get() = _nickNameErrorMessage

    private val _emailErrorMessage = MutableLiveData<String>()

    val emailErrorMessage: LiveData<String>
        get() = _emailErrorMessage

    private val _passwordErrorMessage = MutableLiveData<String>()

    val passwordErrorMessage: LiveData<String>
        get() = _passwordErrorMessage

    private val _passwordCheckErrorMessage = MutableLiveData<String>()

    val passwordCheckErrorMessage: LiveData<String>
        get() = _passwordCheckErrorMessage


    init {
        _isSuccess.value = false
        _isFinish.value = false

        disposable.add(
            inputBehaviorSubject.debounce(1500L, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    if (it.isNotEmpty()) {
                        _isSuccess.value = true
                    }
                }
        )

        //email, password, passwordCheck
        animatedMutableLiveData.setterAnimatedInitData(
            MutableLiveData(),
            MutableLiveData(),
            MutableLiveData()
        )
    }

    fun onClickNextInformation() {
        _isSuccess.value = false
        inputBehaviorSubject.onNext(EMPTY_STRING)
        animatedMutableLiveData.onChangeValue(section) {
            it.value = true
        }
        section++
        if (section >= FINAL_SECTION) {
            _isFinish.value = true
        }
        Log.d("클릭리스너 확인용", "클릭")
    }

    fun onClickFinishListener() {
        //todo 회원가입 api 태워야함.

        Log.d("클릭리스너 확인용", "클릭")
    }

    fun onChangeListener(
        s: CharSequence,
        regex: String,
        errorMessage: String
    ) {
        if (s.toString().isNotEmpty()) {
            //regex 체크.
            Log.e("regex 체크", regex.toRegex().matches(s.toString()).toString())
            if (!regex.toRegex().matches(s.toString())) {
                _isSuccess.value = false
                setErrorMessageState(regex, errorMessage)
                return
            }
            s.toString().isHadBlack { c: Char -> c != ' ' }.let {
                if (it) {
                    inputBehaviorSubject.onNext(s.toString())
                    setPassErrorMessageState()
                    Log.d("VALUE", s.toString())
                } else {
                    _isSuccess.value = false
                    setErrorMessageState(regex, errorMessage)
                }
            }
        } else {
            _isSuccess.value = false
            setPassErrorMessageState()
        }
    }

    fun onCheckSamePassword(text: CharSequence, message: String) {
        if (password.value != text.toString()) {
            _passwordCheckErrorMessage.value = message
        } else {
            _passwordCheckErrorMessage.value = null
        }
    }

    fun backButtonClickListener() {
        _backButtonState.event = true
        section = 0
    }

    private fun setErrorMessageState(regex: String, message: String) {
        when (regex) {
            SignUpRegex.EMAIL -> {
                _emailErrorMessage.value = message
            }
            SignUpRegex.NICKNAME -> {
                _nickNameErrorMessage.value = message
            }
            SignUpRegex.PASSWORD -> {
                _passwordErrorMessage.value = message
            }
        }
    }

    private fun setPassErrorMessageState() {
        _emailErrorMessage.value = null
        _nickNameErrorMessage.value = null
        _passwordErrorMessage.value = null
        _passwordCheckErrorMessage.value = null
    }

    companion object {
        private const val EMPTY_STRING = ""
        private const val FINAL_SECTION = 3
    }
}