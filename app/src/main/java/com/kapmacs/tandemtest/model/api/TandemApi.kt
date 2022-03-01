package com.kapmacs.tandemtest.model.api

import com.kapmacs.tandemtest.model.data.CommunityResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TandemApi {
    @GET("community_{page}.json")
    suspend fun getCommunityPage(@Path("page") pageNumber: Int): CommunityResponse
}
