package com.kuvuni.compose1.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
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
 * Una casilla de verificación (Checkbox) con una etiqueta de texto.
 *
 * @param checked El estado actual de la casilla.
 * @param onCheckedChange La devolución de llamada que se invoca cuando el estado cambia.
 * @param text La etiqueta de texto que se mostrará junto a la casilla.
 * @param modifier El modificador que se aplicará al contenedor del Row.
 */
@Composable
fun MyCheckbox(checked: Boolean, onCheckedChange: (Boolean) -> Unit, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checked, onCheckedChange = onCheckedChange)
        Text(text = text, modifier = Modifier.padding(start = 8.dp))
    }
}

@Preview(showBackground = true, name = "MyCheckbox Preview")
@Composable
fun MyCheckboxPreview() {
    var isChecked by remember { mutableStateOf(true) }
    Compose1Theme {
        MyCheckbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            text = "Acepto los términos"
        )
    }
}
