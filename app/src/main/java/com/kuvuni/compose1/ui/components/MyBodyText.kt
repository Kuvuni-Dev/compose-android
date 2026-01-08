package com.kuvuni.compose1.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un composable para mostrar texto de cuerpo con un estilo consistente.
 *
 * @param text El texto que se mostrará.
 * @param modifier El modificador que se aplicará al texto.
 */
@Composable
fun MyBodyText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true, name = "MyBodyText Preview")
@Composable
fun MyBodyTextPreview() {
    Compose1Theme {
        MyBodyText(text = "Este es un texto de cuerpo de prueba.")
    }
}
