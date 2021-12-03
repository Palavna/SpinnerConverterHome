package com.example.yana.spinnerhome.ui.currencies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.yana.spinnerhome.R
import com.example.yana.spinnerhome.databinding.FragmentCurrenciesBinding
import com.example.yana.spinnerhome.ui.SpinnerAdapterCurrencies
import com.example.yana.spinnerhome.utils.itemSelected
import org.koin.androidx.viewmodel.ext.android.viewModel

class CurrenciesFragment : Fragment(R.layout.fragment_currencies) {

    private lateinit var binding: FragmentCurrenciesBinding
    private val viewModel by viewModel<CurrenciesViewModel>()
    private var adapter: SpinnerAdapterCurrencies? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCurrenciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadCurrencies()
        setupListeners()

        viewModel.resultSp.observe(viewLifecycleOwner, {
             adapter = SpinnerAdapterCurrencies(requireContext(), R.layout.item_spinner_one, it)
            binding.spinnerOne.adapter = adapter
            binding.spinnerTwo.adapter = adapter
        })

        viewModel.resultCur.observe(viewLifecycleOwner, {
            binding.tvResult.text = it
        })
    }

    fun culc() {
        val etCulc = binding.edEnter.text.toString()
        if (etCulc.isNotEmpty()) {
            val spOneCulc = binding.spinnerOne.selectedItemPosition
            val spTwoCulc = binding.spinnerTwo.selectedItemPosition
            viewModel.getResult(etCulc.toDouble(), spOneCulc, spTwoCulc)
        } else {
            binding.tvResult.text = ""
        }
    }


   fun setupListeners() {
        binding.edEnter.doAfterTextChanged { culc() }
        binding.spinnerOne.itemSelected { culc() }
        binding.spinnerTwo.itemSelected { culc() }
    }}