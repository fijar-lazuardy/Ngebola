package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db

import android.app.Application
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.Team
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.TeamDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class TeamRepository(application: Application): CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var teamDao: TeamDao?

    init {
        val db = NgebolaDb.getDatabase(application)
        teamDao = db?.TeamDao()
    }

    fun insertTeam(team: Team) {
        teamDao?.insertTeam(team)
    }

    suspend fun getTeamInfo(): Team? {
        return teamDao?.getTeam()?.get(0)
    }
}