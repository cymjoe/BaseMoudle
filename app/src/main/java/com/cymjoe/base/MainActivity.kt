package com.cymjoe.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.cymjoe.lib_arouter.ARoutePath
import com.cymjoe.lib_base.retrofit.NetManager
import com.cymjoe.lib_base.toLogin
@Route(path = ARoutePath.MainActivity)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}

