package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
 * # Layout: Row
 *
 * `Row` es un `Composable` que organiza sus elementos hijos en una secuencia horizontal.
 * Es el equivalente a un `LinearLayout` con orientación horizontal en el sistema de vistas tradicional.
 *
 * ## Parámetros principales:
 * - `modifier`: Para personalizar el `Row` (tamaño, padding, etc.).
 * - `horizontalArrangement`: Define cómo se distribuyen los hijos a lo largo del eje horizontal (el espacio entre ellos).
 *     - `Arrangement.Start`: Los apila a la izquierda (por defecto).
 *     - `Arrangement.Center`: Los centra horizontalmente.
 *     - `Arrangement.End`: Los apila a la derecha.
 *     - `Arrangement.SpaceBetween`: Distribuye el espacio vacío entre los hijos.
 *     - `Arrangement.SpaceAround`: Coloca espacio vacío antes del primer hijo y después del último, y distribuye el resto equitativamente entre los hijos.
 *     - `Arrangement.SpaceEvenly`: Distribuye el espacio vacío de manera uniforme entre todos los hijos, incluyendo antes del primero y después del último.
 * - `verticalAlignment`: Define cómo se alinean los hijos a lo largo del eje vertical.
 *     - `Alignment.Top`: Los alinea en la parte superior.
 *     - `Alignment.CenterVertically`: Los centra verticalmente.
 *     - `Alignment.Bottom`: Los alinea en la parte inferior.
 */
@Composable
fun RowExample() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly, // Distribuye el espacio horizontalmente
        verticalAlignment = Alignment.CenterVertically // Centra los elementos verticalmente
    ) {
        Text("Elemento 1")
        Text("Elemento 2")
        Text("Elemento 3")
    }
}

@Preview(showBackground = true, name = "Row Layout Preview")
@Composable
fun RowLayoutPreview() {
    Compose1Theme {
        RowExample()
    }
}
