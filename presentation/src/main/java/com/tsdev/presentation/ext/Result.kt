package com.tsdev.presentation.ext

sealed class Result<T>(val status: Status, val data: T?, val errorMessage: Throwable? = null) {
    data class Success<T>(val item: T?) : Result<T>(Status.SUCCESS, item)

    data class Error<T>(val error: Throwable? = null) :
        Result<T>(Status.ERROR, data = null, errorMessage = error)
}

enum class Status {
    SUCCESS,
    ERROR
}
