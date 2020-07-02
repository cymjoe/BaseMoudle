package com.cymjoe.work.ui.activity.main

import com.alibaba.android.arouter.facade.annotation.Route

import com.cymjoe.lib_arouter.ARoutePath
import com.cymjoe.lib_base.base.BaseActivity
import com.cymjoe.lib_base.entity.NoDataBinding
import com.cymjoe.lib_base.launch
import com.cymjoe.work.R
import org.koin.androidx.viewmodel.ext.android.viewModel

@Route(path = ARoutePath.MainActivity)
class MainActivity : BaseActivity<NoDataBinding>() {

    private val viewModel: MainViewModel by viewModel()

    override fun getLayoutResId() = R.layout.activity_main

    override fun initView() {
        launch(ARoutePath.LoginActivity)
    }

    override fun initData() {

    }

    override fun startObserve() {

    }

}

