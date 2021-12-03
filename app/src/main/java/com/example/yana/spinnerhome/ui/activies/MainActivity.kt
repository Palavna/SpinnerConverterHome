package com.example.yana.spinnerhome.ui.activies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.yana.spinnerhome.R
import com.example.yana.spinnerhome.databinding.ActivityMainBinding
import com.example.yana.spinnerhome.ui.currencies.CurrenciesFragment
import com.example.yana.spinnerhome.ui.firstFragment.FirstFragment
import com.example.yana.spinnerhome.ui.secondFragment.SecondFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupFrameLayot()
        changeFragment(FirstFragment())
    }

    private fun setupFrameLayot() {
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.balance-> changeFragment(FirstFragment())
                R.id.length-> changeFragment(SecondFragment())
                R.id.currencies-> changeFragment(CurrenciesFragment())
            }
            true
        }
    }
    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, fragment)
            .commit()
    }
}