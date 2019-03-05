package com.example.ghofar.tantangan

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.ghofar.tantangan.R.id.btn_register
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    private var mName: EditText? = null
    private var eAddress: EditText? = null
    private var uOrganisasi: EditText? = null
    private var mPasswd: EditText? = null
    private var cPasswd: EditText? = null
    private var mRegisterBtn: Button? = null
    private var Name: String? = null
    private var Email: String? = null
    private var Organisasi: String? = null
    private var Password: String? = null
    private var Confirm: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mName = findViewById<View>(R.id.register_full_name) as EditText
        eAddress = findViewById<View>(R.id.register_email_address) as EditText
        uOrganisasi = findViewById<View>(R.id.register_university) as EditText
        mPasswd = findViewById<View>(R.id.register_password) as EditText
        cPasswd = findViewById<View>(R.id.register_confirm_password) as EditText
        mRegisterBtn = findViewById<View>(R.id.btn_register) as Button

        mRegisterBtn!!.setOnClickListener (View.OnClickListener {
            if (validUserData()) {
                val appData = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE)
                val mEditor = appData.edit()
                mEditor.putString(PREF_NAME, Name)
                mEditor.putString(PREF_PASSWD, Password)
                mEditor.apply()
                gotoLogin()
            }
        })
    }
    private fun validUserData(): Boolean {
        Name = mName!!.text.toString().trim { it <= ' ' }
        Email = eAddress!!.text.toString().trim { it <= ' ' }
        Organisasi = uOrganisasi!!.text.toString().trim {it<=' '}
        Password = mPasswd!!.text.toString().trim { it <= ' ' }
        Confirm = cPasswd!!.text.toString().trim { it <= ' ' }
        return !(Name!!.isEmpty() || Password!!.isEmpty())
    }

    companion object {
        val PREFERENCE = "preference"
        val PREF_NAME = "name"
        val PREF_PASSWD = "passwd"
    }
    private fun gotoLogin(){

    }
}

