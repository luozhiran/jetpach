package com.yk.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.*
import com.yk.jetpack.modul.SecondModel
import kotlin.math.max

class MainActivity : AppCompatActivity() {

    var TAG="MainActivity"

    lateinit var tv: TextView
    lateinit var btn: Button
    lateinit var model: SecondModel

    val nameObserver = Observer<String> {
        tv.text = it
    }
//
//    val liveDataMap: LiveData<Int> = Transformations.map<String, Int>(model.mCurrent!!) { input ->
//        input.length
//    }
//
//    var liveDataSwitch: LiveData<String> =
//        Transformations.switchMap<String, String>(model.mCurrent!!) { input: String? ->
//            MutableLiveData<String>().also { it.value = input!!.toLowerCase()}
//        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv = findViewById(R.id.text)
        btn = findViewById(R.id.btn)

        model = ViewModelProviders.of(this).get(SecondModel::class.java)
        model.mCurrent!!.observe(this, nameObserver)
        model.mCurrent?.value

        btn.setOnClickListener {
            model.mCurrent?.value = (1000..5000).random().toString()
        }
    }


}
