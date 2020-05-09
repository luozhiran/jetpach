package com.yk.testlib.activitys.livedata_videmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.yk.testlib.R

@Route(path = "/testlib/UseLiveDataAndViewModelActivity")
class UseLiveDataAndViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use_live_data_and_view_model)
    }
}
