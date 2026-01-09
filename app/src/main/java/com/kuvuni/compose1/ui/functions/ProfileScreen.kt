package com.kuvuni.compose1.ui.functions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.R
import com.kuvuni.compose1.ui.components.MyBodyText
import com.kuvuni.compose1.ui.components.MyDivider
import com.kuvuni.compose1.ui.components.MyListItem
import com.kuvuni.compose1.ui.components.MySwitch
import com.kuvuni.compose1.ui.components.MyTitleText
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Muestra una pantalla de perfil de usuario completa, utilizando los componentes reutilizables.
 */
@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    // Estado para el interruptor de notificaciones.
    var notificationsEnabled by remember { mutableStateOf(true) }

    // Usamos un LazyColumn para que la pantalla sea desplazable si el contenido crece.
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally // Centra el contenido horizontalmente.
    ) {
        // --- Sección de Cabecera del Perfil ---
        item {
            // Avatar del usuario.
            // 1. Añade tu imagen (ej. 'avatar.png') a la carpeta 'res/drawable'.
            // 2. Reemplaza 'R.drawable.avatar_placeholder' por el ID de tu imagen.
            Image(
                painter = painterResource(id = R.drawable.patito),
                contentDescription = "Avatar de Perfil",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape), // Recorta la imagen en forma de círculo.
                contentScale = ContentScale.Crop // Asegura que la imagen llene el círculo sin deformarse.
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Nombre del usuario.
            MyTitleText(text = "Julián | Kuvuni")
            Spacer(modifier = Modifier.height(8.dp))
            // Biografía o estado del usuario.
            MyBodyText(text = "Docente TIC")
            Spacer(modifier = Modifier.height(24.dp))
        }

        // --- Sección de Ajustes ---
        item {
            // Divisor para separar secciones.
            MyDivider(modifier = Modifier.padding(vertical = 16.dp))
        }

        // Opción de Notificaciones con un interruptor.
        item {
            MyListItem(
                headlineText = "Notificaciones",
                leadingContent = { Icon(Icons.Default.Notifications, contentDescription = "Notificaciones") },
                // Usamos el MySwitch en el contenido final.
                trailingContent = {
                    MySwitch(
                        checked = notificationsEnabled,
                        onCheckedChange = { notificationsEnabled = it },
                        text = "" // El texto no es necesario aquí, ya que el ListItem tiene la etiqueta.
                    )
                }
            )
        }
        // Opción de Privacidad.
        item {
            MyListItem(
                headlineText = "Ajustes de Privacidad",
                leadingContent = { Icon(Icons.Default.Lock, contentDescription = "Privacidad") },
                onClick = {}
            )
        }
        // Opción de Ayuda.
        item {
            MyListItem(
                headlineText = "Ayuda y Soporte",
                leadingContent = { Icon(Icons.Default.Info, contentDescription = "Ayuda") },
                onClick = {}
            )
        }

        item {
            MyDivider(modifier = Modifier.padding(vertical = 16.dp))
        }

        // Opción para Cerrar Sesión.
        item {
            MyListItem(
                headlineText = "Cerrar Sesión",
                leadingContent = { Icon(Icons.Default.ExitToApp, contentDescription = "Cerrar Sesión") },
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true, name = "ProfileScreen Preview")
@Composable
fun ProfileScreenPreview() {
    Compose1Theme {
        ProfileScreen()
    }
}
