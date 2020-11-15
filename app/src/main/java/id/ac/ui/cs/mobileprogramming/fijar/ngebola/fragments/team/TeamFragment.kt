package id.ac.ui.cs.mobileprogramming.fijar.ngebola.fragments.team

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R

class TeamFragment : Fragment() {
    private lateinit var teamViewModel: TeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.team_fragment, container, false)
        teamViewModel = ViewModelProvider(this)[TeamViewModel::class.java]

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}