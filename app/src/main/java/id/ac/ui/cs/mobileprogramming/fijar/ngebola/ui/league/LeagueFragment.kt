package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.league

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.utils.ErrorResponse

class LeagueFragment : Fragment() {

    private lateinit var leagueViewModel: LeagueViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        leagueViewModel =
            ViewModelProvider(requireActivity()).get(LeagueViewModel::class.java)
        val view = inflater.inflate(R.layout.league_fragment, container, false)

        leagueViewModel.getLeagueInfo()

        if (ErrorResponse.ERROR_CODE_ALT != 0) {
//            Toast.makeText(requireContext(), ErrorResponse.ERROR_MESSAGE, Toast.LENGTH_LONG).show()
            Toast.makeText(requireContext(), ErrorResponse.ERROR_CODE_ALT.toString(), Toast.LENGTH_LONG).show()
        }

        val leagueName: TextView = view.findViewById(R.id.league_info_value)
        val leagueCountry: TextView = view.findViewById(R.id.league_country_value)
        val standingButton: Button = view.findViewById(R.id.standing_button)
        standingButton.isEnabled = false

        leagueViewModel.leagueInfo.observe(viewLifecycleOwner, Observer<League> {
            leagueName.text = it.name
            leagueCountry.text = it.country
            leagueViewModel.getStandingInfo(it.league_id!!)
        })


        leagueViewModel.standingInfo.observe(viewLifecycleOwner, Observer {
            standingButton.isEnabled = true
        })

        standingButton.setOnClickListener {
            val fragment = StandingFragment()
            val fm = parentFragmentManager.beginTransaction()
            fm.addToBackStack("league_fragment")
            fm.replace(R.id.nav_host_fragment, fragment)
            fm.commit()
        }

        return view
    }
}