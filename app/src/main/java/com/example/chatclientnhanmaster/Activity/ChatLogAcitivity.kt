package com.example.chatclientnhanmaster.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatclientnhanmaster.NonActivity.*
import com.example.chatclientnhanmaster.R
import kotlinx.android.synthetic.main.activity_chat.*

class ChatLogAcitivity : AppCompatActivity(), ChatHistoryObserver {
    private lateinit var chatRecyclerViewAdapter: ChatRecyclerViewAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        ChatServer.registerObserver(this)
        ClientData.isConnected = true

        //create recycler view for update chat message
        messageRecycler.layoutManager = LinearLayoutManager(this)
        chatRecyclerViewAdapter = ChatRecyclerViewAdapter(this)
        messageRecycler.adapter = chatRecyclerViewAdapter

        sendButton.setOnClickListener {
            val chatMessage =
                ChatMessage(
                    ClientData.username,
                    ControllerCommand.Chat,
                    messageInput.text.toString()
                )
            Thread(SendMessageToServer(chatMessage)).start()
            messageInput.setText("")
        }

    }

    override fun newMessage(chatMessage: ChatMessage) {
        runOnUiThread {
            chatRecyclerViewAdapter.notifyDataSetChanged()
            messageRecycler.scrollToPosition(chatRecyclerViewAdapter.itemCount - 1)
        }
    }

    override fun onStop() {
        super.onStop()
        ClientData.isConnected = false
    }

    override fun onDestroy() {
        super.onDestroy()
        ChatServer.quit()
    }
    //set up actionbar menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dropdown_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }
    // clicker on selected item from actionbar menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.history -> run {
                val intent = Intent(this, ChatHistoryActivity::class.java).apply {}
                startActivity(intent)
                true
            }
            R.id.top->run {
                val intent = Intent(this, TopChatterActivity::class.java).apply {}
                startActivity(intent)
                true
            }
            R.id.userList-> run{
                val intent = Intent(this, UserListActivity::class.java).apply {}
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
