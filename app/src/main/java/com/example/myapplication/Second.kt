package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.oberserver.climate.inter.DisplayElement
import com.example.myapplication.oberserver.climate.inter.Observer

 class Second : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras
        Log.v("aaa","second =${intent.extras?.getString("Test")}")
        setResult(520484, Intent().apply { putExtra("TestTwo", "ME!! OMG!!") })
        finish()
    }


     var xx:String ?= null
     // not return parameter
     fun setValue(pString: String){
         //TODO 此為 new
         val ixx = IXXX()
         val ix = xx ?: 111

         val izz = ixx.ix

         if( ixx.ix is Int) {
             //TODO ixx.ix 不會自動轉型為int
         }

         if( izz is Int) {
             //TODO izz會自動轉型
             izz.inc()
         }

         if( ix is Int) {
             //TODO ix會自動轉型
             ix.inc()
         } else if( ix is String){
             //TODO ix會自動轉型
             ix.length
         }

         xx?.let {

         } ?: kotlin.run {

         }
         return
     }

     fun getValue() : String {
         return "return"
     }
}

class IXXX {

    val mBlood = false

    val ix by lazy {
        if( mBlood) {
            "xxx"
        } else {
            111
        }
    }
}



