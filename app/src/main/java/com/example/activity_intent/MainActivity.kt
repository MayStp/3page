package com.example.activity_intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activity_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "LiveCycle"
    companion object{
        const val EXTRA_NAME = "extra_name"
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            btnSendMessage.setOnClickListener {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Hello, this is a message from my app!")
                startActivity(Intent.createChooser(intent, "Select an app"))
            }
            btnDial.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:1234567890")
                startActivity(intent)
            }
            btnOpenLink.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.google.com")
                startActivity(intent)
            }
            btnSecond.setOnClickListener {
                val intentToSecondActivity =
                    Intent(this@MainActivity, SecondActivity::class.java)
                intentToSecondActivity.putExtra(EXTRA_NAME, edtName.text.toString())
                startActivity(intentToSecondActivity)
            }

        }
        Log.d(TAG, "onCreate: dipanggil")
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart: Dipanggil")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Dipanggil")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Dipanggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop: Dipanggil")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy: Dipanggil")
    }
}