package com.example.yana.spinnerhome.data.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.yana.spinnerhome.databinding.ItemSpinnerOneBinding
import com.example.yana.spinnerhome.databinding.ItemSpinnerTwoBinding

class SpinnerAdapter(context: Context, resId: Int, private val array: Array<String>):
    ArrayAdapter<String>(context, resId, array) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding =
            ItemSpinnerOneBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.tvTitle.text = array[position]
        return binding.root
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding =
            ItemSpinnerTwoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.spTvTitle.text = array[position]
        return binding.root
    }
}