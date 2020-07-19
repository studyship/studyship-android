package tsthec.tsstudy.local.db.convert

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import tsthec.tsstudy.local.db.entity.UserSearchLocalHistory

class DomainSearchUserConverter {
    @TypeConverter
    fun fromString(value: String): List<UserSearchLocalHistory>? {
        val listType = object : TypeToken<List<UserSearchLocalHistory>>() {}.type
        return Gson().fromJson<List<UserSearchLocalHistory>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: UserSearchLocalHistory): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}