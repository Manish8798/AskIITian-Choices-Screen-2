package com.example.askiitianchoicesscreenspinner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.askiitianchoicesscreenspinner.databinding.DropdownTvBinding

class MyClassesAdapter(
    private val options: List<String>,
    private val listener: OnItemClickListener
) :
    RecyclerView.Adapter<MyClassesAdapter.MyClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyClassViewHolder {
        val view = DropdownTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyClassViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return if (options.isEmpty()) 0
        else options.size
    }

    inner class MyClassViewHolder(private val binding: DropdownTvBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(position: Int) {
            binding.tvItem.text = options[position]
        }
        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onItemClick(adapterPosition, options)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, options: List<String>)
    }

}