package com.yk.testlib.activitys.livedata_videmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.yk.testlib.R
import com.yk.testlib.databinding.ActivityUseLiveDataAndViewModelBinding
import com.yk.testlib.datas.ItgData
import com.yk.testlib.models.ItgModelWithItgData
import java.text.SimpleDateFormat
import java.util.*
import androidx.lifecycle.Observer

@Route(path = "/testlib/UseLiveDataAndViewModelActivity")
class UseLiveDataAndViewModelActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var mRootView: ActivityUseLiveDataAndViewModelBinding
    lateinit var itgModelWithItgData: ItgModelWithItgData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mRootView =
            DataBindingUtil.setContentView(this, R.layout.activity_use_live_data_and_view_model)
        itgModelWithItgData = ItgModelWithItgData.instance(this)
        itgModelWithItgData.itgLiveData.observe(this, Observer {
            mRootView.time.text = it.time
        })
        mRootView.btn.setOnClickListener(::onClick)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn -> {
                itgModelWithItgData.itgData.time =
                    SimpleDateFormat("yyyy-MM-dd HH:ss", Locale.CHINA).format(Date())
                itgModelWithItgData.itgLiveData.value = itgModelWithItgData.itgData
            }
        }
    }
}
