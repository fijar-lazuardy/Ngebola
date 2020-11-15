package id.ac.ui.cs.mobileprogramming.fijar.ngebola.model

import com.google.gson.annotations.SerializedName

class LeagueModel {
    @SerializedName("api")
    var api: Api? = null
}

class Api {
    @SerializedName("leagues")
    var leagues: List<League>? = null
}

class League {
    @SerializedName("league_id")
    var leagueId: Int? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("country")
    var country: String? = null
    @SerializedName("season")
    var season: Int? = null
    @SerializedName("logo")
    var logo: String? = null
}