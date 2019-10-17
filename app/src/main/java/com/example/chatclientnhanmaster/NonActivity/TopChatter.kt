package com.example.chatclientnhanmaster.NonActivity

object TopChatter : ChatHistoryObserver, Runnable {
    private var usersMap: MutableMap<String, Int> = mutableMapOf()
    var topChatterName: String? = null
    var topChatterCount: Int = 0
    override fun newMessage(chatMessage: ChatMessage) {
        if (usersMap.containsKey(chatMessage.username)) {
            usersMap[chatMessage.username] = usersMap[chatMessage.username]!!.plus(1)
        } else {
            usersMap[chatMessage.username] = 1
        }
        usersMap = usersMap.toList().sortedByDescending { (_, value) -> value }.toMap().toMutableMap()
        val firstInMap = usersMap.keys.first()
        if (topChatterName != firstInMap) {
            topChatterName = firstInMap
        }
    }

    override fun run() {
        ChatServer.registerObserver(this)
    }
}