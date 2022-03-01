package com.kapmacs.tandemtest.ui.community

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kapmacs.tandemtest.R


@Composable
fun TopBar(modifier: Modifier = Modifier) {
    Text(modifier = modifier, text = LocalContext.current.getString(R.string.community_title), fontSize = 24.sp, fontWeight = FontWeight.Bold)
}