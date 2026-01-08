package com.kuvuni.compose1.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un composable para mostrar una imagen desde un recurso drawable.
 *
 * @param imageRes El ID del recurso drawable de la imagen.
 * @param contentDescription La descripción del contenido para accesibilidad.
 * @param modifier El modificador que se aplicará a la imagen.
 */
@Composable
fun MyImage(@DrawableRes imageRes: Int, contentDescription: String?, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = contentDescription,
        modifier = modifier
    )
}

@Preview(showBackground = true, name = "MyImage Preview")
@Composable
fun MyImagePreview() {
    Compose1Theme {
        // Nota: Para que la vista previa de MyImage funcione, necesitarás un recurso
        // drawable real en tu proyecto (ej. en res/drawable). 
        // Aquí usamos un icono de sistema como marcador de posición.
        Image(
            imageVector = Icons.Filled.Build, 
            contentDescription = "Placeholder Image",
            modifier = Modifier.size(100.dp).padding(16.dp)
        )
    }
}
