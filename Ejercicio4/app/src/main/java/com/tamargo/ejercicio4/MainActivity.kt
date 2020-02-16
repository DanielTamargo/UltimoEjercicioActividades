package com.tamargo.ejercicio4

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    companion object {
        val PEDIR_DATOS = 1
        val VEHICULO = 2

        var nombre = "aún sin insertar"
        var apellidos = "aún sin insertar"
        var edad = -1 //<- -1 = error

        var nombre_coche = ""
        var precio_coche = ""
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b_pedirDatos.setOnClickListener { ventanaDatos() }

        b_verVehiculos.setOnClickListener { ventanaVehiculos() }

    }

    fun ventanaDatos() {
        val intento = Intent(this,VentanaDatos::class.java)
        startActivityForResult(intento, PEDIR_DATOS)
    }

    fun ventanaVehiculos() {
        if (edad != -1) {
            val intento = Intent(this, VentanaVehiculos::class.java)
            var edadStr = edad.toString()
            intento.putExtra("edad", edadStr)
            startActivityForResult(intento, VEHICULO)
        } else {
            Toast.makeText(this, "Primero introduce algunos datos", Toast.LENGTH_LONG).show()

        }

    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            PEDIR_DATOS -> {
                nombre= try { data?.getStringExtra("nombre").toString() } catch (e:Exception) { "" }
                apellidos = try { data?.getStringExtra("apellidos").toString() } catch (e:Exception) { "" }
                edad = try { data?.getStringExtra("edad").toString().toInt() } catch (e:Exception) {-1}

                b_verVehiculos.isClickable = true
                l_guia.text = "Ahora puedes ver los vehículos disponibles"

                println(nombre)
                println(apellidos)
                println(edad)

                l_nombre.text = "Nombre: $nombre"
                l_apellidos.text = "Apellidos: $apellidos"
                l_edad.text = "Edad: $edad"

                l_nombre.visibility = View.VISIBLE
                l_apellidos.visibility = View.VISIBLE
                l_edad.visibility = View.VISIBLE

                Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_LONG).show()
            }
            VEHICULO -> {
                nombre_coche = try { data?.getStringExtra("nombre_coche").toString() } catch (e:Exception) { "" }
                precio_coche = try { data?.getStringExtra("precio_coche").toString() } catch (e:Exception) { "" }

                l_coche.text = "Vehículo seleccionado: $nombre_coche\nPrecio: $precio_coche"

                l_coche.visibility = View.VISIBLE

                Toast.makeText(this, "Datos actualizados correctamente", Toast.LENGTH_LONG).show()
            }
        }
    }
}
