package com.studyship.application.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.studyship.application.constant.DEBOUNCE_INTERVAL_TIME
import com.tsdev.data.source.SuggestResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit


class SearchActivityViewModel : ViewModel() {

    val disposable by lazy { CompositeDisposable() }

    private val searchKeywordBehaviorSubject = PublishSubject.create<String>()

    private val _suggestList = MutableLiveData<List<SuggestResponse>>()

    val suggestList: LiveData<List<SuggestResponse>>
        get() = _suggestList

    private val _searchKeyword = MutableLiveData<String>()

    val searchKeyword: LiveData<String>
        get() = _searchKeyword


    init {
        _suggestList.value = listOf(
            SuggestResponse("프로토타입"),
            SuggestResponse("디자인"),
            SuggestResponse("스위프트"),
            SuggestResponse("프로토타입"),
            SuggestResponse("프론트앤드")
        )

        disposable.add(
            searchKeywordBehaviorSubject
                .debounce(DEBOUNCE_INTERVAL_TIME, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn {
                    "ERROR!"
                }
                .subscribe {
                    _searchKeyword.value = it
                }
        )
    }

    fun onTextChanged(
        s: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) {
        Log.w("tag", "onTextChanged $s")
        if (s.isNotEmpty()) {
            searchKeywordBehaviorSubject.onNext(s.toString())
        }
    }

//    fun onObservableKeyword(): Observable<String> = searchKeywordBehaviorSubject
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }
}