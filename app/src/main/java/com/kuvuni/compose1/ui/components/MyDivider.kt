package com.kuvuni.compose1.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.kuvuni.compose1.ui.theme.Compose1Theme

/**
 * Un separador visual (Divider).
 *
 * @param modifier El modificador que se aplicará al divisor.
 * @param thickness El grosor del divisor.
 * @param color El color del divisor.
 */
@Composable
fun MyDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = Color.Gray
) {
    Divider(
        modifier = modifier,
        thickness = thickness,
        color = color
    )
}

@Preview(showBackground = true, name = "MyDivider Preview")
@Composable
fun MyDividerPreview() {
    Compose1Theme {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Elemento superior")
            MyDivider(modifier = Modifier.padding(vertical = 8.dp))
            Text(text = "Elemento inferior")
        }
    }
}
