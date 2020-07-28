@file:Suppress("UNCHECKED_CAST")

package com.studyship.application.util

fun <T> Any?.cast(): T{
    return this as T
}