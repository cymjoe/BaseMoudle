package com.cymjoe.work.ui.activity.main

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.alibaba.android.arouter.facade.annotation.Route
import com.blankj.utilcode.util.FragmentUtils

import com.cymjoe.lib_arouter.ARoutePath
import com.cymjoe.lib_base.BuildConfig
import com.cymjoe.lib_base.base.BaseActivity
import com.cymjoe.lib_base.entity.NoDataBinding
import com.cymjoe.lib_base.launch
import com.cymjoe.lib_utils.StatusBarUtils
import com.cymjoe.module_work.ui.fragment.WorkFragment
import com.cymjoe.moudle_mine.ui.fragment.MineFragment

import com.cymjoe.work.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.File
import java.io.FileWriter
import java.util.*

@Route(path = ARoutePath.MainActivity)
class MainActivity : BaseActivity<NoDataBinding>() {

    private val viewModel: MainViewModel by viewModel()
    private val fragmentList = listOf(WorkFragment(), MineFragment())

    override fun getLayoutResId() = R.layout.activity_main

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        StatusBarUtils.setTranslucentStatus(this)
        FragmentUtils.add(supportFragmentManager, fragmentList, R.id.container, 0)
        launch(ARoutePath.LoginActivity)

//
    }


    override fun initData() {


    }

    override fun startObserve() {

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ll_home -> {
                FragmentUtils.showHide(fragmentList[0], fragmentList)
                upUI(0)
            }
            R.id.ll_mine -> {
                FragmentUtils.showHide(fragmentList[1], fragmentList)
                upUI(1)
            }
            R.id.img_middle -> {
                launch(ARoutePath.CloudActivity)
            }
        }
    }

    private fun upUI(n: Int) {
        resources?.let {
            tv_home.setTextColor(it.getColor(R.color.text_black))
            tv_mine.setTextColor(it.getColor(R.color.text_black))
            img_home.setImageResource(R.drawable.work_normal)
            img_mine.setImageResource(R.drawable.mine_normal)
            when (n) {
                0 -> {
                    img_home.setImageResource(R.drawable.work_check)
                    tv_home.setTextColor(it.getColor(R.color.text_red))
                }
                1 -> {
                    img_mine.setImageResource(R.drawable.mine_check)
                    tv_mine.setTextColor(it.getColor(R.color.text_red))
                }
            }
        }
    }
}

