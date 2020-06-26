package com.cymjoe.moudle_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.cymjoe.lib_arouter.ARoutePath
import com.cymjoe.lib_base.launch
import com.cymjoe.lib_base.retrofit.NetManager

@Route(path = ARoutePath.LoginActivity)
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }
}
