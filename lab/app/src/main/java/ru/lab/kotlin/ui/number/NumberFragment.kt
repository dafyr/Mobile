package ru.lab.kotlin.ui.number

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import ru.lab.lab5.R
import ru.lab.kotlin.LabApplication
import ru.lab.kotlin.database.Result
import ru.lab.kotlin.viewmodels.NumberViewModel

class NumberFragment : Fragment() {
    private lateinit var editTextX: EditText
    private lateinit var editTextY: EditText
    private lateinit var buttonDiv: Button
    private lateinit var buttonMod: Button
    private lateinit var textView: TextView
    private var x = 0.0
    private var y = 0.0
    private var buttonDivCounter = 0
    private var buttonModCounter = 0

    private val numberViewModel by viewModels<NumberViewModel> {
        NumberViewModel.Factory(
            (requireActivity().application as LabApplication).repository
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
        setUpObservers()
    }

    private fun setUpObservers() {
        numberViewModel.result.observe(viewLifecycleOwner) {
            numberViewModel.saveResult(Result(0, it))
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            textView.text = it.toString()
        }
    }

    private fun initViews() {
        editTextX = requireView().findViewById(R.id.x_edit)
        editTextY = requireView().findViewById(R.id.y_edit)
        buttonDiv = requireView().findViewById(R.id.btn_hello)
        buttonMod = requireView().findViewById(R.id.btn_truncate)
        textView = requireView().findViewById(R.id.textView)
        buttonDiv.isEnabled = false
        buttonMod.isEnabled = false
    }

    private fun initListeners() {
        editTextX.addTextChangedListener { text ->
            x = if (!text.isNullOrEmpty()) text.toString().toDouble() else x
            enableButtons(!text.isNullOrEmpty() && !editTextY.text.isNullOrEmpty())
        }

        editTextY.addTextChangedListener { text ->
            y = if (!text.isNullOrEmpty()) text.toString().toDouble() else y
            enableButtons(!text.isNullOrEmpty() && !editTextX.text.isNullOrEmpty())
        }

        buttonDiv.setOnClickListener {
            buttonModCounter = 0
            buttonMod.isEnabled = true
            buttonDivCounter++
            if (buttonDivCounter >= 3) {
                buttonDiv.isEnabled = false
            }
            numberViewModel.calculateResultDiv(x, y)
        }

        buttonMod.setOnClickListener {
            buttonDivCounter = 0
            buttonDiv.isEnabled = true
            buttonModCounter++
            if (buttonModCounter >= 3) {
                buttonMod.isEnabled = false
            }
            numberViewModel.calculateResultMod(x, y)
        }
    }

    private fun enableButtons(bool: Boolean) {
        buttonDiv.isEnabled = bool
        buttonMod.isEnabled = bool
    }


    companion object {
        fun newInstance() = NumberFragment()
    }
}