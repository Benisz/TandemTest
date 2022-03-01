package com.kapmacs.tandemtest.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kapmacs.tandemtest.model.data.Member
import com.kapmacs.tandemtest.model.db.dao.MembersDao
import com.kapmacs.tandemtest.util.Converters

@Database(entities = [Member::class], version = 1)
@TypeConverters(Converters::class)
abstract class CommunityDB : RoomDatabase() {
    abstract fun membersDao(): MembersDao
}
