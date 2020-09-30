package com.cymjoe.moudle_mine.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.cymjoe.lib_base.base.BaseFragment
import com.cymjoe.lib_base.entity.NoDataBinding
import com.cymjoe.lib_utils.StatusBarUtils
import com.cymjoe.moudle_mine.R


class MineFragment : BaseFragment<NoDataBinding >() {


    override fun getLayoutResId() = R.layout.fragment_mine

    override fun initView() {


    }

    override fun initData() {

    }

    override fun startObserve() {

    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            activity?.let { StatusBarUtils.setTranslucentStatus(it) }
        }
    }



}