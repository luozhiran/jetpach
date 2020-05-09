package com.yk.testlib.datas

import androidx.lifecycle.ViewModel

/**
 * 这个ViewModel只起到提供数据作用
 * 在onCreate中创建，在OnDestroy中消费
 */
class ItgModel : ViewModel() {
     var itgData: ItgData?=null
}