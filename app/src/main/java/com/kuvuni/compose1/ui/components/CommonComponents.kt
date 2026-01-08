package com.kuvuni.compose1.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un botón personalizable con un estilo predeterminado.
 *
 * @param onClick La devolución de llamada que se invocará cuando se haga clic en el botón.
 * @param modifier El modificador que se aplicará al botón.
 * @param text El texto que se mostrará en el botón.
 */
@Composable
fun MyButton(onClick: () -> Unit, modifier: Modifier = Modifier, text: String) {
    Button(onClick = onClick, modifier = modifier) {
        Text(text)
    }
}

/**
 * Un campo de texto con estilo para la entrada del usuario.
 *
 * @param value El texto de entrada que se mostrará en el campo de texto.
 * @param onValueChange La devolución de llamada que se activa cuando el servicio de entrada actualiza el texto.
 * @param modifier El modificador que se aplicará al campo de texto.
 * @param label La etiqueta que se mostrará dentro del campo de texto.
 */
@Composable
fun MyTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = { Text(label) }
    )
}

/**
 * Una barra de aplicaciones superior que se puede reutilizar en diferentes pantallas.
 *
 * La anotación `@OptIn(ExperimentalMaterial3Api::class)` indica que esta función
 * utiliza una API de Material 3 que se considera experimental. Esto significa que la
 * API podría cambiar en futuras versiones de la biblioteca. Al usar esta anotación,
 * confirmamos que estamos al tanto de esto.
 *
 * @param title El título que se mostrará en la barra de aplicaciones superior.
 * @param modifier El modificador que se aplicará a la barra de aplicaciones superior.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(title: String, modifier: Modifier = Modifier) {
    TopAppBar(
        title = { Text(title) },
        modifier = modifier
    )
}

/**
 * Un composable para mostrar texto de cuerpo con un estilo consistente.
 *
 * @param text El texto que se mostrará.
 * @param modifier El modificador que se aplicará al texto.
 */
@Composable
fun MyBodyText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = TextAlign.Justify
    )
}

/**
 * Un composable para mostrar títulos con un estilo consistente.
 *
 * @param text El texto que se mostrará.
 * @param modifier El modificador que se aplicará al texto.
 */
@Composable
fun MyTitleText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = 24.sp
    )
}

/**
 * Un Card personalizable para contener otros composables.
 *
 * @param modifier El modificador que se aplicará a la tarjeta.
 * @param content El contenido que se mostrará dentro de la tarjeta.
 */
@Composable
fun MyCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Card(modifier = modifier) {
        content()
    }
}

/**
 * Un indicador de progreso circular.
 *
 * @param modifier El modificador que se aplicará al indicador de progreso.
 */
@Composable
fun MyCircularProgressIndicator(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)
}

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

/**
 * Un cuadro de diálogo de alerta personalizable.
 *
 * @param onDismissRequest Se ejecuta cuando el usuario intenta descartar el diálogo.
 * @param onConfirmation Se ejecuta cuando el usuario hace clic en el botón de confirmación.
 * @param dialogTitle El título del diálogo.
 * @param dialogText El texto del cuerpo del diálogo.
 * @param icon El icono que se mostrará en el diálogo.
 */
@Composable
fun MyAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
    icon: ImageVector
) {
    AlertDialog(
        icon = { Icon(icon, contentDescription = "Dialog Icon") },
        title = { Text(text = dialogTitle) },
        text = { Text(text = dialogText) },
        onDismissRequest = { onDismissRequest() },
        confirmButton = {
            TextButton(onClick = { onConfirmation() }) {
                Text("Confirmar")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismissRequest() }) {
                Text("Cancelar")
            }
        }
    )
}


@Preview(showBackground = true, name = "Common Components Preview")
@Composable
fun CommonComponentsPreview() {
    Compose1Theme {
        var showDialog by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTopAppBar(title = "Preview")
            Spacer(modifier = Modifier.height(16.dp))

            MyCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    MyTitleText(text = "Título de la Tarjeta")
                    Spacer(modifier = Modifier.height(8.dp))
                    MyBodyText(text = "Este contenido está dentro de una tarjeta.")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            MyCircularProgressIndicator()

            Spacer(modifier = Modifier.height(16.dp))

            var text by remember { mutableStateOf("") }
            MyTextField(value = text, onValueChange = { text = it }, label = "Campo de texto")
            Spacer(modifier = Modifier.height(16.dp))
            MyButton(
                onClick = { showDialog = true },
                text = "Mostrar Diálogo"
            )

            if (showDialog) {
                MyAlertDialog(
                    onDismissRequest = { showDialog = false },
                    onConfirmation = { showDialog = false },
                    dialogTitle = "Diálogo de Alerta",
                    dialogText = "Este es un ejemplo de MyAlertDialog.",
                    icon = Icons.Default.Info
                )
            }
            // Para usar MyImage, necesitarás un recurso drawable en tu proyecto.
            // Ejemplo de uso:
            // MyImage(
            //     imageRes = R.drawable.my_image,
            //     contentDescription = "Mi Imagen",
            //     modifier = Modifier.size(100.dp)
            // )
        }
    }
}
