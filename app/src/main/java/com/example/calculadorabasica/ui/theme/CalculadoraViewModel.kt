package com.example.calculadorabasica.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculadoraViewModel: ViewModel() {

    var estado by mutableStateOf(Estado())

    fun onAction(accion: Accion) {
        when(accion) {
            is Accion.Numero -> introEntero(accion.numero)
            is Accion.Borrar -> borrar()
            is Accion.BorrarTodo -> estado = Estado()
            is Accion.Operacion -> hacerOperacion(accion.operacion)
            is Accion.Decimal -> introDecimal()
            is Accion.Calcular -> calcular()
        }
    }

    private fun hacerOperacion(operacion: Operacion) {
        if(estado.num1.isNotBlank()) {
            estado = estado.copy(operacion = operacion)
        }
    }

    private fun calcular() {
        val num1 = estado.num1.toDoubleOrNull()
        val num2 = estado.num2.toDoubleOrNull()
        if(num1 != null && num2 != null) {
            val resultado = when(estado.operacion) {
                is Operacion.Sumar -> num1 + num2
                is Operacion.Restar -> num1 - num2
                is Operacion.Multiplicar -> num1 * num2
                is Operacion.Dividir -> num1 / num2
                null -> return
            }
            estado = estado.copy(
                num1 = resultado.toString().take(15),
                num2 = "",
                operacion = null
            )
        }
    }

    private fun borrar() {
        when {
            estado.num2.isNotBlank() -> estado = estado.copy(
                num2 = estado.num2.dropLast(1)
            )
            estado.operacion != null -> estado = estado.copy(
                operacion = null
            )
            estado.num1.isNotBlank() -> estado = estado.copy(
                num1 = estado.num1.dropLast(1)
            )
        }
    }

    private fun introDecimal() {
        if(estado.operacion == null && !estado.num1.contains(".") && estado.num1.isNotBlank()) {
            estado = estado.copy(
                num1 = estado.num1 + "."
            )
            return
        } else if(!estado.num2.contains(".") && estado.num2.isNotBlank()) {
            estado = estado.copy(
                num2 = estado.num2 + "."
            )
        }
    }

    private fun introEntero(entero: Int) {
        if(estado.operacion == null) {
            if(estado.num1.length >= MAX_NUM_LENGTH) {
                return
            }
            estado = estado.copy(
                num1 = estado.num1 + entero
            )
            return
        }
        if(estado.num2.length >= MAX_NUM_LENGTH) {
            return
        }
        estado = estado.copy(
            num2 = estado.num2 + entero
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }
}