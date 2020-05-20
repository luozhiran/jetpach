package com.yk.testjetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.kongzue.dialog.v3.WaitDialog
import com.yk.base.base.BaseActivity
import com.yk.base.utils.L
import com.yk.testjetpack.databinding.ActivityJetpackMainBinding
import com.yk.testjetpack.datas.User
import com.yk.testjetpack.datas.UserViewModel
import com.yk.testjetpack.net.NetPresent
import com.yk.testjetpack.views.UserView

@Route(path = "/testjetpack/JetpackMainActivity")
class JetpackMainActivity : BaseActivity(), UserView {

    lateinit var mRootView: ActivityJetpackMainBinding
    lateinit var mPresent: NetPresent
    lateinit var mUserModel: UserViewModel
    override fun layoutId(): Int {
        return R.layout.activity_jetpack_main
    }

    override fun init() {
        mPresent = NetPresent()
        mPresent.attachView(this)
        mRootView = findByView()
        mUserModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserModel.userMutableLiveData.value = User()
        mRootView.viewModel = mUserModel
        mRootView.str = "luozhiran"
        mRootView.userRequest.setOnClickListener {
            mPresent.getUser()
        }
        mRootView.lifecycleOwner = this
    }


    override fun onUser(user: User?) {
        L.e(user?.toString())
        mRootView.viewModel?.userMutableLiveData?.value = user
    }

    override fun onError() {
        L.e("错误")
    }

    override fun showLoading() {
        WaitDialog.show(this, "loading...")
    }

    override fun hideLoading() {
        WaitDialog.dismiss()
    }


}
