package com.kuvuni.compose1.ui.functions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.components.MyAlertDialog
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Muestra un diálogo de confirmación.
 *
 * @param showDialog Booleano para controlar la visibilidad del diálogo.
 * @param onDismiss La acción a realizar cuando se descarta el diálogo.
 */
@Composable
fun ShowConfirmationDialog(showDialog: Boolean, onDismiss: () -> Unit) {
    if (showDialog) {
        MyAlertDialog(
            onDismissRequest = onDismiss,
            onConfirmation = onDismiss,
            dialogTitle = "Confirmación",
            dialogText = "¿Estás seguro de que quieres realizar esta acción?",
            icon = Icons.Filled.Add
        )
    }
}

@Preview(showBackground = true, name = "ShowConfirmationDialog Preview")
@Composable
fun ShowConfirmationDialogPreview() {
    Compose1Theme {
        var showDialog by remember { mutableStateOf(true) } // Se muestra por defecto
        ShowConfirmationDialog(showDialog = showDialog, onDismiss = { showDialog = false })
    }
}
