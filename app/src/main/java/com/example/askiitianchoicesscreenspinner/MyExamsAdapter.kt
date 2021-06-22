package com.example.askiitianchoicesscreenspinner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.askiitianchoicesscreenspinner.databinding.DropdownTvBinding

class MyExamsAdapter(
    private val options: List<String>,
    private val listenerExam: OnExamItemClickListener
) :
    RecyclerView.Adapter<MyExamsAdapter.MyExamsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyExamsViewHolder {
        val view = DropdownTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyExamsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyExamsViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return if (options.isEmpty()) 0
        else options.size
    }

    inner class MyExamsViewHolder(private val binding: DropdownTvBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(position: Int) {
            binding.tvItem.text = options[position]
        }
        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listenerExam.onExamItemClick(adapterPosition, options)
        }
    }

    interface OnExamItemClickListener {
        fun onExamItemClick(position: Int, options: List<String>)
    }

}