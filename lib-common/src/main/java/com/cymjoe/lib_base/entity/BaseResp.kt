package com.cymjoe.lib_base.entity

import androidx.annotation.Keep
import com.cymjoe.lib_http.APIException

@Keep
data class BaseResp<T>(
    var code: Int = 0,
    var msg: String = "",
    var desc: String = "",
    var data: T


)


/*数据解析扩展函数*/
fun <T> BaseResp<T>.dataConvert(): T {
    if (code == 200) {
        return data
    } else {
        throw  APIException(code, msg)
    }
}