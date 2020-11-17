package id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification

import android.content.Context
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.shared_preferences.UserSharedPreferenceManager

enum class ServiceState {
    STARTED,
    STOPPED
}

fun setServiceState(context: Context, state: ServiceState) {
    val sharedPrefs = UserSharedPreferenceManager(context)
    sharedPrefs.setServiceState(state.name)
}

fun getServiceState(context: Context): ServiceState {
    val sharedPrefs = UserSharedPreferenceManager(context)
    val value = sharedPrefs.getServiceState()
    return ServiceState.valueOf(value.toString())
}