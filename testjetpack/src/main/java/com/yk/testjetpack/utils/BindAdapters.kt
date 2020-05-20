package com.yk.testjetpack.utils

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter

//In Kotlin, static methods can be created by adding functions to the top level of a Kotlin file or as extension functions on the class.
//在Kotlin中，可以通过将功能添加到Kotlin文件的顶级来创建静态方法，也可以将其作为类的扩展功能来创建。

@BindingAdapter("app:hideIfZero")
fun hideIfZero(view: View, number: Int) {
    view.visibility = if (number == 0) View.GONE else View.VISIBLE
}


@BindingAdapter(value = ["app:progressScaled", "android:max"], requireAll = true)
fun setProgress(progress: ProgressBar, progressValue: Int, max: Int) {
    progress.progress =(progressValue*max/5).coerceAtMost(max)
}


