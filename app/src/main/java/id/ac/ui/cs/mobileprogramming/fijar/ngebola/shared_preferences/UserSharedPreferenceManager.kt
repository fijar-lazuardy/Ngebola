package id.ac.ui.cs.mobileprogramming.fijar.ngebola.shared_preferences

import android.content.Context

class UserSharedPreferenceManager(context: Context) {
    private val FIRST_TIME = "isFirstTime"
    private val sharedPreference = context.getSharedPreferences("user", Context.MODE_PRIVATE)
    private val spEditor = sharedPreference.edit()

    fun setFirstTime(value: Boolean) {
        spEditor.putBoolean(FIRST_TIME, value)
        spEditor.apply()
    }

    fun isFirstTime(): Boolean {
        return sharedPreference.getBoolean(FIRST_TIME, true)
    }

}