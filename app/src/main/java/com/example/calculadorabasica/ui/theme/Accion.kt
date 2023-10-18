package com.example.calculadorabasica.ui.theme

sealed class Accion {
    data class Numero(val numero: Int): Accion()
    object BorrarTodo: Accion()
    object Borrar: Accion()
    data class Operacion(val operacion: com.example.calculadorabasica.ui.theme.Operacion): Accion()
    object Calcular: Accion()
    object Decimal: Accion()
}
