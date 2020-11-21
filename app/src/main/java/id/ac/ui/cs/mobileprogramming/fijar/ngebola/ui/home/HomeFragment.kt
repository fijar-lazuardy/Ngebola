package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val view = inflater.inflate(R.layout.home_fragment, container, false)
        val playerName: TextView= view.findViewById(R.id.player_name_value)
        val playerNationality: TextView = view.findViewById(R.id.player_nationality_value)

        homeViewModel.getPlayer()

        homeViewModel.playerInfo.observe(viewLifecycleOwner, Observer {
            playerName.text = it.name
            playerNationality.text = it.nationality
        })

        return view
    }
}