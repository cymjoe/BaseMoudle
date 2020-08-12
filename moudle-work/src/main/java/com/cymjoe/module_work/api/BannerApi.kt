package com.cymjoe.module_work.api

import com.cymjoe.lib_base.constant.Constant
import com.cymjoe.lib_base.entity.BaseResp
import com.cymjoe.lib_model.response.BannerEntity
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface BannerApi {



    @POST(Constant.BANNER)
    suspend fun getBanner(@Query("adPositionId") adPositionId: String): BaseResp<List<BannerEntity>>

}