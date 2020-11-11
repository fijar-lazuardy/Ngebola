package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class League (
    @PrimaryKey var league_id: String,
    val name: String,
    val country: String,
    val season: Int,
    val logo: String
)