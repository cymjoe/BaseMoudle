package com.cymjoe.moudle_user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.cymjoe.lib_arouter.ARoutePath
import com.cymjoe.lib_base.toast

@Route(path = ARoutePath.UserActivity)
class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        toast(intent.getStringExtra("url"))
    }
}
