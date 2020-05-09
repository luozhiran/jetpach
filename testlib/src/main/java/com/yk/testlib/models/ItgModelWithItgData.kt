package com.yk.testlib.models

import androidx.lifecycle.*
import com.yk.testlib.datas.ItgData
import java.text.SimpleDateFormat
import java.util.*

class ItgModelWithItgData : ViewModel() {
    var itgLiveData: MutableLiveData<ItgData> = MutableLiveData()
    var itgData: ItgData = ItgData(
        "", SimpleDateFormat(
            "yyyy-MM-dd HH:ss",
            Locale.CHINA
        ).format(Date())
    )

    init {
        itgLiveData.value = itgData
    }

    companion object {
        fun instance(owner: ViewModelStoreOwner): ItgModelWithItgData {
            return ViewModelProvider(owner).get(ItgModelWithItgData::class.java)
        }
    }
}