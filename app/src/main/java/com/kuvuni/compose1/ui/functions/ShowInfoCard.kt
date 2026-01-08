package com.kuvuni.compose1.ui.functions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.components.MyBodyText
import com.kuvuni.compose1.ui.components.MyCard
import com.kuvuni.compose1.ui.components.MyTitleText
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Muestra una tarjeta de información con un título y un cuerpo.
 *
 * @param title El título a mostrar en la tarjeta.
 * @param body El texto del cuerpo a mostrar en la tarjeta.
 * @param modifier El modificador a aplicar a la tarjeta.
 */
@Composable
fun ShowInfoCard(title: String, body: String, modifier: Modifier = Modifier) {
    MyCard(modifier = modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            MyTitleText(text = title)
            Spacer(modifier = Modifier.height(8.dp))
            MyBodyText(text = body)
        }
    }
}

@Preview(showBackground = true, name = "ShowInfoCard Preview")
@Composable
fun ShowInfoCardPreview() {
    Compose1Theme {
        ShowInfoCard(
            title = "Tarjeta de Información",
            body = "Este es un ejemplo de cómo se vería la tarjeta de información."
        )
    }
}
