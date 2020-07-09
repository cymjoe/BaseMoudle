package com.cymjoe.work.ui.activity.main

import com.cymjoe.lib_base.constant.Constant
import com.cymjoe.lib_base.retrofit.NetManager
import com.cymjoe.lib_http.BaseViewModel
import com.cymjoe.work.ApiService

class MainViewModel : BaseViewModel(){
    val api=NetManager.createRetrofit(Constant.BASE_URL)?.create(ApiService::class.java)
    fun login() {
        launch {

        }
    }
}