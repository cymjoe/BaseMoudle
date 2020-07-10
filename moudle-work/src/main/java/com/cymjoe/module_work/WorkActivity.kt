package com.cymjoe.module_work

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blankj.utilcode.util.FragmentUtils
import com.cymjoe.module_work.ui.fragment.WorkFragment

class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        val workFragment = WorkFragment()
        FragmentUtils.add(supportFragmentManager, workFragment, R.id.container)
        FragmentUtils.show(workFragment)

    }
}
