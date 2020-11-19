package id.ac.ui.cs.mobileprogramming.fijar.ngebola.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

class TeamModel {
    @SerializedName("api")
    var api: ApiTeam? = null
}

class ApiTeam {
    @SerializedName("teams")
    var teams: List<Team>? = null
}

class Team {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("country")
    var country: String? = null

    @SerializedName("logo")
    var logo: String? = null
}