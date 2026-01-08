package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * # Layout: LazyColumn y LazyRow
 *
 * `LazyColumn` y `LazyRow` son los `Composables` equivalentes a `RecyclerView` en el
 * sistema de vistas tradicional. Están diseñados para mostrar listas de elementos de manera
 * eficiente, ya que solo "componen" y dibujan los elementos que son visibles en la pantalla.
 *
 * Son la elección correcta para listas largas o potencialmente infinitas.
 *
 * ## Cómo funcionan:
 * En lugar de añadir `Composables` hijos directamente, se utiliza un `LazyListScope`,
 * que proporciona funciones como `item` (para un solo elemento) o `items` (para una lista
 * de elementos).
 *
 * ## Parámetros principales:
 * - `modifier`: Para personalizar el layout (tamaño, padding, etc.).
 * - `contentPadding`: Añade padding alrededor de la lista completa (ej. al inicio y al final).
 * - `verticalArrangement` (para LazyColumn) o `horizontalArrangement` (para LazyRow):
 *   Define el espaciado entre los elementos.
 */
@Composable
fun LazyLayoutsExample() {
    // Creamos una lista de datos de ejemplo
    val items = (1..100).map { "Elemento #$it" }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp), // Padding para toda la lista
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espacio entre cada elemento
    ) {
        // Un solo item, como una cabecera
        item {
            Text("Cabecera de la Lista Vertical")
        }

        // Una fila horizontal dentro de la columna vertical
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                items(5) { index ->
                    Card(modifier = Modifier.padding(8.dp)) {
                        Text("Horizontal $index", modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }

        // Los items de nuestra lista de datos
        items(items) { item ->
            // Cada 'item' será un Composable que se renderizará en la lista
            Card(modifier = Modifier.fillParentMaxWidth()) {
                Text(item, modifier = Modifier.padding(16.dp))
            }
        }
    }
}

@Preview(showBackground = true, name = "Lazy Layouts Preview")
@Composable
fun LazyLayoutsPreview() {
    Compose1Theme {
        LazyLayoutsExample()
    }
}
