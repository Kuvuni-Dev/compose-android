package com.kuvuni.compose1.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un control deslizante (Slider) para seleccionar un valor dentro de un rango.
 *
 * @param value El valor actual del control deslizante.
 * @param onValueChange La devolución de llamada que se invoca cuando el valor cambia.
 * @param modifier El modificador que se aplicará al control deslizante.
 * @param valueRange El rango de valores que puede tener el control deslizante.
 * @param steps El número de pasos discretos en los que se puede dividir el rango.
 */
@Composable
fun MySlider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0
) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        valueRange = valueRange,
        steps = steps
    )
}

@Preview(showBackground = true, name = "MySlider Preview")
@Composable
fun MySliderPreview() {
    var sliderValue by remember { mutableFloatStateOf(0.5f) }
    Compose1Theme {
        Column {
            Text(text = "Valor: ${sliderValue}")
            MySlider(
                value = sliderValue,
                onValueChange = { sliderValue = it },
                valueRange = 0f..10f,
                steps = 9 // 9 escalones para 10 valores (0 a 10)
            )
        }
    }
}
