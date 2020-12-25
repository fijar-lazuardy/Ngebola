package id.ac.ui.cs.mobileprogramming.fijar.ngebola.model

import com.google.gson.annotations.SerializedName


class PlayerModel {
    @SerializedName("id")
    var playerId: Int? = null
    @SerializedName("name")
    var playerName: String? = null
    @SerializedName("nationality")
    var playerNationality: String? = null
}

