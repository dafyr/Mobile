package ru.lab.kotlin.ui.result

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.lab.lab5.R
import ru.lab.kotlin.adapters.ResultAdapter
import ru.lab.kotlin.LabApplication
import ru.lab.kotlin.viewmodels.ResultViewModel

class ResultActivity: AppCompatActivity() {

    private val resultViewModel by viewModels<ResultViewModel> {
        ResultViewModel.Factory(
            (this.application as LabApplication).repository
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initAdapter()
    }

    private fun initAdapter() {
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(this)

        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        resultViewModel.results.observe(this) {
            recyclerView.adapter = ResultAdapter(it) {}
        }
    }
}