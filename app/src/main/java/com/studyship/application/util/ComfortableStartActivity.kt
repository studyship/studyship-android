package com.studyship.application.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf

fun <T> createIntent(
    context: Context,
    clazz: Class<out T>,
    params: Array<out Pair<String, Any?>>
) = Intent(context, clazz).apply { putExtras(bundleOf(*params)) }


inline fun <reified T : Activity> Context.comfortableStartActivity(
    vararg params: Pair<String, Any?>,
    intentAction: Intent.() -> Unit = {}
) {
    val intent = createIntent(this, T::class.java, params).apply(intentAction)
    startActivity(intent)
}