package com.example.droidchat

import androidx.compose.runtime.Immutable

@Immutable
data class Message(
    val content: String,
    val isUser: Boolean
)