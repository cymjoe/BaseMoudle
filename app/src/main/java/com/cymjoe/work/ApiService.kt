package com.cymjoe.work

import com.cymjoe.lib_base.entity.BaseResp
import com.example.lib_model.response.VisitBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    /**
     *
     *
     * @param token
     * @return
     */
    @GET("article/getArticle?id=439447379505590272")
    suspend fun getVisitList(@Header("Authorization") token: String): BaseResp<List<VisitBean>>
}