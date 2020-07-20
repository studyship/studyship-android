package com.tsdev.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.ext.Event
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleMutableEvent
import tsthec.tsstudy.domain.model.DomainMakeStudyResponse

class MainActivityViewModel : BaseViewModel() {
    private val _makeStudyList = MutableLiveData<List<DomainMakeStudyResponse>>()

    val makeStudyList: LiveData<List<DomainMakeStudyResponse>>
        get() = _makeStudyList

    private val _showBottomSheetLiveData = SingleMutableEvent<Boolean>()

    val showBottomSheetLiveData: SingleEvent<Boolean>
        get() = _showBottomSheetLiveData

    init {
        _makeStudyList.value =
            listOf(DomainMakeStudyResponse("새로운 스터디"), DomainMakeStudyResponse("임시 저장", 4))
    }

    fun showBottomSheet() {
        _showBottomSheetLiveData.value = Event(true)
    }
}