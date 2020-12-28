package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui

import android.content.Intent
import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.opengl.MyGLSurfaceView
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.start.OnboardingActivity

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var glView: GLSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        glView = MyGLSurfaceView(this)

        setContentView(glView)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, OnboardingActivity::class.java))
            finish()
        }, 2121)
    }
}