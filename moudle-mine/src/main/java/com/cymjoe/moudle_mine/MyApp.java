package com.cymjoe.moudle_mine;

import androidx.multidex.MultiDex;

import com.cymjoe.lib_base.base.BaseApplication;

public class MyApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}
