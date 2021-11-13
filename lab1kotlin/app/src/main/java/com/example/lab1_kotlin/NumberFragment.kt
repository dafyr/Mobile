package com.example.lab1_kotlin

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


class NumberFragment : Fragment(R.layout.fragment_number), View.OnClickListener {
    private var resultTextLabel: TextView? = null
    private var xEdit: EditText? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_number, container, false)

        resultTextLabel = view.findViewById(R.id.result_text_label)
        xEdit = view.findViewById(R.id.x_editText)

        val plusButton = view.findViewById<Button>(R.id.add_button)
        plusButton.setOnClickListener { add() }

        val minusButton = view.findViewById<Button>(R.id.minus_button)
        minusButton.setOnClickListener (this)

        val multiplyButton = view.findViewById<Button>(R.id.multiply_button)
        multiplyButton.setOnClickListener {
            val x = xEdit?.text.toString().toInt()
            resultTextLabel?.text = (x * 2).toString()
            Toast.makeText(activity, (x * 2).toString(), Toast.LENGTH_LONG).show()
        }
        return view
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.minus_button -> {
                val x = xEdit!!.text.toString().toInt()
                resultTextLabel!!.text = (x - 2).toString()
                Snackbar.make(v, (x - 2).toString(), Snackbar.LENGTH_LONG).show()
            }
        }
    }

    private fun add() {
        val logoutDialogListener =
            DialogInterface.OnClickListener { _: DialogInterface?, which: Int ->
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    val x = xEdit!!.text.toString().toInt()
                    resultTextLabel!!.text = (x + 2).toString()
                }
            }

        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setMessage(R.string.set_the_result)
            .setPositiveButton(R.string.yes, logoutDialogListener)
            .setNegativeButton(R.string.no, logoutDialogListener).show()

    }
}