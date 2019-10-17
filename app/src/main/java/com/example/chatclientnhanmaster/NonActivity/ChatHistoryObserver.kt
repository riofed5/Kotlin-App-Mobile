package com.example.chatclientnhanmaster.NonActivity

interface ChatHistoryObserver {
    fun newMessage(chatMessage: ChatMessage)
}