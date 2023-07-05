package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    lateinit var tvlogin : TextView
    lateinit var tilfirstname:TextInputLayout
    lateinit var tilLastname:TextInputLayout
    lateinit var tilEmail: TextInputLayout
    lateinit var tilpassword:TextInputLayout
    lateinit var tilconfirmpassword:TextInputLayout
    lateinit var etfirstname:TextInputEditText
    lateinit var etlastname:TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var etpassword:TextInputEditText
    lateinit var etconfirmpassword:TextInputEditText
    lateinit var btnsignup:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        castViews()



    }

    override fun onResume() {
        super.onResume()
        tvlogin.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        btnsignup.setOnClickListener {
            validateSignUp()
        }
    }

    fun castViews(){
        tvlogin = findViewById(R.id.tvlogin)
        tilfirstname=findViewById(R.id.tilfirstname)
        tilLastname=findViewById(R.id.tilLastname)
        etEmail=findViewById(R.id.etEmail)
        etfirstname=findViewById(R.id.etfirstname)
        tilpassword=findViewById(R.id.tilpassword)
        etpassword=findViewById(R.id.etpassword)
        etconfirmpassword=findViewById(R.id.etconfirmpassword)
        btnsignup=findViewById(R.id.btnsignup)

    }
    fun validateSignUp(){
        val firstName=etfirstname.text.toString()
        val lastName =etlastname.text.toString()
        val email=etEmail.text.toString()
        val password=etpassword.text.toString()
        val confirmPassword=etconfirmpassword.text.toString()
        var  error =false


        if(firstName.isBlank()){
            tilfirstname.error ="First name  is required"
            error=true
        }
        if(lastName.isBlank()){
            tilLastname.error ="Last name  is required"
            error=true
        }
        if(email.isBlank()){
            tilEmail.error ="Email is required"
            error=true
        }
        if(password.isBlank()){
            tilpassword.error ="Password  is required"
            error = true
        }
        if(password!=confirmPassword ){
            tilconfirmpassword.error ="Confirm password  is required"
            error = true

        }
        if (!error){
            Toast.makeText(this,"$firstName $lastName $email",Toast.LENGTH_LONG)
                .show()
        }

    }
}

