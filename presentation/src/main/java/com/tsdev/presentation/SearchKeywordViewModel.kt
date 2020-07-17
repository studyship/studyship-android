package com.tsdev.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.constant.DEBOUNCE_INTERVAL_TIME
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleMutableEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import tsthec.tsstudy.domain.model.DomainCategory
import tsthec.tsstudy.domain.model.DomainLocationResource
import tsthec.tsstudy.domain.model.DomainSuggestResponse
import tsthec.tsstudy.domain.usecase.base.CompletableUseCase
import java.util.concurrent.TimeUnit

class SearchKeywordViewModel(private val searchUseCase: CompletableUseCase<String>) :
    BaseViewModel() {

    private val searchKeywordBehaviorSubject = PublishSubject.create<String>()

    private val _suggestList = MutableLiveData<List<DomainSuggestResponse>>()

    val suggestList: LiveData<List<DomainSuggestResponse>>
        get() = _suggestList

    private val _savingSearchKeywordList = MutableLiveData<List<String>>()
    val savingSearchKeywordList: LiveData<List<String>>
        get() = _savingSearchKeywordList

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

    private val _listCategory = MutableLiveData<List<DomainLocationResource>>()

    val listCategory: LiveData<List<DomainLocationResource>>
        get() = _listCategory

    private val _initializedLiveData = MutableLiveData(false)
    val initializedData: LiveData<Boolean>
        get() = _initializedLiveData

    init {
        _suggestList.value = listOf(
            DomainSuggestResponse("프로토타입"),
            DomainSuggestResponse("디자인"),
            DomainSuggestResponse("스위프트"),
            DomainSuggestResponse("프로토타입"),
            DomainSuggestResponse("프론트앤드")
        )

        disposable.add(
            searchKeywordBehaviorSubject
                .debounce(DEBOUNCE_INTERVAL_TIME, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter { it.isNotEmpty() }
                .onErrorReturn {
                    "ERROR!"
                }
                .subscribe {
                    Log.e("SEARCH", it)
                    _searchKeyword.value = it
                    saveUserSearchHistory(it)
                }
        )

        _categoryList.value = listOf("카테고리", "지역", "검색필터")

        _listCategory.value = listOf(
            DomainLocationResource(
                location = "서울",
                detailCategoryList = listOf(
                    DomainCategory("전체"),
                    DomainCategory("강남"),
                    DomainCategory("강서"),
                    DomainCategory("강북"),
                    DomainCategory("서초"),
                    DomainCategory("교대"),
                    DomainCategory("해운대구"),
                    DomainCategory("보라매"),
                    DomainCategory("강서"),
                    DomainCategory("가나다아아라난"),
                    DomainCategory("강서")
                )
            ), DomainLocationResource(
                location = "부산",
                detailCategoryList = listOf(
                    DomainCategory("강서구"),
                    DomainCategory("해운대"),
                    DomainCategory("경대"),
                    DomainCategory("동명대"),
                    DomainCategory("진구"),
                    DomainCategory("해운대구"),
                    DomainCategory("남구")
                )
            ), DomainLocationResource(
                location = "울산",
                detailCategoryList = listOf(
                    DomainCategory("울주군"),
                    DomainCategory("동구"),
                    DomainCategory("북구"),
                    DomainCategory("남구")
                )
            )
        )

    }
    //databinding 때문에 지울수가 없음
    fun onTextChanged(s: CharSequence) {
        _searchKeyword.value = ""
        if (s.isNotEmpty()) {
            Log.e("KEYWORD", s.toString())
            searchKeywordBehaviorSubject.onNext(s.toString())
            _initializedLiveData.value = true
        }
//        if (s.isEmpty() && _initializedLiveData.value == false) {
//            disposable.add(
//                searchUseCase.loadUserSearchHistory()
//                    .subscribeOn(Schedulers.computation())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .onErrorReturn {
//                        emptyList()
//                    }
//                    .subscribe {
//                        Log.e("SEARCH_LIST", it.toString())
//                        _savingSearchKeywordList.value = it
//                    }
//            )
//        }
    }

    fun showBottomSheet() {
        _showBottomSheetDialog.event = true
    }

    val customCategory: (Int) -> Unit = {
        _selectedCategory.value = _categoryList.value?.get(it)
    }

    private fun saveUserSearchHistory(keywords: String) {
        disposable.add(
            searchUseCase(keywords)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
        )
    }

    override fun onCleared() {
        disposable.clear()
        _initializedLiveData.value = false
        super.onCleared()
    }
}