package com.dimon.data.persistence.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dimon.data.persistence.models.UserModel.Companion.TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_NAME)
data class UserModel(
        @PrimaryKey @SerializedName("databaseId", alternate = ["id"]) val id: Long,
        @SerializedName("login") val login: String? = null,
        @SerializedName(value = "avatar_url", alternate = ["avatarUrl"]) val avatarUrl: String? = null,
        @SerializedName("url") val url: String? = null,
        @SerializedName("name") val name: String? = null
) {
    companion object {
        const val TABLE_NAME = "user_table"
    }
}