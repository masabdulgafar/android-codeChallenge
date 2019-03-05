package com.example.ghofar.tantangan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListener()
    }
    private fun setupListener(){
        btn_to_login.setOnClickListener {
            val intent=Intent(this@MainActivity,LoginActivity::class.java)
            startActivity(intent)
        }
        btn_to_register.setOnClickListener {
            val intent=Intent(this@MainActivity,RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
