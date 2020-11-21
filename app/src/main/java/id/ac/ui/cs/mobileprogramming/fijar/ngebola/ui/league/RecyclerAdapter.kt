package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.league

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.Standing

class RecyclerAdapter(internal var context: Context, internal var standingList: List<Standing>): RecyclerView.Adapter<RecyclerAdapter.StandingHolder>() {
    inner class StandingHolder(view: View): RecyclerView.ViewHolder(view) {
        val standingPos: TextView = view.findViewById(R.id.standing_pos_team)
        val teamName: TextView = view.findViewById(R.id.team_name_team)
        val winTeam: TextView = view.findViewById(R.id.win_holder_team)
        val drawTeam: TextView = view.findViewById(R.id.draw_holder_team)
        val loseTeam: TextView = view.findViewById(R.id.lose_holder_team)
        val gfTeam: TextView = view.findViewById(R.id.gf_holder_team)
        val gaTeam: TextView = view.findViewById(R.id.ga_holder_team)
        val gdTeam: TextView = view.findViewById(R.id.gd_holder_team)
        val pointTeam: TextView = view.findViewById(R.id.point_holder_team)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.standing_item, parent, false)
        return StandingHolder(itemView)
    }

    override fun getItemCount(): Int {
        return standingList.size
    }

    override fun onBindViewHolder(holder: StandingHolder, position: Int) {
        holder.standingPos.text = standingList[position].rank.toString()
        holder.teamName.text = standingList[position].teamName
        holder.winTeam.text = standingList[position].all?.win.toString()
        holder.drawTeam.text = standingList[position].all?.draw.toString()
        holder.loseTeam.text = standingList[position].all?.lose.toString()
        holder.gfTeam.text = standingList[position].all?.goalsFor.toString()
        holder.gaTeam.text = standingList[position].all?.goalsAgainst.toString()
        holder.gdTeam.text = standingList[position].goalsDiff.toString()
        holder.pointTeam.text = standingList[position].points.toString()
    }
}