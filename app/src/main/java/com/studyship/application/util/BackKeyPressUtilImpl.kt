package com.studyship.application.util

import android.widget.Toast
import com.studyship.application.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class BackKeyPressUtilImpl(
    compositeDisposable: CompositeDisposable,
    finish: () -> Unit,
    showToast: (Int, Int) -> Unit,
    showErrorToast: (Int, Int) -> Unit
) : BackKeyPressUtil {
    override val backKeyBehaviorSubject: BehaviorSubject<Long> = BehaviorSubject.createDefault(0L)

    init {
        compositeDisposable += backKeyBehaviorSubject
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .buffer(2, 1)
            .map { it[0] to it[1] }
            .onErrorReturn {
                showErrorToast(R.string.back_key_error_string, Toast.LENGTH_LONG)
                Pair(ERROR_STATE, ERROR_STATE)
            }
            .subscribe {
                if (it.first + BACK_KEY_INTERVAL < it.second ) {
                    showToast(R.string.back_button_click_message, Toast.LENGTH_LONG)
                } else {
                    finish()
                }
            }
    }


    override fun onPressedBackKey() {
        backKeyBehaviorSubject.onNext(System.currentTimeMillis())
    }

    companion object {
        const val ERROR_STATE = -9999L

        const val BACK_KEY_INTERVAL = 2000L
    }
}