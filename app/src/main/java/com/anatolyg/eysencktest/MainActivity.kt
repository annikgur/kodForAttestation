package com.anatolyg.eysencktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
            finish()
        }

        val address = Uri.parse("https://ru.wikipedia.org/wiki/%D0%90%D0%B9%D0%B7%D0%B5%D0%BD%D0%BA,_%D0%93%D0%B0%D0%BD%D1%81_%D0%AE%D1%80%D0%B3%D0%B5%D0%BD")
        val toBrowser = Intent(Intent.ACTION_VIEW, address)
        val browserButton: Button = findViewById(R.id.browser_button)
        browserButton.setOnClickListener {
            startActivity(toBrowser)
        }


    }
}