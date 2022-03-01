package com.kapmacs.tandemtest.ui.community

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@Composable
fun NameRow(name: String, referenceCount: Int) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(text = name, modifier = Modifier.weight(1f), fontWeight = FontWeight.Bold)
        Connections(referenceCount = referenceCount)
    }
}