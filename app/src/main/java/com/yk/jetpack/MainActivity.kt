package com.yk.jetpack

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.launcher.ARouter
import com.yk.jetpack.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var mRootView: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRootView = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mRootView.liveDataAndViewModel.setOnClickListener(::onClick)
        mRootView.userLiveData.setOnClickListener(::onClick)
        mRootView.userViewModel.setOnClickListener(::onClick)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.userLiveData -> ARouter.getInstance()
                .build("/testlib/UseLiveDataActivity")
                .navigation()
            R.id.liveDataAndViewModel -> ARouter.getInstance()
                .build("/testlib/UseLiveDataAndViewModelActivity").navigation()
            R.id.userViewModel->ARouter.getInstance().build("/testlib/UseViewModelActivity").navigation()
        }
    }


}
