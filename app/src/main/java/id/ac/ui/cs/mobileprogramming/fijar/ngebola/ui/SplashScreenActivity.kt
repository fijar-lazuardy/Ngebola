package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui

import android.app.AlertDialog
import android.content.Intent
import android.opengl.GLSurfaceView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.opengl.MyGLSurfaceView
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.start.OnboardingActivity
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.utils.ConnectionChecker
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.utils.ConnectionUtil

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var glView: GLSurfaceView
    private val util = ConnectionUtil()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        glView = MyGLSurfaceView(this)

        setContentView(glView)

        if (!util.isConnected(this)) {
            AlertDialog.Builder(this)
                    .setMessage("This app required an internet connection.")
                    .setPositiveButton("OK") { _, _ ->
                        super.onBackPressed()
                        finish()
                    }
                    .show()
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, OnboardingActivity::class.java))
                finish()
            }, 1000)
        }

    }
}