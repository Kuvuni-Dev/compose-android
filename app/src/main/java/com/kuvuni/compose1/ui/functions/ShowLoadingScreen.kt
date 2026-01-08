package com.kuvuni.compose1.ui.functions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.components.MyBodyText
import com.kuvuni.compose1.ui.components.MyCircularProgressIndicator
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Muestra una pantalla de carga.
 *
 * @param modifier El modificador a aplicar a la pantalla de carga.
 */
@Composable
fun ShowLoadingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyCircularProgressIndicator()
        Spacer(modifier = Modifier.height(16.dp))
        MyBodyText(text = "Cargando...")
    }
}

@Preview(showBackground = true, name = "ShowLoadingScreen Preview")
@Composable
fun ShowLoadingScreenPreview() {
    Compose1Theme {
        ShowLoadingScreen()
    }
}
