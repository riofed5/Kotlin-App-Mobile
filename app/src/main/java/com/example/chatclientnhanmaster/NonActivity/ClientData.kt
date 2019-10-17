package com.example.chatclientnhanmaster.NonActivity

import android.util.Log

object ClientData{
    var username = ""
    val messageList: MutableList<ChatMessage> = mutableListOf()
    var isConnected = false
    var newSet= mutableSetOf<String>()

    //set a list handle all user has been join
    fun getUserList(): MutableList<String> {
        for (message in messageList) {
            newSet.add("${message.username}")
        }
        return newSet.toMutableList()
    }
}