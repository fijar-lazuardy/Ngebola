package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.opengl

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10
import kotlin.math.sin

class GLRenderer : GLSurfaceView.Renderer {
    var blueColor = 1.0f
    private val ONE_SECOND = 1000

    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        GLES20.glClearColor(0f, 0f, blueColor, 1f)
    }

    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
    }

    override fun onDrawFrame(gl: GL10?) {
        GLES20.glClearColor(0f, 0f, blueColor, 1f)
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)
        blueColor =
                (sin(System.currentTimeMillis() * 2 * Math.PI / ONE_SECOND) * 0.4 + 1).toFloat()
    }
}