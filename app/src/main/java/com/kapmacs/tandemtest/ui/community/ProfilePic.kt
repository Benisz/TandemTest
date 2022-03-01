package com.kapmacs.tandemtest.ui.community

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import coil.compose.rememberImagePainter
import coil.transform.RoundedCornersTransformation
import com.kapmacs.tandemtest.R

@Composable
fun ProfilePic(url: String, size: Dp, modifier: Modifier = Modifier) {
    Image(
        painter = rememberImagePainter(data = url, builder = {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_foreground)
            transformations(RoundedCornersTransformation())
        }),
        contentDescription = null,
        modifier = modifier.size(size)
    )
}