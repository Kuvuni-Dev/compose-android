package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.components.MyBodyText
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * # Layout: LazyVerticalGrid
 *
 * `LazyVerticalGrid` es un `Composable` que muestra elementos en una cuadrícula de desplazamiento vertical.
 * Al igual que `LazyColumn`, es "lazy", lo que significa que solo compone y dibuja los elementos
 * que son visibles en la pantalla, haciéndolo muy eficiente para grandes conjuntos de datos.
 *
 * ## Parámetros principales:
 * - `columns`: Define la configuración de las columnas. Hay dos formas principales:
 *     - `GridCells.Fixed(count)`: Crea un número fijo de columnas (ej. 2 o 3).
 *     - `GridCells.Adaptive(minSize)`: Crea tantas columnas como quepan, asegurando que cada una tenga al menos un tamaño mínimo (`minSize`). Es ideal para diseños responsivos.
 * - `modifier`: Para personalizar el `LazyVerticalGrid`.
 * - `contentPadding`: Añade padding alrededor de toda la cuadrícula.
 * - `verticalArrangement`: Espaciado vertical entre las filas.
 * - `horizontalArrangement`: Espaciado horizontal entre las columnas.
 */
@Composable
fun LazyGridExample() {
    val items = (1..50).toList()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 100.dp), // Crea columnas de al menos 100.dp de ancho
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier.aspectRatio(1f) // Hace que la tarjeta sea cuadrada
            ) {
                MyBodyText(text = "Item #$item", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Preview(showBackground = true, name = "LazyGrid Preview")
@Composable
fun LazyGridPreview() {
    Compose1Theme {
        LazyGridExample()
    }
}
