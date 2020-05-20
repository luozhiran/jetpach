package com.yk.testlib.models

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yk.log_lib.L
import com.yk.net_base.NetApi
import com.yk.net_base.mvvm.NetManager
import com.yk.net_base.mvvm.NetLoading
import com.yk.net_base.mvvm.interfaces.OnEmpty
import com.yk.net_base.mvvm.interfaces.OnResult
import com.yk.testlib.UserApi
import io.reactivex.Flowable

class UserModel constructor(
    private val lifecycleOwner: LifecycleOwner,
    private val netLoading: NetLoading
) : ViewModel() {
    val userData: MutableLiveData<User> = MutableLiveData()
    fun getUser() {
        var flowable: Flowable<User?> = NetApi.instance.create(UserApi::class.java)
            .getUser("http://192.168.40.163:8099/web/android")
        NetManager.progressFlowableBody(
            flowable,
            lifecycleOwner,
            object : OnResult<User?> {
                override fun result(t: User?) {
                    L.d(t.toString())
                    userData.value = t
                }
            },
            object : OnEmpty {
                override fun empty(code: Int, msg: String?) {
                    msg?.let {
                        L.d(msg)
                    } ?: L.d("错误码")
                }
            }, netLoading
        )
    }


}