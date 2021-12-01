package com.example.yana.spinnerhome.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.yana.spinnerhome.R
import com.example.yana.spinnerhome.data.LengthSpinnerEnum
import com.example.yana.spinnerhome.data.utils.itemSelected
import com.example.yana.spinnerhome.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var binding: FragmentSecondBinding
    private val viewModel: SecondViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()


        viewModel.resultSp.observe(viewLifecycleOwner, {
            binding.tvResultLen.text = it
        })

        val adapter = SpinnerAdapterLength(requireContext(), R.layout.item_spinner_one, viewModel.array)

        binding.spLengthOne.adapter = adapter
        binding.spLengthTwo.adapter = adapter

    }

    fun culc(){
        val etCulc = binding.edEnterLen.text.toString()
        if (etCulc.isNotEmpty()){
            val spOneCulc = binding.spLengthOne.selectedItemPosition
            val spTwoCulc = binding.spLengthTwo.selectedItemPosition
            viewModel.getResultLen(etCulc.toDouble(), spOneCulc, spTwoCulc)
        }else{
            binding.tvResultLen.text = ""
        }
    }


    private fun setupListeners() {
        binding.edEnterLen.doAfterTextChanged { culc() }
        binding.spLengthOne.itemSelected{ culc() }
        binding.spLengthTwo.itemSelected { culc() }
    }
}