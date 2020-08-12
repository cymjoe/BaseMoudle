package com.cymjoe.lib_base

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.launcher.ARouter
import com.blankj.utilcode.util.ToastUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cymjoe.lib_arouter.ARoutePath
import com.cymjoe.lib_arouter.ARouteUtils
import com.cymjoe.lib_base.base.BaseApplication
import com.cymjoe.lib_base.constant.Constant
import com.cymjoe.lib_base.glide.GlideRoundTransform
import com.cymjoe.lib_utils.LogUtil
import com.cymjoe.lib_utils.RSAUtils
import org.greenrobot.eventbus.EventBus


fun launch(
    clazz: String,
    block: (Postcard.() -> Unit)? = null
) {
    ARouter.getInstance().build(clazz).apply {
        if (block != null) {
            block()
        }
    }.navigation()
}


fun Activity.launchOver(clazz: String) {
    launch(clazz)
    finish()
}

fun launch(clazz: String, bundle: Bundle) {
    ARouteUtils.launch(clazz, bundle)
}


fun Activity.launchOver(clazz: String, bundle: Bundle) {
    launch(clazz, bundle)
    finish()
}

fun Any.log(tag: String, msg: String) {
    LogUtil.d(tag, msg)

}

fun <T : ViewModel> FragmentActivity.getViewModels(clazz: Class<T>): T {
    return ViewModelProvider(this).get(clazz)
}

fun <T : ViewModel> Fragment.getViewModels(clazz: Class<T>): T {
    return activity?.let { ViewModelProvider(it).get(clazz) }!!
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

fun ImageView.load(url: String, dps: Int? = 0) {
    if (!TextUtils.isEmpty(url)) {
        val roundedCorners = GlideRoundTransform(context, dps!!.dp)
        val options = RequestOptions.bitmapTransform(roundedCorners).override(width, height)
        Glide.with(context)
            .load(url)
            .apply(options)
            .into(this)
    }

}

// RSA加密
fun Any.encrypt(msg: String): String {
    return RSAUtils.encrypt(msg, RSAUtils.getPublicKey(Constant.PUBLIC_KEY))
}


