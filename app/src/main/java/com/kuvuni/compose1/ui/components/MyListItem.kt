package com.kuvuni.compose1.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un elemento de lista estándar de Material Design.
 * Es ideal para usar dentro de un `LazyColumn`.
 *
 * @param headlineText El texto principal del elemento de la lista.
 * @param modifier El modificador que se aplicará al ListItem.
 * @param supportingText (Opcional) El texto secundario o subtítulo que aparece debajo del texto principal.
 * @param leadingContent (Opcional) El Composable que se mostrará al inicio del elemento, como un icono.
 * @param trailingContent (Opcional) El Composable que se mostrará al final del elemento, como un interruptor o una casilla de verificación.
 * @param onClick (Opcional) La acción a ejecutar cuando se hace clic en el elemento.
 */
@Composable
fun MyListItem(
    headlineText: String,
    modifier: Modifier = Modifier,
    supportingText: String? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null
) {
    ListItem(
        headlineContent = { Text(headlineText) },
        modifier = modifier.then(
            if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier
        ),
        supportingContent = supportingText?.let { { Text(it) } },
        leadingContent = leadingContent,
        trailingContent = trailingContent
    )
}

@Preview(showBackground = true, name = "MyListItem Preview")
@Composable
fun MyListItemPreview() {
    Compose1Theme {
        MyListItem(
            headlineText = "Jorge Duque",
            supportingText = "Desarrollador de Android",
            leadingContent = {
                Icon(
                    Icons.Filled.Person,
                    contentDescription = "Icono de perfil"
                )
            },
            trailingContent = {
                MyCheckbox(checked = true, onCheckedChange = {}, text = "Activo")
            },
            onClick = {}
        )
    }
}
