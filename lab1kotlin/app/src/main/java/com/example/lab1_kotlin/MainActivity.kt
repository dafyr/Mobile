package com.example.lab1_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    private var buttonApply : Button? = null
    private var enterName : TextView? = null
    private var enterSurname : TextView? = null
    private var result_text : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonApply = findViewById(R.id.buttonApply)
        enterName = findViewById(R.id.enterName)
        enterSurname = findViewById(R.id.enterSurname)
        result_text = findViewById(R.id.result_text)

        buttonApply?.setOnClickListener{
            when {
                enterName?.text?.toString()?.trim()?.equals("")!! -> Toast.makeText(this, "Ошибка: поле \"Name\" не заполнено", Toast.LENGTH_LONG).show()
                enterSurname?.text?.toString()?.trim()?.equals("")!! -> Toast.makeText(this, "Ошибка: поле \"Surname\" не заполнено", Toast.LENGTH_LONG).show()
                else -> {
                    val name = enterName?.text.toString()
                    val surname = enterSurname?.text.toString()
                    result_text?.text = "Hello $name $surname"

                }
            }


        }


    }
}