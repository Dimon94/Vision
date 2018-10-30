package com.dimon.domain.entities

import com.google.gson.annotations.SerializedName

data class AuthModel(
        val clientId: String,
        val clientSecret: String,
        val redirectUri: String,
        val scopes: List<String>,
        val state: String,
        val note: String,
        val noteUrl: String,
        @SerializedName("X-GitHub-OTP") val otpCode: String
)