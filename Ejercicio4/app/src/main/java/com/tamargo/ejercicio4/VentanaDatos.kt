package com.tamargo.ejercicio4

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ventana_datos.*
import java.lang.NumberFormatException

class VentanaDatos : AppCompatActivity() {

    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_datos)

        boton.setOnClickListener { devolverDatos() }
    }

    @SuppressLint("SetTextI18n")
    fun devolverDatos() {
        var nombre = ""
        var apellidos = ""
        var edad = -1
        if (t_nombre.text.isNotEmpty() && t_apellidos.text.isNotEmpty() && t_edad.text.isNotEmpty()) {
            try {
                edad = t_edad.text.toString().toInt()
            } catch (x: NumberFormatException) {
                edad = -1
            }
            nombre = t_nombre.text.toString()
            apellidos = t_apellidos.text.toString()

            if (edad >= 14) {
                val resultado = Intent()
                resultado.putExtra("nombre", nombre)
                resultado.putExtra("apellidos", apellidos)
                resultado.putExtra("edad", t_edad.text.toString())
                setResult(Activity.RESULT_OK, resultado)
                finish()
            } else {
                l_error.text = "Error. No has introducido una edad válida (mínimo 14 años)."
            }
        } else {
            l_error.text = "Error. ¡Rellena todos los datos!."
        }
    }


}
