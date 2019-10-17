package com.example.chatclientnhanmaster.NonActivity

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatclientnhanmaster.R
import kotlinx.android.synthetic.main.chat_recycler_item.view.*

class ChatRecyclerViewAdapter(
    private val context: Context
) : RecyclerView.Adapter<ChatRecyclerViewAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, vt: Int): ChatViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(
                R.layout.chat_recycler_item, vg,
                false
            )
        return ChatViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ClientData.messageList.size
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val view = holder.itemView
        val chatMessage = ClientData.messageList[position]

        view.messageTextView.text = chatMessage.message
        view.usernameTextView.text = chatMessage.username
        view.usernameTextView.setTextColor(Color.parseColor("#c74600"))
        view.timestampTextView.text = chatMessage.timestamp
    }
    class ChatViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
    }
}

