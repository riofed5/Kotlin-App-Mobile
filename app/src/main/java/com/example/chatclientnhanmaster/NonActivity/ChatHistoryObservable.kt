package com.example.chatclientnhanmaster.NonActivity

interface ChatHistoryObservable {
    val OBSERVER_SET: MutableSet<ChatHistoryObserver>

    fun registerObserver(newObserver: ChatHistoryObserver)
    fun deregisterObserver(targetObserver: ChatHistoryObserver)

    fun notifyObservers(message: ChatMessage)

    fun insert(message: ChatMessage)
}