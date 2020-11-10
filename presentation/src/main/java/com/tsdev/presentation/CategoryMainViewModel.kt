package com.tsdev.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import tsthec.tsstudy.domain.model.DomainMainCategory

class CategoryMainViewModel : BaseViewModel() {
    private val _mainCategoryList = MutableLiveData<List<DomainMainCategory>>()

    val mainCategoryList: LiveData<List<DomainMainCategory>>
        get() = _mainCategoryList


    init {
        _mainCategoryList.value = listOf(
            DomainMainCategory("디자인"),
            DomainMainCategory("개발"),
            DomainMainCategory("취업"),
            DomainMainCategory("외국어"),
            DomainMainCategory("프로젝트")
        )
    }

}