package ru.lab.kotlin.adapters

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.lab.lab5.R
import ru.lab.kotlin.database.Result

class ResultAdapter(private val results: List<Result>, private val clickListener: (Int) -> Unit) : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.result_item, parent, false)
        return ResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        holder.resultTextView?.text = results[position].calculationResult.toString()
        holder.itemView.setOnClickListener {
            clickListener(position)
            holder.resultTextView?.typeface = Typeface.DEFAULT
        }
    }

    override fun getItemCount() = results.size

    class ResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var resultTextView: TextView? = null

        init {
            resultTextView = view.findViewById(R.id.tv_result)
        }
    }

}

interface OnItemClickListener {
    fun onClick(position: Int)
}
