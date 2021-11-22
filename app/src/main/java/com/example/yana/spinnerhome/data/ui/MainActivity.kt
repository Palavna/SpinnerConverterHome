package com.example.yana.spinnerhome.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.yana.spinnerhome.R
import com.example.yana.spinnerhome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupSpinner()
        setupSpinnerSimple()
        setupListeners()
    }

    private fun setupListeners() {
        binding.btnResult.setOnClickListener {
            binding.tvResult.text = Tonna().formula(binding.edEnter.text.toString())
        }
    }


    private fun setupSpinner() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.magnitude,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerOne.adapter = adapter
    }
    private fun setupSpinnerSimple() {
        val adapterSp = ArrayAdapter.createFromResource(
            this,
            R.array.magnitudes,
            android.R.layout.simple_spinner_item
        )
        adapterSp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerTwo.adapter = adapterSp
    }
}