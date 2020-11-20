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
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver.NetworkReceiver

class LeagueFragment : Fragment() {

    private lateinit var leagueViewModel: LeagueViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var intent: Intent
    private lateinit var args: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        leagueViewModel =
            ViewModelProvider(requireActivity()).get(LeagueViewModel::class.java)
        val view = inflater.inflate(R.layout.league_fragment, container, false)

        leagueViewModel.getLeagueInfo()

        val leagueName: TextView = view.findViewById(R.id.league_info_value)
        val leagueCountry: TextView = view.findViewById(R.id.league_country_value)
        val leagueSeason: TextView = view.findViewById(R.id.league_season_value)
        val standingButton: Button = view.findViewById(R.id.standing_button)

        leagueViewModel.leagueInfo.observe(viewLifecycleOwner, Observer<League> {
            leagueName.text = it.name
            leagueCountry.text = it.country
            leagueSeason.text = it.season.toString()
            args = Bundle()
            args.putInt("league_id", it.league_id!!)


//            intent = Intent(requireContext(), )
            leagueViewModel.getStandingInfo(it.league_id!!)
        })

//        recyclerView = view.findViewById(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(activity)


//        leagueViewModel.standingInfo.observe(viewLifecycleOwner, Observer {

//        })

        standingButton.setOnClickListener {
            val fragment = StandingFragment()
            fragment.arguments = args

            val fm = parentFragmentManager.beginTransaction()
            fm.addToBackStack("league_fragment")
            fm.replace(R.id.nav_host_fragment, fragment)
            fm.commit()
        }

        return view
    }
}