package com.yk.testjetpack.net

import com.yk.base.net.ApiRetrofit
import com.yk.testjetpack.datas.User
import io.reactivex.Flowable

class ServiceModel {
    val user: Flowable<User?>? get() = ApiRetrofit.getInstance().create(ServiceApi::class.java)
            .getUser("http://192.168.40.163:8099/web/android")
}