package com.devotion.sahasranamam

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.IOException
import java.io.InputStream

class lalithaNamamaActivity : BaseActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_lalitha_namama)
        // Inflate the specific content layout into BaseActivity's container
        // Inflate the specific content layout into BaseActivity's container
        layoutInflater.inflate(R.layout.activity_lalitha_namama, findViewById(R.id.container))

        // Set the toolbar title
        val title = getString(R.string.sree_lalitha_sahasra_namam)
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
            myInputStream = assets.open("Lalitha.txt")
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
