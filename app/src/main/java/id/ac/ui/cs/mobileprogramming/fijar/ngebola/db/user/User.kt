package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user

import androidx.room.*
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.Player
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.Team
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.Standing

@Entity(tableName = "users")
data class User(
        var name: String
        ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}