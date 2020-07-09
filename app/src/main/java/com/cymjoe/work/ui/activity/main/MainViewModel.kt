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
            val dataConvert = api.getVisitList(
                "eyJhbGciOiJIUzUxMiJ9.eyJ0ZW5jZW50U2lnIjoiZUp3MWpsMExnakFVaHYtTGJndlpXY2M1aFM2eWkwcGlmU3lLTG9Y" +
                        "Tk9GUm1KaVZFLTcyaGRmbCpQYnh2dGx1YXdMVVYxWTRsSVNqa25BODc4KmxxbGpBUmNOYnJoejNuVlVXV0plQkxJREdXVVoqUWRXVkRCWFVEUk" +
                        "9DaFVBb0FwUnh4UUl6KkFEcjUzS2lKMk43MUM5VWxiWTlOVkI0V2V6MDNobUE2V0tlYWlwbk9lTGJLaTl0bS1CczJkUFhuSUl4UlNPbkJueS1x" +
                        "RWpKUiIsInBlb3BsZUlkIjoiNDQxMDUyODgxMTUwOTMwOTQ0IiwiY3JlYXRlZCI6MTU5NDI2NjgxMTc3MiwiYWNjaWQiOiI0NDEwNTI4ODExND" +
                        "Y2MzAxNDQ3IiwiZXhwIjoxNTk5NDUwODExLCJ1c2VySWQiOiI0NDEwNTI4ODExNjMzODY4ODAifQ.0w0X4NYVf4FQJ6SJE4zdze_FlZNp4U8T9" +
                        "h_Nz8R-62Viog1t-xjjgupjQtqNmUXuidWlbfSsi5sF30JDSBr79w"
            ).dataConvert()
            Log.d("PPPPPP", dataConvert.toString())
        }
    }
}