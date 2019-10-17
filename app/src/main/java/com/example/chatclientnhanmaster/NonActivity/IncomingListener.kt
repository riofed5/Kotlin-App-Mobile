package com.example.chatclientnhanmaster.NonActivity

import kotlinx.serialization.json.Json
import java.util.*

class IncomingListener(private val scanner: Scanner) : Runnable {
    override fun run() {
        while (true) {
            val newMessage = scanner.nextLine()
            val chatMessage = Json.parse(ChatMessage.serializer(), newMessage)
            ChatServer.insert(chatMessage)
        }
    }
}