package com.example.chatclientnhanmaster.NonActivity

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatclientnhanmaster.R
import kotlinx.android.synthetic.main.chat_recycler_item.view.*
import kotlinx.android.synthetic.main.chat_recycler_item.view.messageTextView
import kotlinx.android.synthetic.main.chat_recycler_item.view.usernameTextView
import kotlinx.android.synthetic.main.chathistory_item_layout.view.*

class ChatHistoryRecyclerViewAdapter (
    private val context: Context
): RecyclerView.Adapter<ChatHistoryViewHolder>(){
    override fun onCreateViewHolder(vg: ViewGroup, viewType: Int): ChatHistoryViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(
                R.layout.chathistory_item_layout, vg,
                false
            )
        return ChatHistoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ClientData.messageList.size
    }

    override fun onBindViewHolder(holder: ChatHistoryViewHolder, position: Int) {
        val view = holder.itemView
        val chatMessage = ClientData.messageList[position]

        view.messageTextView.text = ": ${chatMessage.message}"
        view.usernameTextView.text = chatMessage.username
        view.time.text= "(${chatMessage.timestamp})"
    }


}
class ChatHistoryViewHolder(itemView: View):
    RecyclerView.ViewHolder(itemView) {
}