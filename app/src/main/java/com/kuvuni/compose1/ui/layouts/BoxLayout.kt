package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * # Layout: Box
 *
 * `Box` es un `Composable` que apila sus elementos hijos uno encima del otro.
 * Es el equivalente a un `FrameLayout` en el sistema de vistas tradicional.
 * El `Box` es ideal para colocar elementos flotando sobre otros o para alinear un
 * solo elemento en una posición específica de su contenedor padre.
 *
 * ## Parámetros principales:
 * - `modifier`: Para personalizar el `Box` (tamaño, padding, color de fondo, etc.).
 * - `contentAlignment`: Define la alineación por defecto de los hijos dentro del `Box`.
 *     - `Alignment.TopStart`: Arriba a la izquierda (por defecto).
 *     - `Alignment.TopCenter`: Arriba al centro.
 *     - `Alignment.TopEnd`: Arriba a la derecha.
 *     - `Alignment.CenterStart`: Centro a la izquierda.
 *     - `Alignment.Center`: Totalmente centrado.
 *     - `Alignment.CenterEnd`: Centro a la derecha.
 *     - `Alignment.BottomStart`: Abajo a la izquierda.
 *     - `Alignment.BottomCenter`: Abajo al centro.
 *     - `Alignment.BottomEnd`: Abajo a la derecha.
 *
 * También puedes usar el `Modifier.align()` en un hijo específico para sobreescribir
 * la alineación por defecto del `Box`.
 */
@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        contentAlignment = Alignment.Center // Centra todos los hijos por defecto
    ) {
        // Este Box será más grande y estará en el centro (por defecto)
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Blue)
        )

        // Este Text se alineará en la esquina inferior derecha del Box padre, 
        // sobreescribiendo la alineación central.
        Text(
            text = "Sobrepuesto",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .background(Color.Yellow)
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true, name = "Box Layout Preview")
@Composable
fun BoxLayoutPreview() {
    Compose1Theme {
        BoxExample()
    }
}
