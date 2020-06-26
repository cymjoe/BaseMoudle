package com.cymjoe.lib_base

import android.app.Activity
import com.blankj.utilcode.util.ToastUtils
import com.cymjoe.lib_arouter.ARoutePath
import com.cymjoe.lib_arouter.ARouteUtils
import com.cymjoe.lib_base.base.BaseApplication
import com.cymjoe.lib_base.constant.Constant
import com.cymjoe.lib_utils.LogUtil
import com.cymjoe.lib_utils.RSAUtils
import org.greenrobot.eventbus.EventBus


fun Any.launch(clazz: String) {
    ARouteUtils.launch(clazz)
}


fun Activity.launchOver(clazz: String) {
    launch(clazz)
    finish()
}

fun Any.log(tag: String, msg: String) {
    LogUtil.d(tag, msg)

}

fun Any.toLogin() {
    launch(ARoutePath.LoginActivity)
}

fun Activity.finishActivity(activityName: String) {
    EventBus.getDefault().post(activityName)
}

fun Any.toast(msg: String) {
    ToastUtils.showShort(msg)
}

var Int.dp: Int
    get() = ((this * BaseApplication.getInstance().resources.displayMetrics.density + 0.5f).toInt())
    set(value) {
    }


// RSA加密
fun Any.encrypt(msg: String): String {
    return RSAUtils.encrypt(msg, RSAUtils.getPublicKey(Constant.PUBLIC_KEY))
}


