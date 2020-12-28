package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.opengl

import android.content.Context
import android.opengl.GLSurfaceView

class MyGLSurfaceView(context: Context) : GLSurfaceView(context) {
    private val glRenderer: GLRenderer

    init {
        setEGLContextClientVersion(2)

        preserveEGLContextOnPause = true

        glRenderer = GLRenderer()

        setRenderer(glRenderer)
    }
}