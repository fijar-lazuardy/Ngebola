package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.league

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver.HeadsetPlugReceiver
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver.NetworkReceiver

class StandingFragment : Fragment() {
    private lateinit var viewModel: StandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.standing_fragment, container, false)
        viewModel = ViewModelProvider(this).get(StandingViewModel::class.java)
        val receiver = object : NetworkReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkCapabilities = cm.activeNetwork
                val activeNetwork = cm.getNetworkCapabilities(networkCapabilities)
                isConnected = when {
                    activeNetwork!!.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    else -> false
                }
            }
        }
        if (!receiver.isConnected) {
            Toast.makeText(context, "Connection lost", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}