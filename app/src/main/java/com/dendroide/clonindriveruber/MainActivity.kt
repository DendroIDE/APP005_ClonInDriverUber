package com.dendroide.clonindriveruber

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dendroide.clonindriveruber.presentation.screens.auth.login.LoginScreen
import com.dendroide.clonindriveruber.ui.theme.ClonInDriverUberTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClonInDriverUberTheme {
                LoginScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ClonInDriverUberTheme {
        Greeting("DendroIDE Code")
    }
}

@Composable
fun PercentageDonutChart(
    percentage: Float,
    size: Float = 200f,
    backgroundColor: Color = Color.LightGray
) {
    // Asegúrate de que el porcentaje esté entre 0 y 100
    val safePercentage = percentage.coerceIn(0f, 100f)

    // Selección de color basada en el porcentaje
    val foregroundColor = when {
        safePercentage <= 33 -> Color.Red
        safePercentage <= 66 -> Color.Yellow
        else -> Color.Green
    }
    // Usamos un Box para apilar el Canvas y el Text
    Box(
        contentAlignment = Alignment.Center, // Centrar el contenido
        modifier = Modifier
            .size(size.dp)
            .padding(16.dp)
    ) {
    Canvas(
        modifier = Modifier
            .size(size.dp)
    ) {
        // Dibujar el fondo del gráfico (círculo completo)
        drawArc(
            color = backgroundColor,
            startAngle = 0f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(width = 50f)
        )

        // Dibujar la parte del porcentaje (sección del círculo)
        drawArc(
            color = foregroundColor,
            startAngle = 270f, // Empezar desde la parte superior
            sweepAngle = (safePercentage / 100) * 360, // Calcular el ángulo según el porcentaje
            useCenter = false,
            style = Stroke(width = 25f)
        )
    }
        // Mostrar el porcentaje en el centro
        Text(
            text = "${safePercentage.toInt()}%", // Mostrar el valor como un entero con el símbolo %
            fontSize = 50.sp, // Tamaño de fuente
            fontWeight = FontWeight.Bold, // Texto en negrita
            color = Color.Black // Color del texto
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewPercentageDonutChart() {
    PercentageDonutChart(percentage = 100f)
}