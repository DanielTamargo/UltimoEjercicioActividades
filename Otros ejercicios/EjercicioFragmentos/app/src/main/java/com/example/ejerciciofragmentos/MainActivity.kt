package com.example.ejerciciofragmentos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_menu.*

class MainActivity : AppCompatActivity() {

    companion object {
        val NUMERO_IMAGEN = "num_imagen"
    }

    var num_imagen = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgBtn_1.setOnClickListener {
            num_imagen = 1
            ventanaSecundaria()
        }
        imgBtn_2.setOnClickListener {
            num_imagen = 2
            ventanaSecundaria()
        }
        imgBtn_3.setOnClickListener {
            num_imagen = 3
            ventanaSecundaria()
        }
    }

    fun ventanaSecundaria() {
        val intent = Intent(this, VentanaSecundaria::class.java)
        intent.putExtra(NUMERO_IMAGEN, num_imagen)

        textView.setText("¡Puedes volver a seleccionar!")

        startActivity(intent)
    }
}
