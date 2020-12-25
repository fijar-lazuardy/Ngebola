package id.ac.ui.cs.mobileprogramming.fijar.ngebola.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class StandingModel {
    @SerializedName("standings")
    var standings: List<Standing>? = null
}

class Standing {
    @SerializedName("table")
    var table: List<Table>? = null
}

class Table {
    @SerializedName("position")
    var position: Int? = null
    @SerializedName("team")
    var standingTeam: StandingTeam? = null
    @SerializedName("playedGames")
    var playedGames: Int? = null
    @SerializedName("won")
    var gamesWon: Int? = null
    @SerializedName("draw")
    var gamesDraw: Int? = null
    @SerializedName("lost")
    var gamesLost: Int? = null
    @SerializedName("points")
    var teamPoints: Int? = null
    @SerializedName("goalsFor")
    var goalsFor: Int? = null
    @SerializedName("goalsAgainst")
    var goalsAgainst: Int? = null
    @SerializedName("goalDifference")
    var goalDifference: Int? = null
}

class StandingTeam {
    @SerializedName("name")
    var standingTeamName: String? = null
}