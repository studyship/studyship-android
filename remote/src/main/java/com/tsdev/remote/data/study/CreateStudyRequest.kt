package com.tsdev.remote.data.study

data class CreateStudyRequest(
    val categories: List<Int>,
    val days: List<Int>,
    val deadline: String,
    val description: String,
    val file: String,
    val goal: String,
    val level: Int,
    val place: String,
    val recruitment: Int,
    val tags: List<String>,
    val tendency: Tendency,
    val time: Int,
    val title: String
) {
    data class Tendency(
        val flexible: Int,
        val friendly: Int,
        val offline: Int,
        val sometime_dinner: Int
    )
}

