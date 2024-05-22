package com.example.consultabasedatostc100321

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.consultabasedatostc100321.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNuevoRegistro.setOnClickListener {
            val intent = Intent(this,Guardar::class.java)
            startActivity(intent)
        }

    }
}