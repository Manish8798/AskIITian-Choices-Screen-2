package com.example.askiitianchoicesscreenspinner

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.askiitianchoicesscreenspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyClassesAdapter.OnItemClickListener,
    MyBoardsAdapter.OnBoardItemClickListener, MyExamsAdapter.OnExamItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "Main"
    private var checkStatusBoard = false
    private var checkStatusExams = false
    private val userSelection: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userSelection.add("0")
        userSelection.add("0")
        userSelection.add("0")

        binding.rvClassesDropdown.apply {
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
                if (rvClassesDropdown.isVisible) {
                    rvClassesDropdown.visibility = View.GONE
                } else {
                    rvClassesDropdown.visibility = View.VISIBLE
                }
            }
            includeSelectBoards.apply {
                selectBoardsCv.setOnClickListener {
                    if (checkStatusBoard) {
                        if (rvSelectBoards.isVisible) {
                            rvSelectBoards.visibility = View.GONE
                        } else {
                            rvSelectBoards.visibility = View.VISIBLE
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "select class first", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            includeSelectExams.apply {
                selectExamsCv.setOnClickListener {
                    if (checkStatusExams) {
                        if (rvSelectExams.isVisible) {
                            rvSelectExams.visibility = View.GONE
                        } else {
                            rvSelectExams.visibility = View.VISIBLE
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "select board first", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            confirmBtn.setOnClickListener {
                Log.d(TAG, "user selection: ${userSelection}")
                if (!userSelection.contains("0")) {
                    Intent(this@MainActivity, SecondActivity::class.java).also {
                        it.putExtra("selected_option", userSelection)
                        startActivity(it)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "select all 3 options", Toast.LENGTH_SHORT)
                        .show()
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
        userSelection[1] = options[position]
        checkStatusExams = true
        Log.d(TAG, "onBoardItemClick: ${userSelection}")
    }

    override fun onItemClick(position: Int, options: List<String>) {
        binding.selectedClassTv.text = options[position]
        binding.selectedClassTv.visibility = View.VISIBLE
        binding.rvClassesDropdown.visibility = View.GONE
        userSelection[0] = options[position]
        checkStatusBoard = true
        Log.d(TAG, "onItemClick: $userSelection")
    }

    override fun onExamItemClick(position: Int, options: List<String>) {
        binding.includeSelectExams.selectedExamTv.text = options[position]
        binding.includeSelectExams.selectedExamTv.visibility = View.VISIBLE
        binding.includeSelectExams.rvSelectExams.visibility = View.GONE
        userSelection[2] = options[position]
        Log.d(TAG, "onExamItemClick: $userSelection")
    }

}