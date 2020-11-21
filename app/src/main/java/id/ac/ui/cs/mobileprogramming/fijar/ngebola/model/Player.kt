package id.ac.ui.cs.mobileprogramming.fijar.ngebola.model

import com.google.gson.annotations.SerializedName


class PlayerModel {
    @SerializedName("api")
    var api: ApiPlayer? = null
}

class ApiPlayer {
    @SerializedName("players")
    var players: List<Player>? = null
}

class Player {
    @SerializedName("player_name")
    var playerName: String? = null
    @SerializedName("nationality")
    var nationality: String? = null
}

