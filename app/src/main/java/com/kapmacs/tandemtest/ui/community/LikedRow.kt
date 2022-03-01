package com.kapmacs.tandemtest.ui.community

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import com.kapmacs.tandemtest.R
import com.kapmacs.tandemtest.ui.theme.HalfPadding

@Composable
fun LikedRow(native: String, learns: String, liked: Boolean, onProfileLiked: () -> Unit) {
    var like by remember { mutableStateOf(liked) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Row(modifier = Modifier.weight(1f)) {
            Text(
                text = LocalContext.current.getString(R.string.app_native),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = HalfPadding)
            )
            Text(text = native)
        }
        Row(modifier = Modifier.weight(1f)) {
            Text(
                text = LocalContext.current.getString(R.string.learns),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(end = HalfPadding)
            )
            Text(text = learns)
        }
        IconButton(onClick = {
            like = !like
            onProfileLiked()
        }) {
            Icon(
                if (like) Icons.Filled.ThumbUp else Icons.Outlined.ThumbUp,
                contentDescription = null
            )
        }
    }
}
