package com.yk.testlib

import com.yk.testlib.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Url


interface UserApi {
    @GET
    fun getUser(@Url url: String?): Flowable<User?>
}