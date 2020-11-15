package id.ac.ui.cs.mobileprogramming.fijar.ngebola.retrofit

import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.LeagueModel
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.StandingModel
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/leagues/league/{league_id}")
    suspend fun getLeagueInfoAsync(@Path("league_id") league_id:Int): Response<LeagueModel>

    @GET("/leagueTable/{league_id}")
    suspend fun getStandingInfo(@Path("league_id") league_id: Int): Response<StandingModel>
}