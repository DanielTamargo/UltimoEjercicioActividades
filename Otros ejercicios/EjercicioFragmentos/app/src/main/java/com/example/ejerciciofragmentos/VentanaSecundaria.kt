package com.example.ejerciciofragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ventana_secundaria.*
import kotlinx.android.synthetic.main.fragment_imagen_pulsada.*
import kotlinx.android.synthetic.main.fragment_menu.*
import java.lang.Exception

class VentanaSecundaria : AppCompatActivity() {

    var num_imagen = 1
    var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_secundaria)

        num_imagen = try { intent.getIntExtra("num_imagen", 1) } catch (E:Exception) { 1 }

        cambiarImagen()

        imgBtn_1.setOnClickListener {
            num_imagen = 1
            cambiarImagen()
        }
        imgBtn_2.setOnClickListener {
            num_imagen = 2
            cambiarImagen()
        }
        imgBtn_3.setOnClickListener {
            num_imagen = 3
            cambiarImagen()
        }
        imagen.setOnClickListener {
            if (contador == 0) {
                contador += 1
                Toast.makeText(this, "Clica otra vez en la imagen grande para volver...", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }
        }

    }

    fun cambiarImagen() {
        if (num_imagen == 1) imagen.setImageResource(R.drawable.anti_covid_1)
        else if (num_imagen == 2) imagen.setImageResource(R.drawable.anti_covid_2)
        else imagen.setImageResource(R.drawable.anti_covid_3)
    }

}
