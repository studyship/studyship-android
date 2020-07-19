package com.tsdev.data.mapper

import com.tsdev.data.source.UserSearchHistory
import tsthec.tsstudy.domain.model.DomainSearchUserHistory

internal object DomainMapper : Mapper<UserSearchHistory, DomainSearchUserHistory> {
    override fun mapperToDomain(data: UserSearchHistory): DomainSearchUserHistory {
        return DomainSearchUserHistory(data.keywords)
    }

    override fun mapperToData(data: DomainSearchUserHistory): UserSearchHistory {
        return UserSearchHistory(data.userKeywords)
    }
}