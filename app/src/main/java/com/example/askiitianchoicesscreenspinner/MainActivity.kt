package com.example.askiitianchoicesscreenspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import com.example.askiitianchoicesscreenspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "Main"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectClassCv.setOnClickListener {
            binding.tvInputLayout.visibility = View.VISIBLE
            Log.d(TAG, "onCreate: Cv Clicked")
        }
    }

    override fun onResume() {
        super.onResume()
        val adapter = ArrayAdapter(this, R.layout.dropdown_tv, R.id.tv_item, selectClassDropDownNames())
        binding.autoCompleteTv.setAdapter(adapter)
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

    private fun preparingForOptions(): List<String> {
        return listOf("School Exam", "JEE", "NEET")
    }
}