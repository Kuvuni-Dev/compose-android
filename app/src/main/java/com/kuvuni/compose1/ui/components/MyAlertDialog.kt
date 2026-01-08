package com.kuvuni.compose1.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

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

@Preview(showBackground = true, name = "MyAlertDialog Preview")
@Composable
fun MyAlertDialogPreview() {
    Compose1Theme {
        var showDialog by remember { mutableStateOf(true) } // Lo mostramos por defecto en la preview
        if (showDialog) {
            MyAlertDialog(
                onDismissRequest = { showDialog = false },
                onConfirmation = { showDialog = false },
                dialogTitle = "Diálogo de Alerta",
                dialogText = "Este es un ejemplo de MyAlertDialog.",
                icon = Icons.Default.Info
            )
        }
    }
}
