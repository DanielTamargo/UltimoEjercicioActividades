package com.tamargo

import kotlin.random.Random

fun main() {
    apuntes()
}

fun apuntes() {
    val array = intArrayOf (4, 1, 10, 6) //no admite nulls


    for (i in 1..5) print(i) //ambos inclusive
    for (i in 1 until 5) print(i) //el 5 no entra
    for (i in 5.downTo(1)) print(i) //ambos inclusive
    for (i in 1.rangeTo(5)) print(i) //ambos iclusive
    for (i in 0..8 step(2)) print(i) //ambos inclusive, de 2 en 2

    //Operadores: + - * / %
    //Comparadores: < > <= <= == !=   && ||   !

    //Conversiones: toInt(), toDouble(), toString()   as Int  as String

    //do { ... } while(x < 10) // while(x < 10) { ... }
    // when (opcion) { 1 -> {...} 2 -> ... }
    for ((posicion, valor) in array.withIndex()) { println("Index: $posicion, Value: $valor") }

    val meses: MutableList<String> = mutableListOf()
    meses.add("Enero")
    meses.add("")
    meses[1] = ("Febrero")
    if (meses.contains("Marzo")) meses.remove("Marzo") else println("Marzo no existía en la lista")
    meses.forEach { println(it) }

    val array1 = intArrayOf (4, 1, 10, 6) //no admite nulls
    array1[3] = 7
    array1.sort()

    val array2 = arrayOf (1, 54, 4234, 63454, null) //admite nulls
    val array3 = arrayOf ("String", "Hola") //sonsaca el tipo de variable en común

    val matriz4 = arrayOf (arrayOf(1,2,3), arrayOf("Lunes", "Martes", "Miercoles"))
    var num = 20
    val matriz3 = Array(10){ Array(2) {num--} }
    val matriz2 = arrayOf (intArrayOf(1,2,3), intArrayOf(4,5,6))

    val matriz1 = Array(4) { Array(3){ Random.nextInt(1, 10)} }
    for (i in 0 until matriz1.count()) {
        for (j in 0 until matriz1[0].count()) {
            print("${matriz1[i][j]} ")
        }
        println()
    }

    // Varios
    print(String.format("%05d", matriz1[0][0]))
    var arraySinRepetidos: Array<Int> = array.toSet().toTypedArray()
}

fun pedir_numero(): Int{
    var correcto: Boolean = false
    var numero: Int = 0

    do {
        print("Introduce un número: ")
        val valor: String = readLine().toString()
        try {
            numero = valor.toInt()
            correcto = true
        } catch (e: Exception) {
            println("\u001B[31mNo has introducido un número entero.\u001B[0m\n")
        }
    } while (!correcto)
    return numero
}

class Alumno(nombre:String, apellidos:String, edad:Int, dni:String) {
    var nombre: String = ""
    var apellidos: String = ""
    var edad: Int = 0
    var dni: String = ""
    var notas: MutableMap<Asignatura, Int> = mutableMapOf()

    init { //Constructor normal, con todos los datos, podría abreviarse (ejemplo: var nombre: String = nombre)
        this.nombre = nombre
        this.apellidos = apellidos
        this.edad = edad
        this.dni = dni
    }

    constructor(nombre:String, apellidos:String, dni:String): this(nombre, apellidos, Random.nextInt(18, 30), dni)

    fun addNota(asignatura: Asignatura, nota:Int) {
        notas[asignatura] = nota
    }

    override fun toString(): String {
        return "Alumno(nombre='$nombre', apellidos='$apellidos', edad=$edad, dni='$dni')"
    }
}

class Asignatura (tipo: TipoAsignatura, horas: Int) {
    var tipo: TipoAsignatura = tipo
    var horas: Int = horas
    var profesor: String = "Profesor por definir"
}

enum class TipoAsignatura {
    MATEMATICAS, FISICA, QUIMICA, LENGUAJE, BIOLOGIA, DIBUJO
}

open class Figura {
    open fun calcular_volumen(): Double {
        return 0.0
    }
}

class Cono(radio: Double, altura: Double): Figura() {
    var altura: Double = altura
    var radio: Double = radio
    override fun calcular_volumen(): Double {
        return altura * Math.PI * Math.pow(radio, 2.0) / 3
    }
}

