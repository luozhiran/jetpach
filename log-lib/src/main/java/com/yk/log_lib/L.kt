package com.yk.log_lib

import android.util.Log
import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter

object L {
    private var className = ""
    private var methodName = ""
    private var lineNumber = 0
    private var PRINT_LOG = true
    fun openLog() {
        PRINT_LOG = true
    }

    fun closeLog() {
        PRINT_LOG = false
    }

    private fun createLog(log: String): String {
        val buffer = StringBuffer()
        buffer.append(methodName)
        buffer.append("(").append(className).append(":").append(lineNumber).append(")")
        buffer.append(log)
        return buffer.toString()
    }

    private fun getMethodNames(sElements: Array<StackTraceElement>) {
        className = sElements[1].fileName
        methodName = sElements[1].methodName
        lineNumber = sElements[1].lineNumber
    }

    fun e(message: String) {
        if (PRINT_LOG) {
            getMethodNames(Throwable().stackTrace)
            Log.e(className, createLog(message))
        }
    }

    fun i(message: String) {
        if (PRINT_LOG) {
            getMethodNames(Throwable().stackTrace)
            Log.i(className, createLog(message))
        }
    }

    fun d(message: String) {
        if (PRINT_LOG) {
            getMethodNames(Throwable().stackTrace)
            Log.d(className, createLog(message))
        }
    }

    fun v(message: String) {
        if (PRINT_LOG) {
            getMethodNames(Throwable().stackTrace)
            Log.v(className, createLog(message))
        }
    }

    fun w(message: String) {
        if (PRINT_LOG) {
            getMethodNames(Throwable().stackTrace)
            Log.w(className, createLog(message))
        }
    }

    private fun write(log: String, path: String) {
        var write: OutputStreamWriter? = null
        try {
            write = OutputStreamWriter(FileOutputStream(path, true), "utf-8")
            val writer = BufferedWriter(write)
            writer.write(log)
            writer.flush()
        } catch (e: IOException) {
            // TODO Auto-generated catch block
            if (write != null) {
                try {
                    write.close()
                } catch (e1: IOException) {
                    e1.printStackTrace()
                }
            }
            e.printStackTrace()
        }
    }
}