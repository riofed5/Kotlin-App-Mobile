package com.example.chatclientnhanmaster.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chatclientnhanmaster.NonActivity.TopChatter
import com.example.chatclientnhanmaster.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread(TopChatter).start()
        setContentView(R.layout.activity_main)
        val intent = Intent(this, LoginActivity::class.java).apply {}
        startActivity(intent)
    }
}
