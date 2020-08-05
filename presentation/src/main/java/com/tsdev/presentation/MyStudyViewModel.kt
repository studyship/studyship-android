package com.tsdev.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import tsthec.tsstudy.domain.model.DomainCategory
import tsthec.tsstudy.domain.model.mystudy.response.DomainMyStudyResponse

class MyStudyViewModel : BaseViewModel() {
    private val _joinLiveDataList = MutableLiveData<List<DomainMyStudyResponse>>()

    val joinLiveDataList: LiveData<List<DomainMyStudyResponse>>
        get() = _joinLiveDataList

    init {
        _joinLiveDataList.value = listOf(
            DomainMyStudyResponse(
                "피그마 스터디",
                "동작구",
                "토, 일",
                "10분 전",
                "윤태성",
                "피그마피그마 연습",
                "5",
                listOf(
                    DomainMyStudyResponse.DomainComment("안녕"),
                    DomainMyStudyResponse.DomainComment("하세요")
                ),
                listOf(DomainCategory("UI/UX"), DomainCategory("디자인"))
            ),
            DomainMyStudyResponse(
                "안드로이드 스터디",
                "강남",
                "토",
                "30분 전",
                "안드로이드",
                "안드로이드 연습 안드로이드 연습",
                "3",
                listOf(
                    DomainMyStudyResponse.DomainComment("Hello"),
                    DomainMyStudyResponse.DomainComment("World")
                ),
                listOf(DomainCategory("IT"), DomainCategory("개발"))
            )
        )
    }
}