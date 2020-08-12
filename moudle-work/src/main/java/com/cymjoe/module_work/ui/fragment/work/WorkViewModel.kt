package com.cymjoe.module_work.ui.fragment.work

import androidx.lifecycle.MutableLiveData
import com.cymjoe.lib_base.constant.Constant
import com.cymjoe.lib_base.constant.Constant.HOME_AD
import com.cymjoe.lib_base.entity.dataConvert
import com.cymjoe.lib_base.retrofit.NetManager
import com.cymjoe.lib_http.BaseViewModel
import com.cymjoe.lib_model.response.BannerEntity
import com.cymjoe.module_work.api.BannerApi
import com.youth.banner.Banner

class WorkViewModel : BaseViewModel() {
    private val api = NetManager.createRetrofit(Constant.BASE_URL).create(BannerApi::class.java)
    var banner = MutableLiveData<List<BannerEntity>>()
    fun getBanner() {
        launch {
            val data = api.getBanner(HOME_AD).dataConvert()
            banner.value = data
        }
    }
}