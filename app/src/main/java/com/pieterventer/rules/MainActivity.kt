package com.pieterventer.rules

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val stringExample: String = "hello"

    val integerExample: Int = 7

    val a: String =
        "some really confusing and important string without any meaning because the variable's name is a...."

    val b: String = "see a"

    val mTriggeringVariable = "I really love this naming convention"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar?.let {
            setSupportActionBar(it)
        }

        val string = "hello"

        Log.v("hello", string)
    }

    fun blah() {

    }
}