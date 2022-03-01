package com.kapmacs.tandemtest.ui.community

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kapmacs.tandemtest.ui.theme.HalfPadding
import com.kapmacs.tandemtest.ui.theme.NewBoxBackGround

@Composable
fun Connections(referenceCount: Int) {
    if (referenceCount> 0) {
        Text(text = referenceCount.toString(), fontWeight = FontWeight.Bold)
    } else {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color = NewBoxBackGround)
                .padding(HalfPadding)
        ) {
            Text(text = "NEW", color = Color.White, fontWeight = FontWeight.Bold,)
        }
    }
}