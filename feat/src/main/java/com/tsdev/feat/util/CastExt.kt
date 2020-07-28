@file:Suppress("UNCHECKED_CAST")

package com.tsdev.feat.util

fun <T> Any.cast(): T {
    return this as T
}