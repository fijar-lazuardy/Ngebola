package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.fragments.league

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League

class LeagueFragment : Fragment() {

    private lateinit var leagueViewModel: LeagueViewModel

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

        val standingPosOne: TextView = view.findViewById(R.id.standing_pos_one)
        val teamNameOne: TextView = view.findViewById(R.id.team_name_one)
        val winTeamOne: TextView = view.findViewById(R.id.win_holder_one)
        val drawTeamOne: TextView = view.findViewById(R.id.draw_holder_one)
        val loseTeamOne: TextView = view.findViewById(R.id.lose_holder_one)
        val gfTeamOne: TextView = view.findViewById(R.id.gf_holder_one)
        val gaTeamOne: TextView = view.findViewById(R.id.ga_holder_one)
        val gdTeamOne: TextView = view.findViewById(R.id.gd_holder_one)

        val standingPosTwo: TextView = view.findViewById(R.id.standing_pos_two)
        val teamNameTwo: TextView = view.findViewById(R.id.team_name_two)
        val winTeamTwo: TextView = view.findViewById(R.id.win_holder_two)
        val drawTeamTwo: TextView = view.findViewById(R.id.draw_holder_two)
        val loseTeamTwo: TextView = view.findViewById(R.id.lose_holder_two)
        val gfTeamTwo: TextView = view.findViewById(R.id.gf_holder_two)
        val gaTeamTwo: TextView = view.findViewById(R.id.ga_holder_two)
        val gdTeamTwo: TextView = view.findViewById(R.id.gd_holder_two)

        val standingPosThree: TextView = view.findViewById(R.id.standing_pos_three)
        val teamNameThree: TextView = view.findViewById(R.id.team_name_three)
        val winTeamThree: TextView = view.findViewById(R.id.win_holder_three)
        val drawTeamThree: TextView = view.findViewById(R.id.draw_holder_three)
        val loseTeamThree: TextView = view.findViewById(R.id.lose_holder_three)
        val gfTeamThree: TextView = view.findViewById(R.id.gf_holder_three)
        val gaTeamThree: TextView = view.findViewById(R.id.ga_holder_three)
        val gdTeamThree: TextView = view.findViewById(R.id.gd_holder_three)


        leagueViewModel.standingInfo.observe(viewLifecycleOwner, Observer {
            standingPosOne.text = it[0].rank.toString()
            teamNameOne.text = it[0].teamName.toString()
            winTeamOne.text = it[0].all?.win.toString()
            drawTeamOne.text = it[0].all?.draw.toString()
            loseTeamOne.text = it[0].all?.lose.toString()
            gfTeamOne.text = it[0].all?.goalsFor.toString()
            gaTeamOne.text = it[0].all?.goalsAgainst.toString()
            gdTeamOne.text = it[0].goalsDiff.toString()

            standingPosTwo.text = it[1].rank.toString()
            teamNameTwo.text = it[1].teamName.toString()
            winTeamTwo.text = it[1].all?.win.toString()
            drawTeamTwo.text = it[1].all?.draw.toString()
            loseTeamTwo.text = it[1].all?.lose.toString()
            gfTeamTwo.text = it[1].all?.goalsFor.toString()
            gaTeamTwo.text = it[1].all?.goalsAgainst.toString()
            gdTeamTwo.text = it[1].goalsDiff.toString()

            standingPosThree.text = it[2].rank.toString()
            teamNameThree.text = it[2].teamName.toString()
            winTeamThree.text = it[2].all?.win.toString()
            drawTeamThree.text = it[2].all?.draw.toString()
            loseTeamThree.text = it[2].all?.lose.toString()
            gfTeamThree.text = it[2].all?.goalsFor.toString()
            gaTeamThree.text = it[2].all?.goalsAgainst.toString()
            gdTeamThree.text = it[2].goalsDiff.toString()
        })

        return view
    }


}