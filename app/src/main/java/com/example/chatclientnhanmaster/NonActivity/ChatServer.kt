package com.example.chatclientnhanmaster.NonActivity

import kotlinx.android.synthetic.main.activity_chat.*
import java.io.PrintStream
import java.net.Socket
import java.util.*

object ChatServer : ChatHistoryObservable, Runnable {
    override val OBSERVER_SET: MutableSet<ChatHistoryObserver> = mutableSetOf()

    lateinit var socket: Socket

    lateinit var scanner: Scanner
    lateinit var printStream: PrintStream

    override fun registerObserver(newObserver: ChatHistoryObserver) {
        OBSERVER_SET.add(newObserver)
    }

    override fun deregisterObserver(targetObserver: ChatHistoryObserver) {
        OBSERVER_SET.remove(targetObserver)
    }

    override fun notifyObservers(message: ChatMessage) {
        OBSERVER_SET.forEach {
            it.newMessage(message)
        }
    }

    override fun insert(message: ChatMessage) {
        if (message.command == ControllerCommand.Chat && ClientData.isConnected) {
            ClientData.messageList.add(message)
        }
        notifyObservers(message)
    }

    override fun run() {
        socket = Socket("192.168.1.174", 7000)

        scanner = Scanner(socket.getInputStream())
        Thread(IncomingListener(scanner)).start()

        printStream = PrintStream(socket.getOutputStream(), true)

        //Thread(TopChatter).start()
    }

    fun quit() {
        socket.close()
    }


}