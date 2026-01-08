package com.kuvuni.compose1.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * # Layout: ConstraintLayout
 *
 * `ConstraintLayout` permite posicionar `Composables` de forma relativa entre sí y con
 * respecto al contenedor padre. Es ideal para interfaces complejas y planas (sin anidar
 * layouts), lo que puede mejorar el rendimiento.
 *
 * ## Cómo funciona:
 * 1.  Dentro del `ConstraintLayout`, creas referencias para cada `Composable` usando `createRefs()`.
 * 2.  Asignas cada referencia a un `Composable` usando el `Modifier.constrainAs()`.
 * 3.  Dentro del lambda de `constrainAs`, defines las restricciones (constraints). Por ejemplo,
 *     puedes vincular el `top` de un elemento al `bottom` de otro.
 *
 * ## Dependencia necesaria:
 * Para usar `ConstraintLayout` en Compose, necesitas añadir la siguiente dependencia a tu
 * archivo `build.gradle.kts` (o `build.gradle`):
 * `implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")`
 */
@Composable
fun ConstraintLayoutExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        // 1. Crea las referencias para los elementos que vas a posicionar
        val (button, text) = createRefs()

        // 2. Asigna la referencia al Button y define sus restricciones
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.constrainAs(button) {
                // Centra el botón horizontalmente con respecto al padre
                start.linkTo(parent.start)
                end.linkTo(parent.end)

                // Centra el botón verticalmente con respecto al padre
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        ) {
            Text("Botón Centrado")
        }

        // 3. Asigna la referencia al Text y define sus restricciones
        Text(
            text = "Texto debajo del botón",
            modifier = Modifier.constrainAs(text) {
                // Vincula el top de este Text al bottom del Button, con un margen de 16.dp
                top.linkTo(button.bottom, margin = 16.dp)

                // Centra el Text horizontalmente con respecto al padre
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview(showBackground = true, name = "ConstraintLayout Preview")
@Composable
fun ConstraintLayoutPreview() {
    Compose1Theme {
        ConstraintLayoutExample()
    }
}
