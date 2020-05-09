package com.yk.testlib.activitys.livedata_videmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.yk.ktbase.L
import com.yk.testlib.R
import com.yk.testlib.databinding.ActivityUserLiveDataBinding
import com.yk.testlib.datas.ItgData
import java.text.SimpleDateFormat
import java.util.*

/**
 * 单独使用liveData，liveData具有生命周期感知
 * 没有和viewModel联合使用，不具有恢复数据功能
 *
 * https://www.jianshu.com/p/2fa0aa513a32
 * 1.UI组件和数据绑定
 * 2.组件和数据相关的内容能实时更新
 */
@Route(path = "/testlib/UseLiveDataActivity")
class UseLiveDataActivity : AppCompatActivity() {

    lateinit var itgData: ItgData
    lateinit var itgLiveData: MutableLiveData<ItgData>
    lateinit var mRootView: ActivityUserLiveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRootView = DataBindingUtil.setContentView(
            this,
            R.layout.activity_user_live_data
        )
        init()
        mRootView.btn.setOnClickListener {
            itgData.time = SimpleDateFormat("yyyy-MM-dd HH:ss", Locale.CHINA).format(Date())
            itgLiveData.value = itgData
        }
    }


    /**
     * 初始换一个liveData
     */
    fun init() {
        itgData = ItgData("itg", SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA).format(Date()))
        itgLiveData = MutableLiveData(itgData)
        itgLiveData.observe(this, Observer<ItgData> {
            L.e("监听数据变化${it.time}")
            mRootView.time.text = it.time
        })
    }
}


