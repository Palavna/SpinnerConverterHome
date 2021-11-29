package com.example.yana.spinnerhome.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModel
import com.example.yana.spinnerhome.R
import com.example.yana.spinnerhome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    val array = arrayOf(SpinnerEnum.MILLIGRAMM,
        SpinnerEnum.GRAMM, SpinnerEnum.KILLOGRAMM, SpinnerEnum.TONNA,
        SpinnerEnum.FUNT, SpinnerEnum.STON, SpinnerEnum.UNCIYA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()


        viewModel.resultSp.observe(this, {
            binding.tvResult.text = it
        })

        val adapter = SpinnerAdapter(this, R.layout.item_spinner_one, array)

        binding.spinnerOne.adapter = adapter
        binding.spinnerTwo.adapter = adapter

    }

   fun culc(){
        val etCulc = binding.edEnter.text.toString()
       if (etCulc.isNotEmpty()){
           val spOneCulc = binding.spinnerOne.selectedItemPosition
           val spTwoCulc = binding.spinnerTwo.selectedItemPosition
           viewModel.getResult(etCulc.toDouble(), array[spOneCulc].value, array[spTwoCulc].value)
       }else{
           binding.tvResult.text = ""
       }
    }


    private fun setupListeners() {
        binding.edEnter.doAfterTextChanged { culc() }
        binding.spinnerOne.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                culc()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                culc()
            }
        }
        binding.spinnerTwo.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                culc()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                culc()
            }

        }
    }
}