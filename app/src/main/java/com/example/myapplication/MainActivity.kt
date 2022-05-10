package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContract
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.decorator.DecoratorOthers
import com.example.myapplication.decorator.DecoratorUI
import com.example.myapplication.linked.DoubleLinkedData
import com.example.myapplication.linked.SingleLinkedData
import com.example.myapplication.square.Square
import com.example.myapplication.strategy.duck.DuckUI
import com.example.myapplication.strategy.weapon.RoleUI


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        DuckUI(this)
        DecoratorUI(this)
//        DecoratorOthers().showFile(this)
//        DoubleLinkedData().setData()
//        SingleLinkedData().setData()

//        RoleUI().setData(this)
//        Square().setData(this)
        val iCall = registerForActivityResult(CallBack()) {
            Log.v("aaa", "it=$it")
        }


        iCall.launch("I'm first!!")
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
    }

}


class CallBack: ActivityResultContract<String, String?>() {

    override fun createIntent(context: Context, input: String?): Intent {
        return Intent(context, Second::class.java).apply {
            input?.let {
                putExtra("Test",it)
            }
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        return if( resultCode == 520484) {
            intent?.getStringExtra("TestTwo")
        } else {
            null
        }
    }
}



