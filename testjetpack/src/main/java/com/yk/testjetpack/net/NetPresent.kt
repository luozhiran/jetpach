package com.yk.testjetpack.net

import com.yk.base.mvp.IPresenterImpl
import com.yk.base.mvp.OnEmpty
import com.yk.base.mvp.OnResult
import com.yk.testjetpack.views.UserView

class NetPresent : IPresenterImpl<UserView>() {

    var model: ServiceModel? = null

    init {
        model = ServiceModel()
    }


     fun getUser() {
        progressFlowableCommon(model?.user, { mView.onUser(user = it) }, { mView.onError() })
    }
}