package com.cymjoe.module_work;

import androidx.multidex.MultiDex;

import com.cymjoe.lib_base.base.BaseApplication;

public class MyApp extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }
}
