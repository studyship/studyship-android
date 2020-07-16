package com.tsdev.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsdev.domain.repository.model.DomainCategoryResponse
import com.tsdev.presentation.ext.Event
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleMutableEvent

class HomeFragmentViewModel : ViewModel() {

    private val _categoryList = MutableLiveData<List<DomainCategoryResponse>>()
    val categoryList: LiveData<List<DomainCategoryResponse>>
        get() = _categoryList

    private val _categoryName = MutableLiveData<Event<String>>()
    val categoryName: LiveData<Event<String>>
        get() = _categoryName

    private val _moveSignInActivity = SingleMutableEvent<Boolean>()
    val moveSignInActivity: SingleEvent<Boolean>
        get() = _moveSignInActivity


    private val _moveSearchActivity = SingleMutableEvent<Boolean>()

    val moveSearchActivity: SingleEvent<Boolean>
        get() = _moveSearchActivity

    private val _userName = MutableLiveData<String>()

    val userName: LiveData<String>
        get() = _userName


    init {
        _categoryList.value = listOf(
            DomainCategoryResponse("개발") {
                _categoryName.value = Event("개발")
            },
            DomainCategoryResponse("디자인") {
                _categoryName.value = Event("디자인")
            },
            DomainCategoryResponse("영어") {
                _categoryName.value = Event("영어")
            },
            DomainCategoryResponse("테스트") {
                _categoryName.value = Event("테스트")
            },
            DomainCategoryResponse("테스트") {
                _categoryName.value = Event("테스트")
            },
            DomainCategoryResponse("테스트") {
                _categoryName.value = Event("테스트")
            }
        )
        _userName.value = "홍길동"
    }

    fun moveSignInActivity() {
        _moveSignInActivity.value = Event(true)
    }

    fun moveSearchActivity() {
        _moveSearchActivity.value = Event(true)
    }
}