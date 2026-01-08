package com.kuvuni.compose1.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un composable para mostrar títulos con un estilo consistente.
 *
 * @param text El texto que se mostrará.
 * @param modifier El modificador que se aplicará al texto.
 */
@Composable
fun MyTitleText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 24.sp
    )
}

@Preview(showBackground = true, name = "MyTitleText Preview")
@Composable
fun MyTitleTextPreview() {
    Compose1Theme {
        MyTitleText(text = "Este es un Título")
    }
}
