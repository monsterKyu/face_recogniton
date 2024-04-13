package com.kookie.face_recognition

import android.graphics.PointF
import android.graphics.RectF
import android.os.Bundle
import android.transition.TransitionManager
import android.util.SizeF
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.kookie.face_recognition.databinding.ActivityMainBinding
import com.kookie.face_recognition.recognition.FaceAnalyzerListener

class MainActivity : AppCompatActivity() , FaceAnalyzerListener{
    private lateinit var binding: ActivityMainBinding

    private val camera = Camera(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setProgressText("시작하기를 눌러주세요")
        camera.initCamera(binding.camaraLayout, this@MainActivity)

        binding.startDetectButton.setOnClickListener {
                it.isVisible = false
            binding.faceOverlayView.reset()
            camera.startFaceDetect()
                setProgressText("얼굴을 보여주세요")
            }

    }

    override fun detect() {
    }

    override fun stopDetect() {
        camera.stopFaceDetect()
        reset()
    }

    override fun notDetect() {
        binding.faceOverlayView.reset()
    }

    override fun detectProgress(progress: Float, message: String) {
        setProgressText(message)
        binding.faceOverlayView.setProgress(progress)
    }

    override fun facesSize(rectF: RectF, sizeF: SizeF, pointF: PointF) {
        binding.faceOverlayView.setSize(rectF, sizeF, pointF)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        camera.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun reset(){
        binding.startDetectButton.isVisible = true
    }

    private fun setProgressText(text:String){
        TransitionManager.beginDelayedTransition(binding.root)
        binding.progressTextview.text = text
    }
}