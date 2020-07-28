package com.tsdev.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.tsdev.presentation.base.BaseViewModel
import com.tsdev.presentation.ext.Event
import com.tsdev.presentation.ext.SingleEvent
import com.tsdev.presentation.ext.SingleMutableEvent
import com.tsdev.presentation.ext.setObservable

class MakeStudyViewModel : BaseViewModel() {
    private val _userMustWriteLiveData = MediatorLiveData<Boolean>()

    val userMustWriteLiveData: LiveData<Boolean>
        get() = _userMustWriteLiveData

    private val _studyNameLiveData = MutableLiveData<String>()

    val studyNameLiveData: LiveData<String>
        get() = _studyNameLiveData

    private val _userCategorySelectedList = MutableLiveData<List<String>>()

    val userCategorySelectedList: LiveData<List<String>>
        get() = _userCategorySelectedList

    private val _userPreferStudyPlaceListLiveData = MutableLiveData<List<String>>()

    val userPreferStudyPlaceListLiveData: LiveData<List<String>>
        get() = _userPreferStudyPlaceListLiveData

    private val _moveActivityLiveData = SingleMutableEvent<String>()

    val moveActivityLiveData: SingleEvent<String>
        get() = _moveActivityLiveData

    private val _moveNextStepActivity = SingleMutableEvent<Boolean>()

    val moveNextStepActivity: SingleEvent<Boolean>
        get() = _moveNextStepActivity


    init {
        _userMustWriteLiveData.setObservable(_studyNameLiveData, _userCategorySelectedList) {
            isAllWriteUserRequireList()
        }
    }

    private fun isAllWriteUserRequireList(): Boolean =
        studyNameLiveData.value?.isNotEmpty() == true && userCategorySelectedList.value?.isNotEmpty() == true

    fun moveActivity(activityName: String) {
        _moveActivityLiveData.value?.getContentValue().takeIf {
            it?.isEmpty() == true
        }?.run {
            _moveActivityLiveData.event = ""
            _moveActivityLiveData.event = activityName
        } ?: run { _moveActivityLiveData.event = activityName }
    }

    fun moveNextStep() {
        _moveNextStepActivity.value = Event(true)
    }
}