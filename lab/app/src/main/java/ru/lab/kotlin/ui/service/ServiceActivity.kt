package ru.lab.kotlin.ui.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ru.lab.lab5.R
import ru.lab.kotlin.service.PlayService

class ServiceActivity : AppCompatActivity() {

    private lateinit var startServiceButton: Button
    private lateinit var stopServiceButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        initView()
        initListeners()
    }

    private fun initListeners() {
        startServiceButton.setOnClickListener {
            startService(Intent(this, PlayService::class.java))
        }

        stopServiceButton.setOnClickListener {
            stopService(Intent(this, PlayService::class.java))
        }
    }

    private fun initView() {
        startServiceButton = findViewById(R.id.btn_start_service)
        stopServiceButton = findViewById(R.id.btn_stop_service)
    }
}