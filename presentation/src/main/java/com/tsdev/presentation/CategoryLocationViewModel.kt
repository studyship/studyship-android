package com.tsdev.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import tsthec.tsstudy.domain.model.DomainDetailLocation

class CategoryLocationViewModel : BaseViewModel() {
    private val _categoryLocationList = MutableLiveData<List<DomainDetailLocation>>()

    val categoryLocationList: LiveData<List<DomainDetailLocation>>
        get() = _categoryLocationList


    init {
        _categoryLocationList.value = listOf(
            DomainDetailLocation("서울"),
            DomainDetailLocation("경기"),
            DomainDetailLocation("인천"),
            DomainDetailLocation("부산"),
            DomainDetailLocation("대전")
        )
    }
}