package com.studyship.application.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.studyship.application.constant.DEBOUNCE_INTERVAL_TIME
import com.studyship.application.util.SingleEvent
import com.studyship.application.util.SingleMutableEvent
import com.tsdev.data.source.SuggestResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
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

    private val _showBottomSheetDialog = SingleMutableEvent<Boolean>()
    val showBottomSheetDialog: SingleEvent<Boolean>
        get() = _showBottomSheetDialog

    private val _categoryList = MutableLiveData<List<String>>()

    val categoryList: LiveData<List<String>>
        get() = _categoryList

    private val _selectedCategory = MutableLiveData<String>()

    val selectedCategory: LiveData<String>
        get() = _selectedCategory


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

        _categoryList.value = listOf("카테고리", "지역", "검색필터")
    }

    //databinding 때문에 지울수가 없음
    fun onTextChanged(
        s: CharSequence
    ) {
        if (s.isNotEmpty()) {
            searchKeywordBehaviorSubject.onNext(s.toString())
        }
    }

    fun showBottomSheet() {
        _showBottomSheetDialog.event = true
    }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

//    fun setSelectedCategory(position: Int) {
//
//    }

    val customCategory: (Int) -> Unit = {
        _selectedCategory.value = _categoryList.value?.get(it)
    }
}