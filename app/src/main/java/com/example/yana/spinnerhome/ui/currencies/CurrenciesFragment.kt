package com.example.yana.spinnerhome.ui.currencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.yana.spinnerhome.R
import com.example.yana.spinnerhome.databinding.FragmentFirstBinding
import com.example.yana.spinnerhome.ui.SpinnerAdapter
import com.example.yana.spinnerhome.ui.firstFragment.FirstViewModel
import com.example.yana.spinnerhome.utils.itemSelected

class CurrenciesFragment : Fragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: CurrenciesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setupListeners()
//
//        viewModel.resultSp.observe(viewLifecycleOwner, {
//            binding.tvResult.text = it
//        })
//
//        val adapter = SpinnerAdapter(requireContext(), R.layout.item_spinner_one, viewModel.array)
//
//        binding.spinnerOne.adapter = adapter
//        binding.spinnerTwo.adapter = adapter
//    }

    fun culc() {
//        val etCulc = binding.edEnter.text.toString()
//        if (etCulc.isNotEmpty()) {
//            val spOneCulc = binding.spinnerOne.selectedItemPosition
//            val spTwoCulc = binding.spinnerTwo.selectedItemPosition
//            viewModel.getResult(etCulc.toDouble(), spOneCulc, spTwoCulc)
//        } else {
//            binding.tvResult.text = ""
//        }
    }


   fun setupListeners() {
        binding.edEnter.doAfterTextChanged { culc() }
        binding.spinnerOne.itemSelected { culc() }
        binding.spinnerTwo.itemSelected { culc() }
    }}}