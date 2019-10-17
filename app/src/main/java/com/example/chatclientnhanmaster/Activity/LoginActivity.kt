package com.example.chatclientnhanmaster.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatclientnhanmaster.NonActivity.*
import com.example.chatclientnhanmaster.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), ChatHistoryObserver {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ChatServer.registerObserver(this)

        Thread(ChatServer).start()

        loginButton.setOnClickListener {
            ClientData.username = usernameText.text.toString()
            val loginMessage =
                ChatMessage(usernameText.text.toString(), ControllerCommand.Login, "")
            Thread(SendMessageToServer(loginMessage)).start()
        }
    }

    override fun newMessage(chatMessage: ChatMessage) {
        if (chatMessage.command == ControllerCommand.Login) {
            runOnUiThread {
                usernameText.setText("")
                statusTextView.text = chatMessage.message
            }
        } else if (chatMessage.command == ControllerCommand.Chat) {
            if (chatMessage.username != ClientData.username) return
            ClientData.newSet.add(ClientData.username)

            val intent = Intent(this, ChatLogAcitivity::class.java).apply {}
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        ChatServer.deregisterObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ChatServer.quit()
    }
}

