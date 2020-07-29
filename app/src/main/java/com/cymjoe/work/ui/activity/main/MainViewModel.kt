package com.cymjoe.work.ui.activity.main

import android.util.Log
import com.cymjoe.lib_base.constant.Constant
import com.cymjoe.lib_base.entity.dataConvert
import com.cymjoe.lib_base.retrofit.NetManager
import com.cymjoe.lib_http.BaseViewModel
import com.cymjoe.work.ApiService

class MainViewModel : BaseViewModel() {
    private val api = NetManager.createRetrofit(Constant.BASE_URL).create(ApiService::class.java)
    fun login() {

        launch {
            emitUiState(loading = true)
        }
    }
}