package com.studyship.application.ui.activity

import android.graphics.Typeface.BOLD
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import com.skydoves.transformationlayout.TransformationAppCompatActivity
import com.skydoves.transformationlayout.onTransformationStartContainer
import com.studyship.application.R
import kotlinx.android.synthetic.main.activity_study_apply_body_layout.*
import kotlinx.android.synthetic.main.apply_study_header_bar.*

class StudyApplyActivity : TransformationAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_apply)

//        reply_response_percent_tv.text  =  getString(R.string.reply_response_percent, 5)

        back_img.setOnClickListener { finish() }

//        val spannable = SpannableStringBuilder(apply_study_captain_name.text)
//        spannable.setSpan(
//            StyleSpan(BOLD),
//            3, // start
//            6, // end
//            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
//        )

//        apply_study_captain_name.text = spannable
    }
}
