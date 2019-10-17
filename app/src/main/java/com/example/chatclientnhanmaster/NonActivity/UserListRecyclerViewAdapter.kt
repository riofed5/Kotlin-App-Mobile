package com.example.chatclientnhanmaster.NonActivity

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chatclientnhanmaster.R
import kotlinx.android.synthetic.main.chat_recycler_item.view.*
import kotlinx.android.synthetic.main.userlist_item_layout.view.*

class UserListRecyclerViewAdapter(
    private val context: Context
) : RecyclerView.Adapter<UserListRecyclerViewAdapter.UserListViewHolder>() {

    override fun onCreateViewHolder(vg: ViewGroup, vt: Int): UserListViewHolder {
        val itemView =
            LayoutInflater.from(context).inflate(
                R.layout.userlist_item_layout, vg,
                false
            )
        return UserListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return ClientData.getUserList().size
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        val view = holder.itemView
        val user = ClientData.getUserList()[position]

        view.itemTextView.text= "Mr/Mrs $user"
    }

    class UserListViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
    }
}


