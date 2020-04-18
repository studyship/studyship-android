package com.studyship.application.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.studyship.application.R
import kotlinx.android.synthetic.main.apply_study_header_bar.*

class StudyApplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_apply)

        back_img.setOnClickListener { finish() }
    }
}
