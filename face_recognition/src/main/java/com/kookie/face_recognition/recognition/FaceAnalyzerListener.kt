package com.kookie.face_recognition.recognition

import android.graphics.PointF
import android.graphics.RectF
import android.util.SizeF

interface FaceAnalyzerListener {

    fun detect()

    fun stopDetect()

    fun notDetect()

    fun detectProgress(progress: Float, message: String)

    fun facesSize(rectF: RectF, sizeF: SizeF, pointF: PointF)
}