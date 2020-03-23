package com.example.contador

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * botones:
 * - b_sumar -> suma o resta 1 al contador
 * - b_invertir -> invierte para que sume o reste
 * - b_negativos -> acepta o deniega negativos
 *
 * variables:
 * - contador -> un int que lleva la cuenta del contador
 * - invertido -> un boolean que controle que se sume o reste
 * - aceptar_negativos -> un boolean que controle que se aceptan o deniegan números negativos
 */

class MainActivity : AppCompatActivity() {

    companion object {
        val cuenta = "cuenta"
        val cuenta_invertida = "cuenta_invertida"
        val cuenta_aceptar_negativos = "cuenta_aceptar_negativos"
    }

    private var contador: Int = 0
    private var invertido: Boolean = false
    private var aceptar_negativos: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        efectos_invertir_contador()
        efectos_aceptar_negativos()
        actualizar_contador()

        b_sumar.setOnClickListener { sumar_al_contador() }
        b_invertir.setOnClickListener { invertir_contador() }
        b_negativos.setOnClickListener { invertir_aceptar_negativos() }
    }

    fun sumar_al_contador() {
        if (invertido) {
            if (aceptar_negativos) {
                contador--
            } else {
                if (contador > 0) {
                    contador--
                } else {
                    Toast.makeText(this,"Tienes que activar los negativos o invertir el contador para poder seguir.", Toast.LENGTH_LONG).show()
                }
            }
        } else {
            contador ++
        }
        actualizar_contador()
    }

    fun invertir_contador() {
        if (invertido) invertido = false
        else invertido = true
        efectos_invertir_contador()
    }

    fun efectos_invertir_contador() {
        if (invertido) {
            b_sumar.setText("Restar al contador")
        } else {
            b_sumar.setText("Sumar al contador")
        }
    }

    fun invertir_aceptar_negativos() {
        if (aceptar_negativos) aceptar_negativos = false
        else aceptar_negativos = true
        efectos_aceptar_negativos()
    }

    fun efectos_aceptar_negativos() {

        if (aceptar_negativos) {
            t_negativos.setText("Negativos: Sí")
            b_negativos.setText("Denegar Negativos")
        } else {
            t_negativos.setText("Negativos: No")
            b_negativos.setText("Aceptar Negativos")
            if (contador < 0) {
                contador = 0
                Toast.makeText(this,"Negativos denegados, subiendo contador hasta 0...", Toast.LENGTH_LONG).show()
                actualizar_contador()
            }
        }
    }

    fun actualizar_contador() {
        t_contador.setText("" + contador)
    }

    override fun onSaveInstanceState(estado: Bundle) {
        estado.putInt(cuenta, contador)
        estado.putBoolean(cuenta_invertida, invertido)
        estado.putBoolean(cuenta_aceptar_negativos, aceptar_negativos)
        super.onSaveInstanceState(estado)
    }

    override fun onRestoreInstanceState(estado: Bundle) {
        super.onRestoreInstanceState(estado)
        contador = estado.getInt(cuenta)
        invertido = estado.getBoolean(cuenta_invertida)
        aceptar_negativos = estado.getBoolean(cuenta_aceptar_negativos)
    }

    override fun onPause() {
        super.onPause()
        var datos: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var editor: SharedPreferences.Editor = datos.edit()
        if (t_contador.text.isNotEmpty()) {
            contador = try { t_contador.text.toString().toInt() } catch (e: Exception) { 0 }
        }
        editor.putInt(cuenta, contador)
        editor.putBoolean(cuenta_invertida, invertido)
        editor.putBoolean(cuenta_aceptar_negativos, aceptar_negativos)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()
        var datos: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        contador = datos.getInt(cuenta, 0)
        invertido = datos.getBoolean(cuenta_invertida, false)
        aceptar_negativos = datos.getBoolean(cuenta_aceptar_negativos, false)
        actualizar_contador()
        efectos_invertir_contador()
        efectos_aceptar_negativos()
    }

}
