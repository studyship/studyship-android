package com.studyship.application.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.studyship.application.R

class UserInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        //todo
        //get arguments from MyProfileFragment
        Log.d("UserName", intent.getStringExtra("userID") ?: "N/A")
    }
}