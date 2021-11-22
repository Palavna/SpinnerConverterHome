package com.example.yana.spinnerhome.data.ui

class Tonna(): Metrica(){
    fun formula(edEnter: String): String{
        if (edEnter.isNotEmpty()){
            val result = edEnter.toInt() * namber
            return result.toString()
        }else{
            return ""
        }
    }

    
    override val namber: Int = 1000
}