package com.kuvuni.compose1.ui.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Una barra de aplicaciones superior que se puede reutilizar en diferentes pantallas.
 *
 * La anotación `@OptIn(ExperimentalMaterial3Api::class)` indica que esta función
 * utiliza una API de Material 3 que se considera experimental. Esto significa que la
 * API podría cambiar en futuras versiones de la biblioteca. Al usar esta anotación,
 * confirmamos que estamos al tanto de esto.
 *
 * @param title El título que se mostrará en la barra de aplicaciones superior.
 * @param modifier El modificador que se aplicará a la barra de aplicaciones superior.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String, modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(title) },
        modifier = modifier
    )
}

@Preview(showBackground = true, name = "MyTopAppBar Preview")
@Composable
fun MyTopAppBarPreview() {
    Compose1Theme {
        MyTopAppBar(title = "Mi Título")
    }
}
