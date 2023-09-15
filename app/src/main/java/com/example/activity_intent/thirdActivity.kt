package com.example.activity_intent

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activity_intent.MainActivity.Companion.EXTRA_NAME
import com.example.activity_intent.SecondActivity.Companion.EXTRA_ADDRESS
import com.example.activity_intent.databinding.ActivityThirdBinding

class thirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(EXTRA_NAME)
        with(binding) {
            btnToSecondActivity.setOnClickListener {
                val resultIntent = Intent()
// Memasukkan alamat ke Intent
                resultIntent.putExtra(EXTRA_ADDRESS, edtAddress.text.toString())
                resultIntent.putExtra(EXTRA_NAME, name)
// Menetapkan result code dan data Intent
                setResult(Activity.RESULT_OK, resultIntent)
// Menyelesaikan aktivitas
                finish()
            }
        }
    }
}