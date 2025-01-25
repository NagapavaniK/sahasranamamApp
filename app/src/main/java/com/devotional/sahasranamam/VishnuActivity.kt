package com.devotion.sahasranamam

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException
import java.io.InputStream

class VishnuActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        layoutInflater.inflate(R.layout.activity_vishnu, findViewById(R.id.container))

        // Set the toolbar title
        val title = getString(R.string.sree_vishnu_sahasranamam)
        setToolbarTitle(title)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val myTextView: TextView = findViewById(R.id.textView) // Reference your TextView

        val myOutput: String

        // Declaring an input stream to read data
        val myInputStream: InputStream

        // Try to open the text file, reads
        // the data and stores it in the string
        try {
            myInputStream = assets.open("Vishnu.txt")
            val size: Int = myInputStream.available()
            val buffer = ByteArray(size)
            myInputStream.read(buffer)
            myOutput = String(buffer)

            // Sets the TextView with the string
            myTextView.text = myOutput

        } catch (e: IOException) {
            // Exception
            e.printStackTrace()
        }
    }
}