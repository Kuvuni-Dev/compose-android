package com.kuvuni.compose1.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un indicador de progreso circular.
 *
 * @param modifier El modificador que se aplicará al indicador de progreso.
 */
@Composable
fun MyCircularProgressIndicator(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)
}

@Preview(showBackground = true, name = "MyCircularProgressIndicator Preview")
@Composable
fun MyCircularProgressIndicatorPreview() {
    Compose1Theme {
        MyCircularProgressIndicator()
    }
}
