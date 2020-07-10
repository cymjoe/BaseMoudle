package com.cymjoe.lib_arouter

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import java.util.*

object ARouteUtils {
    fun launch(activityName: String?) {
        ARouter.getInstance().build(activityName)
            .navigation()
    }

    fun launch(activityName: String?, bundle: Bundle) {
        val build = ARouter.getInstance().build(activityName)
        build.with(bundle)
        build.navigation()

    }
}