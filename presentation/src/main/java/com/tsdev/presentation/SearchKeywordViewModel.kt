package com.tsdev.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.constant.DEBOUNCE_INTERVAL_TIME
import com.tsdev.presentation.ext.Result
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleMutableEvent
import com.tsdev.presentation.ext.Status
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import tsthec.tsstudy.domain.model.DomainCategory
import tsthec.tsstudy.domain.model.DomainLocationResource
import tsthec.tsstudy.domain.model.DomainSearchUserHistory
import tsthec.tsstudy.domain.model.DomainSuggestResponse
import tsthec.tsstudy.domain.usecase.base.CompletableUseCase
import java.util.concurrent.TimeUnit

class SearchKeywordViewModel(private val searchUseCase: CompletableUseCase<DomainSearchUserHistory, DomainSearchUserHistory>) :
    BaseViewModel() {

    private val searchKeywordBehaviorSubject =
        PublishSubject.create<Result<DomainSearchUserHistory>>()

    private val _suggestList = MutableLiveData<List<DomainSuggestResponse>>()

    val suggestList: LiveData<List<DomainSuggestResponse>>
        get() = _suggestList

    private val _savingSearchKeywordList = MutableLiveData<List<DomainSearchUserHistory>>()
    val savingSearchKeywordList: LiveData<List<DomainSearchUserHistory>>
        get() = _savingSearchKeywordList

    private val _searchKeyword = MutableLiveData<DomainSearchUserHistory>()

    val searchKeyword: LiveData<DomainSearchUserHistory>
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
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn {
                    Result.Error(it.cause)
                }
                .map { Result.Success(it.data) }
                .subscribe {
                    when (it.status) {
                        Status.SUCCESS -> {
                            _searchKeyword.value = it.item
                            saveUserSearchHistory(it.item)
                        }
                        Status.ERROR -> {

                        }
                    }
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

        disposable.add(
            searchUseCase(_searchKeyword.value ?: DomainSearchUserHistory(""))
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.e("SEARCH_LIST", it.toString())
                    _savingSearchKeywordList.value = it
                }
        )
    }

    //databinding 때문에 지울수가 없음
    fun onTextChanged(s: CharSequence) {
        _searchKeyword.value = DomainSearchUserHistory("")
        if (s.isNotEmpty()) {
            Log.e("KEYWORD", s.toString())

            searchKeywordBehaviorSubject.onNext(Result.Success(DomainSearchUserHistory(s.toString())))
            _initializedLiveData.value = true
        }
        else {
            searchKeywordBehaviorSubject.onNext(Result.Error(Throwable("Empty Keywords")))
        }
    }

    fun showBottomSheet() {
        _showBottomSheetDialog.event = true
    }

    val customCategory: (Int) -> Unit = {
        _selectedCategory.value = _categoryList.value?.get(it)
    }

    private fun saveUserSearchHistory(keywords: DomainSearchUserHistory?) {
        keywords?.let {
            disposable.add(
                searchUseCase(it)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe()
            )
        }
    }

    val removeUserSearchHistory: (DomainSearchUserHistory) -> Unit = { position ->
        disposable.add(
            searchUseCase.removeUserSearchHistory(position)
                .subscribe({
                    Log.e("SUCCESS", "성공")
                }
                    , {
                        it.printStackTrace()
                    })
        )
    }

    override fun onCleared() {
        disposable.clear()
        _initializedLiveData.value = false
        super.onCleared()
    }
}