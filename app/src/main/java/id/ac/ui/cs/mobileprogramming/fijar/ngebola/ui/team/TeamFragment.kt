package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.team

import android.media.Image
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

class TeamFragment : Fragment() {
    private lateinit var teamViewModel: TeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.team_fragment, container, false)
        val teamName: TextView = view.findViewById(R.id.team_name_value)
        val teamCountry: TextView = view.findViewById(R.id.team_country_value)
        val teamLogo: ImageView = view.findViewById(R.id.team_image)
        teamViewModel = ViewModelProvider(this)[TeamViewModel::class.java]
        teamViewModel.getTeam()

        teamViewModel.teamInfo.observe(viewLifecycleOwner, Observer {
            teamName.text = it.name
            teamCountry.text = it.country
//            val teamBitmap = teamViewModel.convertToBitmap(it.logo!!)
//            teamLogo.setImageBitmap(teamBitmap)
        })

        return view
    }

}