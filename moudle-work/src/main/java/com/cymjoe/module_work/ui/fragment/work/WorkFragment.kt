package com.cymjoe.module_work.ui.fragment.work

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cymjoe.lib_base.base.BaseFragment
import com.cymjoe.lib_base.entity.NoDataBinding
import com.cymjoe.lib_base.getViewModels
import com.cymjoe.lib_base.toast
import com.cymjoe.lib_utils.StatusBarUtils
import com.cymjoe.module_work.BuildConfig
import com.cymjoe.module_work.R
import com.cymjoe.module_work.adapter.WorkAdapter
import com.cymjoe.module_work.entity.HomeEntity
import kotlinx.android.synthetic.main.fragment_work.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class WorkFragment : BaseFragment<NoDataBinding>(),
    SwipeRefreshLayout.OnRefreshListener {
    private val viewModels: WorkViewModel by viewModel()
    override fun getLayoutResId() = R.layout.fragment_work
    private val list = mutableListOf(HomeEntity(0), HomeEntity(1), HomeEntity(2), HomeEntity(3))

    lateinit var workAdapter: WorkAdapter

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initView() {
        activity?.let {
            StatusBarUtils.setStatusBarDarkTheme(it, true)
            StatusBarUtils.setStatusBarColor(it, Color.WHITE)
        }

        workAdapter = WorkAdapter(list)
        rv.adapter = workAdapter
        refresh.setOnRefreshListener(this)

    }

    override fun initData() {
        viewModels.getBanner()
    }

    override fun startObserve() {
        viewModels.apply {
            banner.observe(this@WorkFragment, Observer {
                list[0].data = it
                workAdapter.notifyItemChanged(0)
                refresh.isRefreshing = false

            })

            mException.observe(this@WorkFragment, Observer {
                toast(it.msg)
                refresh.isRefreshing = false
            })
        }
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden) {
            activity?.let { StatusBarUtils.setStatusBarDarkTheme(it, true) }
        }
    }

    override fun onRefresh() {
        initData()
    }


}