package com.dimon.data.persistence.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dimon.data.persistence.dao.UserDao
import com.dimon.data.persistence.models.UserModel

const val LOGIN_VERSION = 1
const val LOGIN_DATABASE_NAME = "Vision-Login-Room-DB";

@Database(version = LOGIN_VERSION, entities = [UserModel::class], exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao
}