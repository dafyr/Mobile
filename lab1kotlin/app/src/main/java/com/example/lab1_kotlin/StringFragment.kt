package com.example.lab1_kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.doOnTextChanged


class StringFragment : Fragment() {

    private var buttonApply : Button? = null
    private var enterName : TextView? = null
    private var enterSurname : TextView? = null
    private var resultText : TextView? = null
    private var stringHello : String = ""
    private var stringNameError : String = ""
    private var stringSurnameError : String = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_string, container, false)

        buttonApply = view.findViewById(R.id.buttonApply)
        enterName = view.findViewById(R.id.enterName)
        enterSurname = view.findViewById(R.id.enterSurname)
        resultText = view.findViewById(R.id.result_text)
        stringHello = getString(R.string.stringHello)
        stringNameError = getString(R.string.stringNameError)
        stringSurnameError = getString(R.string.stringSurnameError)

        buttonApply?.isEnabled = false;


        enterName?.doOnTextChanged { text, _, _, _ ->
            buttonApply?.isEnabled =
                enterName?.text.toString().trim().isNotEmpty() && enterSurname?.text.toString()
                    .trim().isNotEmpty()
        }

        enterSurname?.doOnTextChanged { text, _, _, _ ->
            buttonApply?.isEnabled =
                enterName?.text.toString().trim().isNotEmpty() && enterSurname?.text.toString()
                    .trim().isNotEmpty()
        }

        buttonApply?.setOnClickListener {

                    val name = enterName?.text.toString()
                    val surname = enterSurname?.text.toString()
                    resultText?.text = "$stringHello $name $surname"

                }

        return view
    }
}




