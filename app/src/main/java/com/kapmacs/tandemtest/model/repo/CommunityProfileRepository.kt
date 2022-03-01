package com.kapmacs.tandemtest.model.repo

import android.util.Log
import androidx.paging.*
import com.kapmacs.tandemtest.model.api.TandemApi
import com.kapmacs.tandemtest.model.data.Member
import com.kapmacs.tandemtest.model.db.CommunityDB
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

private const val TAG = "CommunityProfileRepository"

class CommunityProfileRepository(val api: TandemApi, val db: CommunityDB) : BaseRepository() {
    fun getAllMember() = pagingMembers { db.membersDao().getMembers() }

    suspend fun getCommunityMembers(pageNumber: Int = 1) {
        val response = api.getCommunityPage(pageNumber)
        Log.d(TAG, "getCommunityMembers: page number:$pageNumber")
        db.membersDao().addAll(response.members)
        if (20 == response.members.size) {
            getCommunityMembers(pageNumber + 1)
        }
    }

    suspend fun add(member: Member) {
        db.membersDao().add(member)
    }

    init {
        launch {
            getCommunityMembers()
        }
    }
    private fun pagingMembers(
        block: () -> PagingSource<Int, Member>,
    ): Flow<PagingData<Member>> = Pager(PagingConfig(pageSize = 20)) { block() }.flow
}
