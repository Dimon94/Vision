package com.dimon.domain.entities

data class AccessTokenModel(
        val id: Long,
        val token: String,
        val hashedToken: String,
        val accessToken: String,
        val tokenType: String
)
