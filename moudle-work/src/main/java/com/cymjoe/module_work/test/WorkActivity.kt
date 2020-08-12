package com.cymjoe.module_work.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blankj.utilcode.util.FragmentUtils
import com.blankj.utilcode.util.SPUtils
import com.cymjoe.module_work.R
import com.cymjoe.module_work.ui.fragment.work.WorkFragment

class WorkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work)
        SPUtils.getInstance().put("token", "eyJhbGciOiJIUzUxMiJ9.eyJ0ZW5jZW50U2lnIjoiZUp3MWp0MEtna0FVaE45bHI4UE8yWi1jRmJvb2lES1dLQXFoeTJCWE9WaUxxWWdSdlh0aWRqa3ozd3p6WmhkN2pueGZVZTFab2xCTEFKaU5adWRybGpBZUFmdnB4cFczcWlMSEVod2dEbWo0UkpMem9hV2N4b0tVaUpxRDVrckVVaUJJaVA4RFZBejVMczM2LVRGME5UajlzdmN5ekNWa0c3ekNFM1BSKk5RZFRrWnYxOEVXcSpWVWJPa3huRU5sbElGNEljVG5DLUNtTW1RXyIsInBlb3BsZUlkIjoiNDQxMTgyMDgyOTA2NTc4OTQ0IiwiY3JlYXRlZCI6MTU5NTkwNzYzMzE2OSwiYWNjaWQiOiI0NDExODIwODI1Mzc0MzEwNDA3IiwiZXhwIjoxNjAxMDkxNjMzLCJ1c2VySWQiOiI0NDExODIwODMzNzYyOTU5MzYifQ.bjxDby7vN_fuIVm0pgISeRqtQ8kFNnZfGPHAS8xU45LaKjoaol9TvXBDSIijBbRrSEve1vKN9Bl7pWhSxuPYLA")
        val workFragment = WorkFragment()
        FragmentUtils.add(supportFragmentManager, workFragment, R.id.container)
        FragmentUtils.show(workFragment)

    }
}
