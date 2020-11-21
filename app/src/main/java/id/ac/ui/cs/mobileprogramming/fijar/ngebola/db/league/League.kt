package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class League (
    @PrimaryKey var league_id: Int?,
    val name: String?,
    val country: String?,
    val season: Int?
): Serializable