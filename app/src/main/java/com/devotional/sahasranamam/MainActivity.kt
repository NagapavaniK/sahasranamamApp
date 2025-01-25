package com.devotion.sahasranamam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        layoutInflater.inflate(R.layout.activity_main, findViewById(R.id.container))
        val title=getString(R.string.app_title)
        // Set up the shared AppBarLayout
        setToolbarTitle(title) // Pass the desired title


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lalithaButton: Button = findViewById(R.id.lalithaNamamBttn)
        val vishnuButton: Button = findViewById(R.id.vishnuNamamBttn)
        val chalisaButton: Button = findViewById(R.id.chalisaBttn)
        val govindaNamamButton: Button = findViewById(R.id.govindaNamamBttn)
        val sivaNamamButton:Button=findViewById(R.id.sivaNamamBttn)
        val adithyaButton:Button=findViewById(R.id.adityaBttn)


        navigateToActivity(lalithaButton, lalithaNamamaActivity::class.java)
        navigateToActivity(vishnuButton, VishnuActivity::class.java)
        navigateToActivity(chalisaButton, ChalisaActivity::class.java)
        navigateToActivity(govindaNamamButton, GovindaActivity::class.java)
        navigateToActivity(sivaNamamButton,sivaNamamAcitivty::class.java)
        navigateToActivity(adithyaButton,adithyaActivity::class.java)


    }

    private fun navigateToActivity(buttnName: Button, targetActivity: Class<*>) {

        buttnName.setOnClickListener {
            val intent = Intent(this, targetActivity)
            startActivity(intent)
        }
    }
}
