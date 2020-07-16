package com.tsdev.feat.listener

import android.view.View

typealias ThrottleClickListener = (View) -> Unit
class ThrottleFirstClickListener(private val clickListener: ThrottleClickListener) : View.OnClickListener {
    override fun onClick(v: View?) {

        v?.run(clickListener)
    }

}