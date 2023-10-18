package com.example.calculadorabasica.ui.theme

sealed class Operacion(val simbolo: String) {
    object Sumar: Operacion("+")
    object Restar: Operacion("-")
    object Multiplicar: Operacion("x")
    object Dividir: Operacion("/")
}