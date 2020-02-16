package com.tamargo.ejercicio4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_ventana_vehiculos.*

class VentanaVehiculos : AppCompatActivity() {

    companion object {
        var nombre_coche = ""
        var precio_coche = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ventana_vehiculos)

        val edadStr = try {intent.getStringExtra("edad")}catch (E:Exception){" -1 "}

        val edad = edadStr.toInt()

        if (edad < 18) {
            coches_layout.visibility = View.GONE
        }

        cb_coche1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (cb_coche1.isChecked) {
                cb_coche2.isChecked = false
                cb_coche3.isChecked = false
                cb_moto1.isChecked = false
                cb_moto2.isChecked = false
                cb_moto3.isChecked = false

                nombre_coche = "Audi A4"
                precio_coche = "1500€"
            }
        }
        cb_coche2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (cb_coche2.isChecked) {
                cb_coche1.isChecked = false
                cb_coche3.isChecked = false
                cb_moto1.isChecked = false
                cb_moto2.isChecked = false
                cb_moto3.isChecked = false

                nombre_coche = "Audi A3"
                precio_coche = "1300€"
            }
        }
        cb_coche3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (cb_coche3.isChecked) {
                cb_coche1.isChecked = false
                cb_coche2.isChecked = false
                cb_moto1.isChecked = false
                cb_moto2.isChecked = false
                cb_moto3.isChecked = false

                nombre_coche = "Audi A2"
                precio_coche = "1000€"
            }
        }
        cb_moto1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (cb_moto1.isChecked) {
                cb_coche1.isChecked = false
                cb_coche2.isChecked = false
                cb_coche3.isChecked = false
                cb_moto2.isChecked = false
                cb_moto3.isChecked = false

                nombre_coche = "Triumph Tiger 900"
                precio_coche = "1000€"
            }
        }
        cb_moto2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (cb_moto2.isChecked) {
                cb_coche1.isChecked = false
                cb_coche2.isChecked = false
                cb_coche3.isChecked = false
                cb_moto1.isChecked = false
                cb_moto3.isChecked = false

                nombre_coche = "Triumph Tiger 800"
                precio_coche = "800€"
            }
        }
        cb_moto3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (cb_moto3.isChecked) {
                cb_coche1.isChecked = false
                cb_coche2.isChecked = false
                cb_coche3.isChecked = false
                cb_moto1.isChecked = false
                cb_moto2.isChecked = false

                nombre_coche = "Triumph Tiger 700"
                precio_coche = "500€"
            }
        }

        boton.setOnClickListener {
            if (!cb_coche1.isChecked && !cb_coche2.isChecked && !cb_coche3.isChecked
                && !cb_moto1.isChecked && !cb_moto2.isChecked && !cb_moto3.isChecked ) {
                nombre_coche = "No has elegido ningún vehículo"
                precio_coche = ""
            }
            val resultado = Intent()
            resultado.putExtra("nombre_coche", nombre_coche)
            resultado.putExtra("precio_coche", precio_coche)
            setResult(Activity.RESULT_OK, resultado)
            finish()
        }

    }

}
