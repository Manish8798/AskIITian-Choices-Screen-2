package com.example.askiitianchoicesscreenspinner

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.askiitianchoicesscreenspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyClassesAdapter.OnItemClickListener,
    MyBoardsAdapter.OnBoardItemClickListener, MyExamsAdapter.OnExamItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDropdown.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MyClassesAdapter(selectClassDropDownNames(), this@MainActivity)
        }

        binding.includeSelectBoards.rvSelectBoards.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MyBoardsAdapter(selectBoardNames(), this@MainActivity)
        }

        binding.includeSelectExams.rvSelectExams.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = MyExamsAdapter(selectExamNames(), this@MainActivity)
        }

        binding.apply {
            selectClassesCv.setOnClickListener {
                rvDropdown.visibility = View.VISIBLE
            }
            includeSelectBoards.apply {
                selectBoardsCv.setOnClickListener {
                    rvSelectBoards.visibility = View.VISIBLE
                }
            }
            includeSelectExams.apply {
                selectExamsCv.setOnClickListener {
                    rvSelectExams.visibility = View.VISIBLE
                }
            }
        }

    }

    private fun selectClassDropDownNames(): List<String> {
        return listOf(
            "12 pass",
            "class 12",
            "class 11",
            "class 10",
            "class 9",
            "class 8",
            "class 7",
            "class 6"
        )
    }

    private fun selectBoardNames(): List<String> {
        return listOf("C.B.S.E", "I.C.S.E", "L.B", "Other")
    }

    private fun selectExamNames(): List<String> {
        return listOf("School Exam", "JEE", "NEET")
    }

    override fun onBoardItemClick(position: Int, options: List<String>) {
        binding.includeSelectBoards.selectedBoardTv.text = options[position]
        binding.includeSelectBoards.selectedBoardTv.visibility = View.VISIBLE
        binding.includeSelectBoards.rvSelectBoards.visibility = View.GONE
    }

    override fun onItemClick(position: Int, options: List<String>) {
        binding.selectedClassTv.text = options[position]
        binding.selectedClassTv.visibility = View.VISIBLE
        binding.rvDropdown.visibility = View.GONE
    }

    override fun onExamItemClick(position: Int, options: List<String>) {
        binding.includeSelectExams.selectedExamTv.text = options[position]
        binding.includeSelectExams.selectedExamTv.visibility = View.VISIBLE
        binding.includeSelectExams.rvSelectExams.visibility = View.GONE
    }

}