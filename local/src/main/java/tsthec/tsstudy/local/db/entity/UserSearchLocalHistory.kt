package tsthec.tsstudy.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "userSearchLocalHistory")
data class UserSearchLocalHistory(

    @ColumnInfo(name = "id")
    val id: String = UUID.randomUUID().toString(),

    @PrimaryKey
    @ColumnInfo(name = "keywords")
    val searchKeyword: String
)