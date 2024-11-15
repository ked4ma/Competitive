package com.github.ked4ma.competitive.test

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PrintCaptureStream : PrintStream(ByteArrayOutputStream()) {
    private val capturedStream = ByteArrayOutputStream()

    init {
        this.out = capturedStream
    }

    fun read(): String {
        synchronized(capturedStream) {
            val result = capturedStream.toString()
            capturedStream.reset()
            return result.trimEnd()
        }
    }
}
