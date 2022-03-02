package com.kapmacs.tandemtest.model.db.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.kapmacs.tandemtest.model.data.Member

@Dao
interface MembersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(member: Member)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addAll(member: List<Member>)

    @Query("SELECT * FROM Member")
    fun getMembers(): PagingSource<Int, Member>

    @Query("SELECT * FROM Member")
    fun getMembersRaw(): List<Member>

    @Delete
    fun deleteMember(member: Member)

    @Query("DELETE FROM Member")
    fun deleteMembers()
}
