package com.yk.testjetpack.views

import com.yk.base.mvp.IView
import com.yk.testjetpack.datas.User

interface UserView : IView {
    fun onUser(user: User?)
    fun onError();
}