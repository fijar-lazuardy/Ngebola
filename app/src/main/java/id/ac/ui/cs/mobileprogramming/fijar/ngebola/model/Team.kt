package id.ac.ui.cs.mobileprogramming.fijar.ngebola.model

import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

class TeamModel {
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("area")
    var area: TeamArea? = null
    @SerializedName("name")
    var name: String? = null
}

class TeamArea {
    @SerializedName("id")
    var areaId: Int? = null
    @SerializedName("name")
    var teamCountry: String? = null
}