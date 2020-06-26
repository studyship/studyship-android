package com.studyship.application.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tsdev.data.source.SuggestResponse

class SearchActivityViewModel : ViewModel() {

    private val _suggestList = MutableLiveData<List<SuggestResponse>>()

    val suggestList: LiveData<List<SuggestResponse>>
        get() = _suggestList

    init {
        _suggestList.value = listOf(
            SuggestResponse("프로토타입"),
            SuggestResponse("디자인"),
            SuggestResponse("스위프트"),
            SuggestResponse("프로토타입"),
            SuggestResponse("프론트앤드")
        )
    }
}