package com.example.consultabasedatostc100321

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.consultabasedatostc100321.databinding.ActivityGuardarBinding

class Guardar : AppCompatActivity() {

    private lateinit var binding: ActivityGuardarBinding
    private lateinit var db: BaseDatos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuardarBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_guardar)
        setContentView(binding.root)
        db = BaseDatos(this)

        binding.btnGuardar.setOnClickListener{
            val mensaje = binding.txtData.text.toString()
            val registro = Registro(mensaje)
            db.insertarMensaje(registro)
            finish()
            Toast.makeText(this, "SE HA GUARDADO EL MENSAJE", Toast.LENGTH_LONG).show()
        }

    }
}