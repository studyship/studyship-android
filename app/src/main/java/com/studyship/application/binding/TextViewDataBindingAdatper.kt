package com.studyship.application.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.studyship.application.R
import tsthec.tsstudy.domain.model.DomainMakeStudyResponse

@BindingAdapter("temporaryStudyText")
fun TextView.setBindingTemporary(item: DomainMakeStudyResponse?) {
    item?.temporarySize?.takeIf {
        it == 0
    }?.run {
        text = context.getString(R.string.temporary_storage_my_study_empty)
    } ?: run { text = context.getString(R.string.temporary_storage_my_study)}
}
