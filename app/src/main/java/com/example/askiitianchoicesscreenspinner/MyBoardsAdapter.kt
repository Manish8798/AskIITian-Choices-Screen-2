package com.example.askiitianchoicesscreenspinner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.askiitianchoicesscreenspinner.databinding.DropdownTvBinding

class MyBoardsAdapter(
    private val options: List<String>,
    private val listenerBoard: OnBoardItemClickListener
) :
    RecyclerView.Adapter<MyBoardsAdapter.MyBoardViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBoardViewHolder {
        context = parent.context
        val view = DropdownTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyBoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyBoardViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return if (options.isEmpty()) 0
        else options.size
    }

    inner class MyBoardViewHolder(private val binding: DropdownTvBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(position: Int) {
            binding.tvItem.text = options[position]
        }
        init {
            binding.root.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listenerBoard.onBoardItemClick(adapterPosition, options)
        }
    }

    interface OnBoardItemClickListener {
        fun onBoardItemClick(position: Int, options: List<String>)
    }

}