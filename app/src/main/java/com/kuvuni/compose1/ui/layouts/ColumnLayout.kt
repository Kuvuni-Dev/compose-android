package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * # Layout: Column
 *
 * `Column` es un `Composable` que organiza sus elementos hijos en una secuencia vertical.
 * Es el equivalente a un `LinearLayout` con orientación vertical en el sistema de vistas tradicional.
 *
 * ## Parámetros principales:
 * - `modifier`: Para personalizar el `Column` (tamaño, padding, etc.).
 * - `verticalArrangement`: Define cómo se distribuyen los hijos a lo largo del eje vertical (el espacio entre ellos).
 *     - `Arrangement.Top`: Los apila en la parte superior (por defecto).
 *     - `Arrangement.Center`: Los centra verticalmente.
 *     - `Arrangement.Bottom`: Los apila en la parte inferior.
 *     - `Arrangement.SpaceBetween`: Distribuye el espacio vacío entre los hijos.
 *     - `Arrangement.SpaceAround`: Coloca espacio vacío antes del primer hijo y después del último, y distribuye el resto equitativamente entre los hijos.
 *     - `Arrangement.SpaceEvenly`: Distribuye el espacio vacío de manera uniforme entre todos los hijos, incluyendo antes del primero y después del último.
 * - `horizontalAlignment`: Define cómo se alinean los hijos a lo largo del eje horizontal.
 *     - `Alignment.Start`: Los alinea a la izquierda.
 *     - `Alignment.CenterHorizontally`: Los centra horizontalmente.
 *     - `Alignment.End`: Los alinea a la derecha.
 */
@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly, // Distribuye el espacio verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente
    ) {
        Text("Elemento 1")
        Text("Elemento 2")
        Text("Elemento 3")
    }
}

@Preview(showBackground = true, name = "Column Layout Preview")
@Composable
fun ColumnLayoutPreview() {
    Compose1Theme {
        ColumnExample()
    }
}
