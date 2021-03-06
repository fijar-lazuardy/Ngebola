package id.ac.ui.cs.mobileprogramming.fijar.ngebola.retrofit

import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.LeagueModel
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.PlayerModel
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.StandingModel
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.TeamModel
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

    @GET("/players/player/{player_id}")
    suspend fun getPlayerInfo(@Path("player_id")player_id: Int): Response<PlayerModel>

    @GET("/teams/team/{team_id}")
    suspend fun getTeamInfo(@Path("team_id") team_id: Int): Response<TeamModel>
}