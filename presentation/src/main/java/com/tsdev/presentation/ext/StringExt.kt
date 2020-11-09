package com.tsdev.presentation.ext

fun String.isHadBlack(predict: (Char) -> Boolean): Boolean {
    var char: Char
    var isPass = true
    this.forEach {
        char = it
        if (!predict(char)) {
            isPass = false
            return@forEach
        }
    }
    return isPass
}