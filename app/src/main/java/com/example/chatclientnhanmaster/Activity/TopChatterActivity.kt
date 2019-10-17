package com.example.chatclientnhanmaster.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.chatclientnhanmaster.NonActivity.*
import com.example.chatclientnhanmaster.R
import kotlinx.android.synthetic.main.activity_topchatter.*

class TopChatterActivity() : AppCompatActivity() {
    //private lateinit var chatHistRecyclerViewAdapter: ChathistoryRecyclerViewAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topchatter)
        name.text= "Mr/Mrs ${TopChatter.topChatterName}"
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.back, menu)

        return super.onCreateOptionsMenu(menu)
    }
    // clicker on selected item from actionbar menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.back -> run {
                val intent = Intent(this, ChatLogAcitivity::class.java).apply {}
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
