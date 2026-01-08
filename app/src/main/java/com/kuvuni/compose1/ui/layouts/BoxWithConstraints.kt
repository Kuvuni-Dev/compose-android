package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * # Layout: BoxWithConstraints
 *
 * `BoxWithConstraints` es un `Composable` similar a un `Box`, pero con una capacidad clave:
 * te permite conocer las restricciones de tamaño (ancho y alto) que el padre le impone.
 * Esto te permite crear interfaces de usuario **responsivas** que se adaptan al espacio disponible.
 *
 * Dentro del lambda de `BoxWithConstraints`, tienes acceso a `maxWidth` y `maxHeight`.
 *
 * ## Cuándo usarlo:
 * - Cuando necesitas cambiar el layout si el dispositivo rota (de vertical a horizontal).
 * - Para mostrar más o menos información dependiendo del ancho disponible.
 * - Para crear componentes que se autoajustan de manera inteligente.
 */
@Composable
fun BoxWithConstraintsExample() {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        // Comprobamos el ancho máximo disponible
        if (maxWidth < 400.dp) {
            // Si el espacio es estrecho, mostramos un layout vertical
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Layout Vertical (estrecho)")
                Icon(Icons.Default.Home, contentDescription = "Home")
                Text("Inicio")
            }
        } else {
            // Si el espacio es ancho, mostramos un layout horizontal
            Row(modifier = Modifier.padding(16.dp)) {
                Text("Layout Horizontal (ancho)")
                Icon(Icons.Default.AccountCircle, contentDescription = "Profile")
                Text("Mi Perfil Completo")
            }
        }
    }
}

@Preview(showBackground = true, name = "BoxWithConstraints (Estrecho)", widthDp = 300)
@Preview(showBackground = true, name = "BoxWithConstraints (Ancho)", widthDp = 500)
@Composable
fun BoxWithConstraintsPreview() {
    Compose1Theme {
        BoxWithConstraintsExample()
    }
}
