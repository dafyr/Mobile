package ru.lab.kotlin.view.string

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
import ru.lab.kotlin.viewmodels.StringViewModel

class StringFragment : Fragment() {

    private lateinit var editTextString: EditText
    private lateinit var buttonHello: Button
    private lateinit var textView: TextView
    private var text = ""

    private val stringViewModel by viewModels<StringViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_string, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
        setUpObservers()
    }

    private fun setUpObservers() {
        stringViewModel.result.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            textView.text = it
        }
    }

    private fun initViews() {
        editTextString = requireView().findViewById(R.id.string_edit)
        buttonHello = requireView().findViewById(R.id.btn_hello)
        textView = requireView().findViewById(R.id.textView)
        buttonHello.isEnabled = false
    }

    private fun initListeners() {
        editTextString.addTextChangedListener { text ->
            this.text = if (!text.isNullOrEmpty()) text.toString() else this.text
            enableButtons(!text.isNullOrEmpty())
        }

        buttonHello.setOnClickListener {
            stringViewModel.doHello(resources, text)
        }

    }

    private fun enableButtons(bool: Boolean) {
        buttonHello.isEnabled = bool
    }

    companion object {
        fun newInstance() = StringFragment()
    }

}