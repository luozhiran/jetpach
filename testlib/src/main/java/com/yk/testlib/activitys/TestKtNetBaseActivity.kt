package com.yk.testlib.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.itg.lib_log.L
import com.yk.net_base.NetApi
import com.yk.net_base.NetInit
import com.yk.net_base.mvvm.NetLoading
import com.yk.testlib.R
import com.yk.testlib.databinding.ActivityTestKtNetBaseBinding
import com.yk.testlib.models.UserModel

@Route(path = "/testlib/TestKtNetBaseActivity")
class TestKtNetBaseActivity : AppCompatActivity(), NetLoading {

    lateinit var mRootView: ActivityTestKtNetBaseBinding
    lateinit var model: UserModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NetInit.init(application)
        mRootView = DataBindingUtil.setContentView(this, R.layout.activity_test_kt_net_base)
        model = UserModel(this, this)
        mRootView.sendNetRequest.setOnClickListener(View.OnClickListener {
            model.getUser()
        })
    }

    override fun showLoading() {

        L.e("开始发起请求")
    }

    override fun hideLoading() {
        L.e("请求结束")
    }
}
