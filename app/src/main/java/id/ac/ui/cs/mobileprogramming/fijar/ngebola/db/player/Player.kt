package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class Player(
    @PrimaryKey(autoGenerate = true)
    var player_id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "nationality")
    var nationality: String,
    @ColumnInfo(name = "birth_date")
    var birth_date: String
)