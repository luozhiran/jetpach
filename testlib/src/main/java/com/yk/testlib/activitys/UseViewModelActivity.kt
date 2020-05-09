package com.yk.testlib.activitys

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.yk.ktbase.L
import com.yk.ktbase.Orientation
import com.yk.testlib.R
import com.yk.testlib.databinding.ActivityUserViewModelBinding
import com.yk.testlib.datas.ItgData
import com.yk.testlib.datas.ItgModel
import java.text.SimpleDateFormat
import java.util.*

/**
 * 1.简单使用viewModel,viewModel具有activity的生命周期，在onCreate()获取viewModel，然后在onDestroy()销毁
 * 2.单一功能，为UI组件提供数据.
 * 3.代替OnSaveActivity()起到保存数据作用
 */
@Route(path = "/testlib/UseViewModelActivity")
class UseViewModelActivity : AppCompatActivity() {
    var mScreenOrientation: Int = 0
    lateinit var mRootView: ActivityUserViewModelBinding
    lateinit var itgModel: ItgModel

    var test: ItgData? = null//没有使用ViewModel，每次切换屏幕横竖屏，test都是null


    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_view_model)
        mScreenOrientation = requestedOrientation
        mRootView = DataBindingUtil.setContentView(this, R.layout.activity_user_view_model)
        //获取到ViewModel,android系统框架管理VieWModel的生命周期
        itgModel = ViewModelProvider(this).get(ItgModel::class.java)
        if (test == null) {
            test = ItgData("横竖屏1", SimpleDateFormat("yyyy-MM-dd HH:ss", Locale.CHINA).format(Date()))
        }
        if (itgModel.itgData == null) {
            itgModel.itgData = ItgData("横竖屏", SimpleDateFormat("yyyy-MM-dd HH:ss", Locale.CHINA).format(Date()))
        }
        mRootView.time.text = itgModel.itgData?.time
        mRootView.btn.setOnClickListener {
            Orientation.switchOrientation(this, ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
        }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        L.e("旋转回调监听")
    }
}
