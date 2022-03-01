package com.kapmacs.tandemtest.ui.community

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kapmacs.tandemtest.model.data.Member

@Composable
fun ProfileCard(member: Member, modifier: Modifier = Modifier, onProfileLiked: () -> Unit) {
    Row(modifier = modifier.height(IntrinsicSize.Min)) {
        ProfilePic(url = member.pictureUrl, size = 128.dp)
        Column(modifier = Modifier.fillMaxHeight()) {
            NameRow(name = member.firstName, referenceCount = member.referenceCnt)
            Row(modifier = Modifier.weight(1f)) {
                Text(text = member.topic)
            }
            LikedRow(
                native = member.natives.first(),
                learns = member.learns.first(),
                liked = member.liked,
                onProfileLiked = onProfileLiked
            )
        }
    }
}