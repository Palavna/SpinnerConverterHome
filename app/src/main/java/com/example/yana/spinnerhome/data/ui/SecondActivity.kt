package com.example.yana.spinnerhome.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.example.yana.spinnerhome.R
import com.example.yana.spinnerhome.databinding.ActivityMainBinding
import com.example.yana.spinnerhome.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private val viewModel: SecondViewModel by viewModels()

    val array = arrayOf(
        LengthSpinnerEnum.MILLIMETR,
        LengthSpinnerEnum.SANTIMETR,
        LengthSpinnerEnum.METR,
        LengthSpinnerEnum.KILOMETR,
        LengthSpinnerEnum.MILYA,
        LengthSpinnerEnum.YARD,
        LengthSpinnerEnum.FUT,
        LengthSpinnerEnum.DUIM)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()


        viewModel.resultSp.observe(this, {
            binding.tvResultLen.text = it
        })

        val adapter = SpinnerAdapterLength(this, R.layout.item_spinner_one, array)

        binding.spLengthOne.adapter = adapter
        binding.spLengthTwo.adapter = adapter

    }

    fun culc(){
        val etCulc = binding.edEnterLen.text.toString()
        if (etCulc.isNotEmpty()){
            val spOneCulc = binding.spLengthOne.selectedItemPosition
            val spTwoCulc = binding.spLengthTwo.selectedItemPosition
            viewModel.getResultLen(etCulc.toDouble(), array[spOneCulc].value, array[spTwoCulc].value)
        }else{
            binding.tvResultLen.text = ""
        }
    }


    private fun setupListeners() {
        binding.edEnterLen.doAfterTextChanged { culc() }
        binding.spLengthOne.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                culc()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                culc()
            }
        }
        binding.spLengthTwo.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                culc()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                culc()
            }

        }
    }
}