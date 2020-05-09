package com.yk.ktbase

import android.graphics.Color
import android.util.Log

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class L {

    companion object obj {
        @JvmField
        var className = ""

        @JvmField
        var methodName = ""

        @JvmField
        var lineNumber = 0

        @JvmField
        var ENABLE = true

        @JvmField
        var COLOR = true

        @JvmStatic
        fun initLog(enable: Boolean, color: Boolean) {
            ENABLE = enable
            COLOR = color
        }


        @JvmStatic
        private fun getMethodNames(sElements: Array<StackTraceElement>) {
            className = sElements[1].fileName
            methodName = sElements[1].methodName
            lineNumber = sElements[1].lineNumber
        }

        @JvmStatic
        private fun createLog(log: String): String? {
            val buffer = StringBuffer()
            buffer.append(methodName)
            if (COLOR) {
                buffer.append("(").append(className).append(":").append(lineNumber).append(")")
            }
            buffer.append("  ")
            buffer.append(log)
            return buffer.toString()
        }

        @JvmStatic
        fun e(message: String?) {
            if (ENABLE) {
                getMethodNames(Throwable().stackTrace)
                Log.e(className, createLog(message!!))
            }
        }

        @JvmStatic
        fun i(message: String?) {
            if (ENABLE) {
                getMethodNames(Throwable().stackTrace)
                Log.i(className, createLog(message!!))
            }
        }

        @JvmStatic
        fun d(message: String?) {
            if (ENABLE) {
                getMethodNames(Throwable().stackTrace)
                Log.d(className, createLog(message!!))
            }
        }

        @JvmStatic
        fun v(message: String?) {
            if (ENABLE) {
                getMethodNames(Throwable().stackTrace)
                Log.v(className, createLog(message!!))
            }
        }

        @JvmStatic
        fun w(message: String?) {
            if (ENABLE) {
                getMethodNames(Throwable().stackTrace)
                Log.w(className, createLog(message!!))
            }
        }

    }


}