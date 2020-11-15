package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User

@Entity
data class Player(
    @PrimaryKey
    var player_id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "nationality")
    var nationality: String,
    @ColumnInfo(name = "birth_date")
    var birth_date: String
)