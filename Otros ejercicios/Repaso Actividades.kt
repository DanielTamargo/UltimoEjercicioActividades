fun abrirVentanaSecundaria(){
    val intento = Intent(this,VentanaSecundaria::class.java)
    intento.putExtra("nombre","Dani")
    startActivity(intento)
}

//Coger datos en la VentanaSecundaria:
nombre = try { intent?.getStringExtra("nombre").toString() } catch (e:Exception) { "Error" }


fun abrirVentanaDatos(){
    val intent = Intent(this,VentanaDatos::class.java )
    startActivityForResult(intent, 1)
}


override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    when (requestCode) {
        1 -> {
            nombre = try { data?.getStringExtra("nombre").toString() } catch (e:Exception) { "Error" }
        }
    }
}