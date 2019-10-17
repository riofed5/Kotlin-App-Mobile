package com.example.chatclientnhanmaster.NonActivity

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
class ChatMessage(
    val username: String,
    val command: ControllerCommand,
    val message: String,
    val timestamp: String = LocalDateTime.now().hour.toString()+":"+ LocalDateTime.now().minute.toString()) {

    override fun toString(): String {
        return message
    }
}