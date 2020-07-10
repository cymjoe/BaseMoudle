package com.cymjoe.moudle_mine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blankj.utilcode.util.FragmentUtils
import com.cymjoe.lib_utils.StatusBarUtils
import com.cymjoe.moudle_mine.ui.fragment.MineFragment

class MineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mine)
        StatusBarUtils.setTranslucentStatus(this)
        val workFragment = MineFragment()
        FragmentUtils.add(supportFragmentManager, workFragment, R.id.container)
        FragmentUtils.show(workFragment)

    }
}
