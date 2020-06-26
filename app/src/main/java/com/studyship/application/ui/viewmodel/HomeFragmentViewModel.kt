package com.studyship.application.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.studyship.application.data.CategoryResponse
import com.studyship.application.util.Event
import com.studyship.application.util.MutableSingleEvent
import com.studyship.application.util.SingleEvent

class HomeFragmentViewModel : ViewModel() {

    private val _categoryList = MutableLiveData<List<CategoryResponse>>()
    val categoryList: LiveData<List<CategoryResponse>>
        get() = _categoryList

    private val _categoryName = MutableLiveData<Event<String>>()
    val categoryName: LiveData<Event<String>>
        get() = _categoryName

    private val _moveSignInActivity = MutableSingleEvent(Event(false))
    val moveSignInActivity: SingleEvent<Boolean>
        get() = _moveSignInActivity

    private val _userName = MutableLiveData<String>()

    val userName: LiveData<String>
        get() = _userName


    init {
        _categoryList.value = listOf(
            CategoryResponse("개발") {
                _categoryName.value = Event("개발")
            },
            CategoryResponse("디자인") {
                _categoryName.value = Event("디자인")
            },
            CategoryResponse("영어") {
                _categoryName.value = Event("영어")
            },
            CategoryResponse("테스트") {
                _categoryName.value = Event("테스트")
            },
            CategoryResponse("테스트") {
                _categoryName.value = Event("테스트")
            }, CategoryResponse("테스트") {
                _categoryName.value = Event("테스트")
            }
        )
        _userName.value = "홍길동"
    }

    fun moveSignInActivity() {
        _moveSignInActivity.value = Event(true)
    }
}