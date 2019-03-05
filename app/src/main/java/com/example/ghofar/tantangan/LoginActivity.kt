package com.example.ghofar.tantangan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ghofar.tantangan.R.string.et_email_address
import com.example.ghofar.tantangan.R.string.et_password
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var appData: AppDataPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupComponent()
        setupListener()

    }
    private fun setupComponent() {
        appData = AppDataPreferences(this)
    }

    private fun setupListener() {
        btn_login.setOnClickListener {
            login()
        }
    }
    private fun login() {
        val username = et_email_address.text.toString().trim()
        val password = et_password.text.toString().trim()

        if (username == "abdul@mtsalam.sch.id" && password == "masuk") {
            appData.putIsUserLoggedIn(true)
            Toast.makeText(this, getString(R.string.msg_login_success), Toast.LENGTH_SHORT).show()
            gotoMain()
        } else {
            Toast.makeText(this, getString(R.string.msg_login_failed), Toast.LENGTH_SHORT).show()
        }
    }

    private fun gotoMain() {
        val intent = Intent(this@LoginActivity, RecyclerView::class.java)
        startActivity(intent)
        finish()
    }
}
