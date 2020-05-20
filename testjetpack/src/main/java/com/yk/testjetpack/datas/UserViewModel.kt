package com.yk.testjetpack.datas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class UserViewModel : ViewModel() {
    var userMutableLiveData: MutableLiveData<User> = MutableLiveData<User>()
    fun updateTime() {
        val temp:User = userMutableLiveData.value!!
        temp.birthDay = SimpleDateFormat("yyyy-MM-dd HH:ss", Locale.CHINA).format(Date())
        temp.progress = temp.progress+1
        userMutableLiveData.value = temp
    }
}