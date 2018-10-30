package com.dimon.data.persistence.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.util.*

private fun Any.toJson() = Gson().toJson(this)

class DateConverter {
    @TypeConverter fun toDbValue(date: Date? = null): Long? = date?.time
    @TypeConverter fun fromDbToValue(date: Long? = 0): Date? = date?.let { Date(it) }
}