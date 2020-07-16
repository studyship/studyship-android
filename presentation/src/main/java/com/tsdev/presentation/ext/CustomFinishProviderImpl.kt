package com.tsdev.presentation.ext

import android.view.View

class CustomFinishProviderImpl(private val finish: () -> Unit) : View.OnClickListener {
    override fun onClick(p0: View?) {
        finish()
    }
}