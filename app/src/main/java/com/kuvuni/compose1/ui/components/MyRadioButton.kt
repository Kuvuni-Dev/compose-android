package com.kuvuni.compose1.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un botón de opción (RadioButton) con una etiqueta de texto.
 *
 * @param selected Si el botón está seleccionado.
 * @param onClick La devolución de llamada que se invoca cuando se hace clic en el botón.
 * @param text La etiqueta de texto que se mostrará junto al botón.
 * @param modifier El modificador que se aplicará al contenedor del Row.
 */
@Composable
fun MyRadioButton(selected: Boolean, onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Text(text = text, modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview(showBackground = true, name = "MyRadioButton Preview")
@Composable
fun MyRadioButtonPreview() {
    val options = listOf("Opción 1", "Opción 2", "Opción 3")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Compose1Theme {
        Column {
            options.forEach { text ->
                MyRadioButton(
                    selected = (text == selectedOption),
                    onClick = { selectedOption = text },
                    text = text
                )
            }
        }
    }
}
