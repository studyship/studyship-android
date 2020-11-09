package result

sealed class Result<out T> {
    internal class Success<T>(val value: T) : Result<T>() {

    }

    internal class Error<T>(val onError: Throwable) : Result<T>() {

    }

    internal class Loading<T> : Result<T>() {

    }
}