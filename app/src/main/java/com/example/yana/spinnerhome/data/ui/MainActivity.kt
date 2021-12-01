package com.example.yana.spinnerhome.data.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.example.yana.spinnerhome.R
import com.example.yana.spinnerhome.data.SpinnerEnum
import com.example.yana.spinnerhome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFrameLayot()
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, FirstFragment())
            .commit()
    }

    private fun setupFrameLayot() {
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.balance->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containerFragment, FirstFragment())
                        .commit()
                }
                R.id.length->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.containerFragment, SecondFragment())
                        .commit()
                }
            }
            true
        }
    }
}