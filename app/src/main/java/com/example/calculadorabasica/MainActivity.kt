package com.example.calculadorabasica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import com.example.calculadorabasica.ui.theme.Accion
import com.example.calculadorabasica.ui.theme.Aguamarina
import com.example.calculadorabasica.ui.theme.AzulPastel
import com.example.calculadorabasica.ui.theme.AzulPastelOsc
import com.example.calculadorabasica.ui.theme.CalculadoraBasicaTheme
import com.example.calculadorabasica.ui.theme.CalculadoraViewModel
import com.example.calculadorabasica.ui.theme.Operacion
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.viewmodel.compose.viewModel

@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraBasicaTheme {
                val viewModel = viewModel<CalculadoraViewModel>()
                val state = viewModel.estado
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                    ) {
                        Text(
                            text = state.num1 + (state.operacion?.simbolo ?: "") + state.num2,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            fontWeight = FontWeight.Light,
                            fontSize = 80.sp,
                            color = AzulPastelOsc,
                            maxLines = 2
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Boton(
                                texto = "AC",
                                color = AzulPastelOsc,
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f)
                            ) {
                                viewModel.onAction(Accion.BorrarTodo)
                            }
                            Boton(
                                texto = "Del",
                                color = AzulPastelOsc,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Borrar)
                            }
                            Boton(
                                texto = "/",
                                color = Aguamarina,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Operacion(Operacion.Dividir))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Boton(
                                texto = "7",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(7))
                            }
                            Boton(
                                texto = "8",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(8))
                            }
                            Boton(
                                texto = "9",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(9))
                            }
                            Boton(
                                texto = "x",
                                color = Aguamarina,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Operacion(Operacion.Multiplicar))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Boton(
                                texto = "4",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(4))
                            }
                            Boton(
                                texto = "5",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(5))
                            }
                            Boton(
                                texto = "6",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(6))
                            }
                            Boton(
                                texto = "-",
                                color = Aguamarina,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Operacion(Operacion.Restar))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Boton(
                                texto = "1",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(1))
                            }
                            Boton(
                                texto = "2",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(2))
                            }
                            Boton(
                                texto = "3",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Numero(3))
                            }
                            Boton(
                                texto = "+",
                                color = Aguamarina,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Operacion(Operacion.Sumar))
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                        ) {
                            Boton(
                                texto = "0",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(2f)
                                    .weight(2f)
                            ) {
                                viewModel.onAction(Accion.Numero(0))
                            }
                            Boton(
                                texto = ".",
                                color = AzulPastel,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Decimal)
                            }
                            Boton(
                                texto = "=",
                                color = Aguamarina,
                                modifier = Modifier
                                    .aspectRatio(1f)
                                    .weight(1f)
                            ) {
                                viewModel.onAction(Accion.Calcular)
                            }
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun Boton(
    texto: String,
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    textStyle: TextStyle = TextStyle(),
    onClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(androidx.compose.ui.graphics.RectangleShape)
            .background(color)
            .clickable {
                onClick()
            }
            .then(modifier)
    ) {
        Text(
            text = texto,
            style = textStyle,
            fontSize = 36.sp,
            color = Color.White
        )
    }
}