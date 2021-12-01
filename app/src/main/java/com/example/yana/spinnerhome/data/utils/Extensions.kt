package com.example.yana.spinnerhome.data.utils

import android.view.View
import android.widget.AdapterView
import android.widget.Spinner

fun Spinner.itemSelected(callback:() -> Unit){

    onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            callback.invoke()
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
            callback.invoke()
        }
    }
}