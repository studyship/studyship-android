package com.tsdev.presentation

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleLiveData
import com.tsdev.presentation.ext.SingleMutableEvent
import com.tsdev.presentation.ext.isHadBlack
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

class SignUpViewModel : BaseViewModel() {
    private val inputBehaviorSubject = BehaviorSubject.createDefault("")

    private val _email = MutableLiveData<String>()

    val email: LiveData<String>
        get() = _email

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

    fun onClickNextInformation(view: View) {
        _isSuccess.value = false
        inputBehaviorSubject.onNext(EMPTY_STRING)
    }

    fun onClickFinishListener(view: View) {
        //todo 회원가입 api 태워야함.
    }

    fun onNameChangeListener(s: CharSequence, start: Int, before: Int, count: Int) {
        if (s.toString().isNotEmpty()) {
            s.toString().isHadBlack { c: Char -> c != ' ' }.let {
                if (it) {
                    inputBehaviorSubject.onNext(s.toString())
                    _errorMessage.value = null
                    Log.d("VALUE", s.toString())
                } else {
                    _isSuccess.value = false
                    _errorMessage.value = "아이디에 공백이 들어갈 수 없습니다."
                }
            }
        }
    }

    fun backButtonClickListener() {
        _backButtonState.event?.let {

        }
    }

    companion object {
        private const val EMPTY_STRING = ""
    }
}