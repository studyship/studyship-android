package tsthec.tsstudy.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "userSearchLocalHistory")
data class UserSearchLocalHistory(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int = UUID.randomUUID().version(),

    @ColumnInfo(name = "keywords")
    val searchKeyword: String
)