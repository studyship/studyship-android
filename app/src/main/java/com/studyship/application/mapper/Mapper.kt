package com.studyship.application.mapper

interface Mapper<E, T> {
    fun toMap(item: E): T

    fun fromMap(item: T): E
}