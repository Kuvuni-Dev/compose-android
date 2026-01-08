package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * # Layout: Scaffold
 *
 * `Scaffold` es un `Composable` que implementa la estructura visual básica de Material Design.
 * Proporciona "ranuras" (slots) para los componentes más comunes de una pantalla, como la
 * barra de aplicaciones superior, el botón de acción flotante, etc.
 *
 * Usar `Scaffold` simplifica enormemente la organización de la pantalla, ya que se encarga
 * del posicionamiento correcto de estos elementos.
 *
 * ## Parámetros principales (slots):
 * - `topBar`: Para colocar una barra de aplicaciones superior (ej. `TopAppBar`).
 * - `bottomBar`: Para colocar una barra de navegación inferior.
 * - `floatingActionButton`: Para el botón de acción flotante (FAB).
 * - `floatingActionButtonPosition`: Para definir la posición del FAB.
 * - `content`: El área principal de la pantalla donde va tu contenido. El `Scaffold` proporciona
 *   un `PaddingValues` a este slot para que tu contenido no se solape con las barras superior o inferior.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Mi App con Scaffold") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Acción del botón */ }) {
                Icon(Icons.Filled.Add, contentDescription = "Añadir")
            }
        }
    ) { innerPadding ->
        // El contenido principal de nuestra pantalla
        Box(
            modifier = Modifier
                .fillMaxSize()
                // Es importante aplicar el padding que nos da el Scaffold
                // para que el contenido no quede debajo de la TopAppBar.
                .padding(innerPadding)
        ) {
            Text("Este es el contenido principal de la pantalla.")
        }
    }
}

@Preview(showBackground = true, name = "Scaffold Layout Preview")
@Composable
fun ScaffoldLayoutPreview() {
    Compose1Theme {
        ScaffoldExample()
    }
}
