package ru.lab.kotlin.ui.main

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import ru.lab.lab5.R

class OpenBrowserActivity : AppCompatActivity() {

    private lateinit var linkText: EditText
    private lateinit var openLinkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_browser)

        initView()
        initListeners()
    }

    private fun initListeners() {
        openLinkButton.setOnClickListener {
            openBrowser()
        }
    }

    private fun initView() {
        linkText = findViewById(R.id.et_link_text)
        openLinkButton = findViewById(R.id.btn_open_link)
    }

    private fun openBrowser() {
        val intent = Intent().apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(linkText.text.toString())
        }

        startActivity(intent)
    }
}