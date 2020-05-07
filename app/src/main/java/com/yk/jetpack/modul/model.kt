package com.yk.jetpack.modul

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondModel : ViewModel() {
    var mCurrent: MutableLiveData<String>?=null
        get() {
            if (field == null) {
                field = MutableLiveData()
            }
            return field
        }
}

