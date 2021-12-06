package ru.lab.kotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.lab.lab5.R

class IntentCatcher : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_catcher)

        val textView: TextView = findViewById(R.id.tv_shared_link)
        val intent: Intent = intent
        val sharedText = intent.getStringExtra(Intent.EXTRA_TEXT)
        textView.text = sharedText
    }
}
