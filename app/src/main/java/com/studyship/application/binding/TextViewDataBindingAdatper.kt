package com.studyship.application.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.studyship.application.R
import tsthec.tsstudy.domain.model.DomainMakeStudyResponse

@BindingAdapter("temporaryStudyText")
fun TextView.setBindingTemporary(item: Int?) {
    text = if(item == 0) {
        context.getString(R.string.temporary_storage_my_study_empty)
    } else {
        context.getString(R.string.temporary_storage_my_study, item)
    }
//    item?.temporarySize.takeIf {
//    }?.run {
//
//    } ?: run { text =  }
}