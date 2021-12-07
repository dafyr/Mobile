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
    private lateinit var buttonMultiply: Button
    private lateinit var buttonDivide: Button
    private lateinit var textView: TextView
    private var x = 0.0
    private var y = 0.0

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
        buttonMultiply = requireView().findViewById(R.id.btn_hello)
        buttonDivide = requireView().findViewById(R.id.btn_truncate)
        textView = requireView().findViewById(R.id.textView)
        buttonMultiply.isEnabled = false
        buttonDivide.isEnabled = false
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

        buttonMultiply.setOnClickListener {
            numberViewModel.calculateResultMultiply(x, y)
        }

        buttonDivide.setOnClickListener {
            numberViewModel.calculateResultDivide(x, y)
        }
    }

    private fun enableButtons(bool: Boolean) {
        buttonMultiply.isEnabled = bool
        buttonDivide.isEnabled = bool
    }


    companion object {
        fun newInstance() = NumberFragment()
    }
}