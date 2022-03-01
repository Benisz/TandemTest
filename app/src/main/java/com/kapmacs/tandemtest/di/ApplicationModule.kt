package com.kapmacs.tandemtest.di

import android.content.Context
import androidx.room.Room
import com.kapmacs.tandemtest.BuildConfig
import com.kapmacs.tandemtest.model.api.TandemApi
import com.kapmacs.tandemtest.model.db.CommunityDB
import com.kapmacs.tandemtest.model.repo.CommunityProfileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    @Singleton
    @Named("tandem")
    fun provideRetrofit(client: OkHttpClient) = Retrofit
        .Builder()
        .baseUrl(BuildConfig.TANDEM_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()

    @Provides
    fun provideOkHttp() = OkHttpClient
        .Builder().also { builder ->
            if (BuildConfig.DEBUG) {
                builder.addInterceptor(
                    HttpLoggingInterceptor().also {
                        it.level = HttpLoggingInterceptor.Level.BODY
                    }
                )
            }
        }.build()

    @Provides
    @Singleton
    fun provideOpenTandemApiService(
        @Named("tandem") retrofit: Retrofit
    ) = retrofit.create(TandemApi::class.java)

    @Provides
    @Singleton
    fun provideCommunityDB(@ApplicationContext context: Context) = Room
        .databaseBuilder(context, CommunityDB::class.java, "CommunityDB")
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideCommunityRepository(
        api: TandemApi,
        db: CommunityDB
    ) = CommunityProfileRepository(
        api,
        db
    )
}
