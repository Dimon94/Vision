package com.dimon.data.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.dimon.data.persistence.models.UserModel

@Dao
abstract class UserDao : BaseDao<UserModel>() {
    @Query("SELECT * FROM ${UserModel.TABLE_NAME}")
    abstract fun getUserList(): LiveData<List<UserModel>>

    @Query("SELECT * FROM ${UserModel.TABLE_NAME} WHERE `login` = :login")
    abstract fun getUser(login: String): LiveData<UserModel>

    @Query("DELETE FROM ${UserModel.TABLE_NAME}")
    abstract fun deleteAll()
}