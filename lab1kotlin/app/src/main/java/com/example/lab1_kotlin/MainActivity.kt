package com.example.lab1_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged


class MainActivity : AppCompatActivity() {

    private var buttonApply : Button? = null
    private var enterName : TextView? = null
    private var enterSurname : TextView? = null
    private var result_text : TextView? = null
    private var stringHello : String = ""
    private var stringNameError : String = ""
    private var stringSurnameError : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonApply = findViewById(R.id.buttonApply)
        enterName = findViewById(R.id.enterName)
        enterSurname = findViewById(R.id.enterSurname)
        result_text = findViewById(R.id.result_text)
        stringHello = getString(R.string.stringHello)
        stringNameError = getString(R.string.stringNameError)
        stringSurnameError = getString(R.string.stringSurnameError)

        buttonApply?.isEnabled = false;


        enterName?.doOnTextChanged { text, _, _, _ ->
            buttonApply?.isEnabled = text.toString().trim().isNotEmpty()
        }

        enterSurname?.doOnTextChanged { text, _, _, _ ->
           buttonApply?.isEnabled = text.toString().trim().isNotEmpty()
        }

        buttonApply?.setOnClickListener {
            when {
                enterName?.text?.toString()?.trim()?.equals("")!! -> Toast.makeText(
                    this,
                    stringNameError,
                    Toast.LENGTH_LONG
                ).show()
                enterSurname?.text?.toString()?.trim()?.equals("")!! -> Toast.makeText(
                    this,
                    stringSurnameError,
                    Toast.LENGTH_LONG
                ).show()
                else -> {
                    val name = enterName?.text.toString()
                    val surname = enterSurname?.text.toString()
                    result_text?.text = "$stringHello $name $surname"

                }
            }

        }

    }
}


