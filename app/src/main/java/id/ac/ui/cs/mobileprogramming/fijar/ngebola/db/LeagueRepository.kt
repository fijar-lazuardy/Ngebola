package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db

import android.app.Application
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.LeagueDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class LeagueRepository(application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var leagueDao: LeagueDao?

    init {
        val db = NgebolaDb.getDatabase(application)
        leagueDao = db?.LeagueDao()
    }

    fun insertLeague(league: League) {
        leagueDao?.insertLeague(league)
    }


    suspend fun getFirstLeagueInfo(): League? {
        var league: League?
        withContext(Dispatchers.IO) {
            league = leagueDao?.getAllLeague()?.get(0)
        }
        return league
    }
}