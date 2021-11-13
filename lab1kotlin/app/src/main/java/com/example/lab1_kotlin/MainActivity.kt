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
import androidx.fragment.app.Fragment
import com.example.lab1_kotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonChangeFragment?.setOnClickListener {

            replaceFragment(StringFragment())

        }

        binding.buttonChangeFragment2?.setOnClickListener {

            replaceFragment(NumberFragment())

        }
    }

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit()

    }
}


