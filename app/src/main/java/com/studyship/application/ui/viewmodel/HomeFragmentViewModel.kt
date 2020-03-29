package com.studyship.application.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.studyship.application.data.CategoryResponse

class HomeFragmentViewModel : ViewModel() {
    private val _categoryList = MutableLiveData<List<CategoryResponse>>()
    val categoryList: LiveData<List<CategoryResponse>>
        get() = _categoryList

    private val _categoryName = MutableLiveData<String>()
    val categoryName:

    init {
        _categoryList.value = listOf(
            CategoryResponse("개발") {
                "개발"
            },
            CategoryResponse("디자인"){

            },
            CategoryResponse("영어"){

            },
            CategoryResponse("테스트"){

            }
        )
    }

    private fun singleLiveDataEvent(): String {

    }
}