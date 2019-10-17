package com.example.chatclientnhanmaster.NonActivity

import kotlinx.serialization.json.Json

class SendMessageToServer(private val chatMessage: ChatMessage) : Runnable {
    override fun run() {
        val newMessage = Json.stringify(ChatMessage.serializer(), chatMessage)
        ChatServer.printStream.println(newMessage)
    }
}