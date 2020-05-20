package com.yk.net_base

import io.reactivex.FlowableTransformer
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RxScheduler {
    companion object {
        /**
         * 统一线程处理
         *
         * @param <T> 指定的泛型类型
         * @return FlowableTransformer
        </T> */
        fun <T> Flo_io_main(): FlowableTransformer<T, T> {
            return FlowableTransformer { upstream ->
                upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }

        /**
         * 统一线程处理
         *
         * @param <T> 指定的泛型类型
         * @return ObservableTransformer
        </T> */
        fun <T> Obs_io_main(): ObservableTransformer<T, T> {
            return ObservableTransformer { upstream ->
                upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
            }
        }
    }

}