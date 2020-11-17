package id.ac.ui.cs.mobileprogramming.fijar.ngebola.shared_preferences

import android.content.Context
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification.ServiceState

class UserSharedPreferenceManager(context: Context) {
    private val FIRST_TIME = "isFirstTime"
    private val service_key = "SERVICE_STATE"
    private val sharedPreference = context.getSharedPreferences("user", Context.MODE_PRIVATE)
    private val spEditor = sharedPreference.edit()

    fun setFirstTime(value: Boolean) {
        spEditor.putBoolean(FIRST_TIME, value)
        spEditor.apply()
    }

    fun isFirstTime(): Boolean {
        return sharedPreference.getBoolean(FIRST_TIME, true)
    }

    fun setServiceState(stateName: String) {
        spEditor.putString(service_key, stateName)
        spEditor.apply()
    }

    fun getServiceState(): String? {
        return sharedPreference.getString(service_key, ServiceState.STOPPED.name)
    }
}