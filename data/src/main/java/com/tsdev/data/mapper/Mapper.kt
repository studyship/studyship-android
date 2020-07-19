package com.tsdev.data.mapper

interface Mapper<T, E> {
    fun mapperToDomain(data: T): E

    fun mapperToData(data: E): T
}