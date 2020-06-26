package com.studyship.application.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.studyship.application.R
import com.studyship.application.util.customOverridePendingTransition


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
    }

    override fun finish() {
        super.finish()
        this.customOverridePendingTransition(enterAnim = R.anim.slide_in_left)
    }
}
