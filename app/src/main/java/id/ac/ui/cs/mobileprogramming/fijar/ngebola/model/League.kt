package id.ac.ui.cs.mobileprogramming.fijar.ngebola.model

import com.google.gson.annotations.SerializedName

class LeagueModel {
    @SerializedName("id")
    var leagueId: Int? = null
    @SerializedName("area")
    var area: LeagueArea? = null
    @SerializedName("name")
    var leagueName: String? = null
}

class LeagueArea {
    @SerializedName("id")
    var areaId: Int? = null
    @SerializedName("name")
    var leagueCountry: String? = null
}