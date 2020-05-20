package com.yk.jetpack

import com.alibaba.android.arouter.launcher.ARouter
import com.yk.base.BSApp
import com.yk.base.net.ApiRetrofit

class App: BSApp() {

    override fun onCreate() {
        super.onCreate()
        ApiRetrofit.BASE_URL = "https://www.baidu.com"
        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
            ARouter.printStackTrace()
        }

        ARouter.init(this)
    }
}