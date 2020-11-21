package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.league

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R


class StandingFragment : Fragment() {
    private lateinit var viewModel: LeagueViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var args: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.standing_fragment, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(LeagueViewModel::class.java)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val leagueId = arguments?.getInt("league_id")
//        viewModel.getStandingInfo(leagueId!!)

        viewModel.standingInfo.observe(viewLifecycleOwner, Observer {
            val recyclerAdapter = RecyclerAdapter(requireContext(), it)
            recyclerView.adapter = recyclerAdapter
        })
        return view
    }


}