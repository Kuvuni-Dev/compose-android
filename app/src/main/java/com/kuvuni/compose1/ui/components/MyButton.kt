package com.kuvuni.compose1.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un botón personalizable con un estilo predeterminado.
 *
 * @param onClick La devolución de llamada que se invocará cuando se haga clic en el botón.
 * @param modifier El modificador que se aplicará al botón.
 * @param text El texto que se mostrará en el botón.
 */
@Composable
fun MyButton(onClick: () -> Unit, modifier: Modifier = Modifier, text: String) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}

@Preview(showBackground = true, name = "MyButton Preview")
@Composable
fun MyButtonPreview() {
    Compose1Theme {
        MyButton(onClick = {}, text = "Botón de Prueba")
    }
}
