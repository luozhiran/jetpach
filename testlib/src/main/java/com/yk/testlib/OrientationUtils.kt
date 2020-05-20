package com.yk.testlib

import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.ActivityInfo

class OrientationUtils {
    companion object {
        @SuppressLint("SourceLockedOrientationActivity")
        fun switchOrientation(activity: Activity, defaultOrientation: Int) {
            when (activity.requestedOrientation) {
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE -> activity.requestedOrientation =
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT -> activity.requestedOrientation =
                    ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED -> activity.requestedOrientation =
                    defaultOrientation
            }
        }
    }
}