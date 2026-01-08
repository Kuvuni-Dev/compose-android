package com.kuvuni.compose1.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un Card personalizable para contener otros composables.
 *
 * @param modifier El modificador que se aplicará a la tarjeta.
 * @param content El contenido que se mostrará dentro de la tarjeta.
 */
@Composable
fun MyCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(modifier = modifier) {
        content()
    }
}

@Preview(showBackground = true, name = "MyCard Preview")
@Composable
fun MyCardPreview() {
    Compose1Theme {
        MyCard(modifier = Modifier.padding(16.dp)) {
            Column(modifier = Modifier.padding(16.dp)) {
                MyTitleText(text = "Título en Tarjeta")
                MyBodyText(text = "Contenido dentro de la tarjeta.")
            }
        }
    }
}
