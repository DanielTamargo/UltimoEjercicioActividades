import java.lang.Exception
import kotlin.random.Random

fun main() {
    //ejercicio5()

    //ejercicio6()

    //ejercicio7()

    ejercicio8()

    ejercicio9()
}

fun ejercicio9() {
    println("Ejercicio 9\n")
    var correcto: Boolean = false
    var filas: Int
    do {
        println("\u001B[35mFilas\u001B[0m")
        filas = pedir_numero()
        if (filas < 1 || filas > 100) {
            if (filas > 100) {
                println("Tampoco te pases... Introduce un número más pequeño.")
            } else {
                println("Error. Introduce un número positivo.\n")
            }
        } else {
            correcto = true
        }
    } while (!correcto)
    println()

    correcto = false
    var columnas: Int
    do {
        println("\u001B[35mColumnas\u001B[0m")
        columnas = pedir_numero()
        if (columnas < 1 || columnas > 100) {
            if (columnas > 100) {
                println("\u001B[31mTampoco te pases... Introduce un número más pequeño.\u001B[0m")
            } else {
                println("\u001B[31mError. Introduce un número positivo.\u001B[0m\n")
            }
        } else {
            correcto = true
        }
    } while (!correcto)
    println()

    var matriz: Array<Array<Int>> = Array<Array<Int>>(filas){
        Array<Int>(columnas){Random.nextInt(0, 50)}
    }

    //Visualizamos la matriz
    visualizar_matriz(matriz)

    //Creamos un array con los mismos valores que la matriz
    val dimensionArray: Int = filas * columnas
    var array: Array<Int> = Array<Int>(dimensionArray){0}

    //Copiamos los datos
    var x: Int = 0
    for (i in 0 until matriz.size) {
        for (j in 0 until matriz[i].size) {
            array[x] = matriz[i][j]
            x++
        }
    }

    //Visualizamos el array
    println("\u001B[36mArray generado con la matriz:\u001B[0m")
    visualizar(array)

    //Borramos los repetidos y lo visualizamos de nuevo, para borrarlo lo convertimos a coleccion y otra vez a array
    println("\u001B[36mArray generado con el array anterior, pero eliminando los repetidos:\u001B[0m")
    var arraySinRepetidos: Array<Int> = array.toSet().toTypedArray()

    visualizar(arraySinRepetidos)

}

fun visualizar_matriz(matriz: Array<Array<Int>>) {
    println("\u001B[36mVisualización de la matriz:\u001B[0m")
    for (i in 0 until matriz.size) {
        for (j in 0 until matriz[i].size) {
            val formatted = String.format("%3d", matriz[i][j])
            if (j == 0) {
                print(formatted)
            } else {
                print(", ${formatted}")
            }
        }
        println()
    }
    println()
}

fun ejercicio8() {
    println("\u001B[33mEjercicio 8\u001B[0m\n")
    var array: Array<Int> = Array<Int>(10){Random.nextInt(0, 50)}

    visualizar(array)
    buscarMayor(array)
    buscarMenor(array)
    val n: Int = pedir_numero()

    if (existe(array, n)) {
        println("El número ${n} \u001B[32msí\u001B[0m existe en el array.")
    } else {
        println("El número ${n} \u001B[31mno\u001B[0m existe en el array.")
    }
    println()

}

fun existe(array: Array<Int>, n: Int): Boolean {
    return n in array
}

fun buscarMenor(array: Array<Int>) {
    var menorNum:Int = array[0]
    for (num in array) {
        if (menorNum > num) {
            menorNum = num
        }
    }
    println("\u001B[36mEl número más pequeño del array es:\u001B[0m ${menorNum}")
}

fun buscarMayor(array: Array<Int>) {
    var mayorNum:Int = array[0]
    for (num in array) {
        if (mayorNum < num) {
            mayorNum = num
        }
    }
    println("\u001B[36mEl número más grande del array es:\u001B[0m ${mayorNum}")
}

fun visualizar(array: Array<Int>) {
    println("\u001B[36mLista de números en el array:\u001B[0m")
    for (i in 0 until array.size) {
        if (i == 0){
            print("${array[i]}")
        } else {
            print(", ${array[i]}")
        }
    }
    println("\n")
}

fun ejercicio7() {
    print("Ejercicio 7\n")
    var numero: Int = pedir_numero()
    var esPrimo: Boolean = true

    println("Lista de números primos: ")
    print("1")
    for (i in 2..numero) {
        esPrimo = true
        for (j in 2 until i) {
            if (i % j == 0) {
                esPrimo = false
            }
        }
        if (esPrimo) {
            print(", ${i}")
        }
    }
    println() //salto de línea al final de la lista

}

fun ejercicio6() {
    print("Ejercicio 6\n")
    var correcto: Boolean = false
    var numero: Int
    println("Introduce un número del 1 al 7 para mostrar el día de la semana al que hace referencia:")
    do {
        numero = pedir_numero()
        if (numero < 1 || numero > 7) {
            println("Error. Introduce un número del 1 al 7.\n")
        } else {
            correcto = true
        }
    } while (!correcto)

    when (numero) {
        1 -> println("Lunes.")
        2 -> println("Martes.")
        3 -> println("Miércoles.")
        4 -> println("Jueves.")
        5 -> println("Viernes.")
        6 -> println("Sábado.")
        7 -> println("Domingo.")
    }

}

fun ejercicio5() {
    println("Ejercicio 5\n")
    var a: Int = pedir_numero()
    var b: Int = pedir_numero()
    var c: Int = pedir_numero()

    println("Números introducidos:")
    println("${a} - ${b} - ${c}\n")

    var mayor: Int
    var medio: Int
    var menor: Int

    // Los reordenamos
    if (a > b) {
        if (a > c) {
            mayor = a
            if (c > b) {
                medio = c
                menor = b
            } else {
                medio = b
                menor = c
            }
        } else if (a == c) {
            mayor = a
            medio = a
            menor = b
        } else {
            mayor = c
            medio = a
            menor = b
        }
    } else if (a == b) {
        if (a > c) {
            mayor = a
            medio = a
            menor = c
        } else if (a == c) {
            mayor = a
            medio = a
            menor = a
        } else {
            mayor = c
            medio = a
            menor = a
        }
    } else { //if (a < b)
        if (b > c) {
            mayor = b
            if (a > c) {
                medio = a
                menor = c
            } else if (a == c) {
                medio = a
                menor = a
            } else {
                medio = c
                menor = a
            }
        } else if (b == c) {
            mayor = b
            medio = b
            menor = a
        } else {
            mayor = c
            medio = b
            menor = a
        }
    }

    println("Números ordenados de mayor a menor:")
    println("${mayor} - ${medio} - ${menor}")

    if (mayor == medio) {
        if (mayor == menor) {
            println("Todos los números son iguales.")
        } else {
            println("Los dos números más grandes son iguales.")
        }
    } else if (medio == menor) {
        println("Los dos números más pequeños son iguales.")
    }

}


fun pedir_numero(): Int{
    var correcto: Boolean = false
    var numero: Int = 0

    do {
        print("Introduce un número: ")
        var valor: String = readLine().toString()
        try {
            numero = valor.toInt()
            correcto = true
        } catch (e: Exception) {
            println("\u001B[31mNo has introducido un número entero.\u001B[0m\n")
        }
    } while (!correcto)
    return numero
}