package tsthec.tsstudy.local.mapper

import com.tsdev.data.source.UserSearchHistory
import tsthec.tsstudy.local.db.entity.UserSearchLocalHistory

internal object UserSearchLocalMapper : Mapper<UserSearchHistory, UserSearchLocalHistory> {
    override fun mapToLocal(data: UserSearchLocalHistory): UserSearchHistory {
        return UserSearchHistory(data.searchKeyword)
    }

    override fun mapToEntity(data: UserSearchHistory): UserSearchLocalHistory {
        return UserSearchLocalHistory(searchKeyword = data.keywords)
    }
}