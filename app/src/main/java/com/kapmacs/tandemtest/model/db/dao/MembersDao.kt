package com.kapmacs.tandemtest.model.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kapmacs.tandemtest.model.data.Member

@Dao
interface MembersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(member: Member)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAll(member: List<Member>)

    @Query("SELECT * FROM Member")
    fun getMembers(): PagingSource<Int, Member>
}
