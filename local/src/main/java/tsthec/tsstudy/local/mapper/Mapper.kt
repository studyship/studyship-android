package tsthec.tsstudy.local.mapper

interface Mapper<T, E> {
    fun mapToLocal(data: E): T

    fun mapToEntity(data: T): E
}