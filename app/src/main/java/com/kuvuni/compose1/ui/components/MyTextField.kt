package com.kuvuni.compose1.ui.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un campo de texto con estilo para la entrada del usuario.
 *
 * @param value El texto de entrada que se mostrará en el campo de texto.
 * @param onValueChange La devolución de llamada que se activa cuando el servicio de entrada actualiza el texto.
 * @param modifier El modificador que se aplicará al campo de texto.
 * @param label La etiqueta que se mostrará dentro del campo de texto.
 * @param visualTransformation Transforma la representación visual del valor del campo de texto.
 */
@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(label) },
        visualTransformation = visualTransformation
    )
}

@Preview(showBackground = true, name = "MyTextField Preview")
@Composable
fun MyTextFieldPreview() {
    Compose1Theme {
        var text by remember { mutableStateOf("") }
        MyTextField(value = text, onValueChange = { text = it }, label = "Campo de texto")
    }
}
