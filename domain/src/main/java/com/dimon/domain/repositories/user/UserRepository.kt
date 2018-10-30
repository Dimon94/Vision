package com.dimon.domain.repositories.user

interface UserRepository {

    suspend fun getUser(userId: String)
}