package id.ac.ui.cs.mobileprogramming.fijar.ngebola.retrofit

import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/league/{league_name}")
    fun searchLeagueByName(@Path("league_name") league_name:String): Call<League>
}