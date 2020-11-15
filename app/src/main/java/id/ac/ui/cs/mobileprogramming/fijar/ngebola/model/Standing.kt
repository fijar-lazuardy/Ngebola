package id.ac.ui.cs.mobileprogramming.fijar.ngebola.model

import com.google.gson.annotations.SerializedName

class StandingModel {
    @SerializedName("api")
    var api: ApiStanding? = null
}

class ApiStanding {
    @SerializedName("standings")
    var standings: List<List<Standing>>? = null
}

class Standing {
    @SerializedName("rank")
    var rank: Int? = null
    @SerializedName("teamName")
    var teamName: String? = null
    @SerializedName("all")
    var all: All? = null
    @SerializedName("goalsDiff")
    var goalsDiff: Int? = null
    @SerializedName("points")
    var points: Int? = null
}

class All {
    @SerializedName("matchsPlayed")
    var matchsPlayed: String? = null
    @SerializedName("win")
    var win: Int? = null
    @SerializedName("draw")
    var draw: Int? = null
    @SerializedName("lose")
    var lose: Int? = null
    @SerializedName("goalsFor")
    var goalsFor: Int? = null
    @SerializedName("goalsAgainst")
    var goalsAgainst: Int? = null
}