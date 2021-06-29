package com.example.askiitianchoicesscreenspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.askiitianchoicesscreenspinner.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val choices = intent.getSerializableExtra("selected_option")
        binding.userChoiceTv.text = choices.toString()
    }
}