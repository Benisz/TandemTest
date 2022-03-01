package com.kapmacs.tandemtest.ui.community

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kapmacs.tandemtest.model.data.Member
import com.kapmacs.tandemtest.ui.theme.DefaultPadding
import kotlinx.coroutines.flow.Flow

@Composable
fun MemberList(profiles: Flow<PagingData<Member>>, onProfileLiked: (member: Member) -> Unit) {
    val items: LazyPagingItems<Member> = profiles.collectAsLazyPagingItems()
    LazyColumn(verticalArrangement = Arrangement.spacedBy(DefaultPadding)) {
        items(items) { member ->
            if (member != null) {
                ProfileCard(
                    member = member,
                    modifier = Modifier.padding(
                        start = DefaultPadding,
                        end = DefaultPadding,
                        bottom = DefaultPadding
                    )
                ) {
                    onProfileLiked(member)
                }
                Divider(color = Color.Gray)
            }
        }
    }
}