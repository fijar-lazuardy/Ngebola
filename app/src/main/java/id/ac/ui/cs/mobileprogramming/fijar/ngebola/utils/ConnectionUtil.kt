package id.ac.ui.cs.mobileprogramming.fijar.ngebola.utils

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.*

class ConnectionUtil {
    fun isConnected(context: Context): Boolean {
        val connectivityManager: ConnectivityManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        var netInternet = false

        connectivityManager.allNetworks.forEach { network ->
            network?.let {
                connectivityManager.getNetworkCapabilities(it)
                        ?.let { networkCapabilities ->
                            netInternet =
                                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                        }
            }
        }

        return netInternet
    }
}