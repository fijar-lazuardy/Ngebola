package id.ac.ui.cs.mobileprogramming.fijar.ngebola.fragments.league

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R

class LeagueFragment : Fragment() {

    private lateinit var leagueViewModel: LeagueViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        leagueViewModel =
            ViewModelProvider(this).get(LeagueViewModel::class.java)
        val root = inflater.inflate(R.layout.league_fragment, container, false)

        return root
    }


}