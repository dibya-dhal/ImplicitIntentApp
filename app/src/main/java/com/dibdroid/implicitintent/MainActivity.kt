package com.dibdroid.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Telephony
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


         val btnDial = findViewById<Button>(R.id.btnDial)
        val btnMessage = findViewById<Button>(R.id.btnMessage)
        val btnEmail = findViewById<Button>(R.id.btnEmail)
        val btnShare = findViewById<Button>(R.id.btnShare)


            // Dial

        btnDial.setOnClickListener {

            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: 9858595860")
            startActivity(intent)

        }

// Message

        btnMessage.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("smsto: 9874564345")
            intent.putExtra("sms_body ", "Hi, After a long time!")
            startActivity(intent)


        }





        // Send Email

        btnEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("malito : example@gmail.com")
            intent.putExtra(Intent.EXTRA_TEXT, " This is a text email from my app")
            startActivity(Intent.createChooser(intent,"Send Email"))
        }

        // Share Text
        btnShare.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO)
            intent.type = "text/ plain"
            intent.putExtra(Intent.EXTRA_TEXT,"Check out this cool Android app!")
            startActivity(Intent.createChooser(intent,"Share using"))
        }


        }
    }


