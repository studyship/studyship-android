package com.tsdev.presentation

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.domain.repository.DomainSuggestResponse
import com.tsdev.domain.repository.model.DomainCategory
import com.tsdev.domain.repository.model.DomainLocationResource
import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.constant.DEBOUNCE_INTERVAL_TIME
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleMutableEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class SearchKeywordViewModel :
    BaseViewModel() {

    lateinit var saveSearchKeyword: (String?) -> Unit

    lateinit var loadSearchKeyword: () -> List<String>

    private val disposable by lazy { CompositeDisposable() }

    private val searchKeywordBehaviorSubject = PublishSubject.create<String>()

    private val _suggestList = MutableLiveData<List<DomainSuggestResponse>>()

    val suggestList: LiveData<List<DomainSuggestResponse>>
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

    private val _listCategory = MutableLiveData<List<DomainLocationResource>>()

    val listCategory: LiveData<List<DomainLocationResource>>
        get() = _listCategory

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
                .onErrorReturn {
                    "ERROR!"
                }
                .subscribe {
                    _searchKeyword.value = it
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

    val customCategory: (Int) -> Unit = {
        _selectedCategory.value = _categoryList.value?.get(it)
    }
}