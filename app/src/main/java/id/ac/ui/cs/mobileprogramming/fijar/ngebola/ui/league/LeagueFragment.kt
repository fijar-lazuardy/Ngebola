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
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver.NetworkReceiver

class LeagueFragment : Fragment() {

    private lateinit var leagueViewModel: LeagueViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        leagueViewModel =
            ViewModelProvider(this).get(LeagueViewModel::class.java)
        val view = inflater.inflate(R.layout.league_fragment, container, false)

        leagueViewModel.getLeagueInfo()

        val leagueName: TextView = view.findViewById(R.id.league_name)
        val leagueCountry: TextView = view.findViewById(R.id.league_country)
        val leagueSeason: TextView = view.findViewById(R.id.league_season)

        leagueViewModel.leagueInfo.observe(viewLifecycleOwner, Observer<League> {
            leagueName.text = it.name
            leagueCountry.text = it.country
            leagueSeason.text = it.season.toString()
            leagueViewModel.getStandingInfo(it.league_id!!)
        })

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val receiver = object : NetworkReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkCapabilities = cm.activeNetwork
                val activeNetwork = cm.getNetworkCapabilities(networkCapabilities)
                when {
                    activeNetwork!!.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> isConnected = true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> isConnected = true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> isConnected = true
                    else -> isConnected = false
                }
            }
        }
        if (!receiver.isConnected) {
            Toast.makeText(context, "Connection lost", Toast.LENGTH_SHORT).show()
        }

        leagueViewModel.standingInfo.observe(viewLifecycleOwner, Observer {
            val adapter = RecyclerAdapter(requireContext(), it)
            recyclerView.adapter = adapter
        })



        return view
    }
}