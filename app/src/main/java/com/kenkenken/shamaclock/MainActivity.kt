package com.kenkenken.shamaclock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.util.Linkify
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTwitter: TextView = findViewById(R.id.tv_twitter);
        Linkify.addLinks(tvTwitter, Linkify.ALL);
    }
}