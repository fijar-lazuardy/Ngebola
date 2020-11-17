package id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

open class NetworkReceiver: BroadcastReceiver() {
    var isConnected = false
    override fun onReceive(context: Context?, intent: Intent?) {

    }

    fun isConnectedToInternet(): Boolean {
        return isConnected
    }
}