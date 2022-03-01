package com.kapmacs.tandemtest.ui.community

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.PagingData
import com.kapmacs.tandemtest.model.data.Member
import com.kapmacs.tandemtest.ui.theme.DefaultPadding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

@Composable
fun CommunityListScreen(
    navController: NavController,
    viewModel: CommunityViewModel = hiltViewModel()
) {
    val members: Flow<PagingData<Member>> by viewModel.members.collectAsState(emptyFlow())
    Column {
        TopBar(modifier = Modifier.padding(start = DefaultPadding, bottom = DefaultPadding, top = DefaultPadding))
        Divider(color = Color.Gray, thickness = 2.dp, modifier = Modifier.padding(bottom = DefaultPadding, top = DefaultPadding))
        members?.let {
        }
        MemberList(profiles = members) { member: Member ->
            viewModel.liked(member.apply { this.liked = !liked })
        }
    }
}


