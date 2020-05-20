package com.yk.testjetpack.net

import com.yk.testjetpack.datas.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Url

interface ServiceApi {
    @GET
    fun getUser(@Url url: String?): Flowable<User?>?
}