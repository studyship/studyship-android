package com.studyship.application.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.studyship.application.R
import kotlinx.android.synthetic.main.activity_create_study.*

class CreateStudyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_study)

        gather_date_layout.setLayoutData(listOf("일", "월", "화", "수", "목", "금", "토"))
    }
}
