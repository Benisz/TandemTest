package com.kapmacs.tandemtest


import android.content.Context
import androidx.room.Room
import com.kapmacs.tandemtest.model.db.CommunityDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
object TestApplicationTest {
    @Provides
    @Named("TestDB")
    fun inMemoryDB(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context,CommunityDB::class.java).allowMainThreadQueries().build()
}