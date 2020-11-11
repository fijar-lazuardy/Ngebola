package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User

@Entity(foreignKeys = [ForeignKey(entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("user_id"),
        onDelete = ForeignKey.CASCADE)],
        tableName = "player")
data class Player(
    @PrimaryKey
    var player_id: Int,
    @ColumnInfo(name = "user_id")
    var userId: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "nationality")
    var nationality: String,
    @ColumnInfo(name = "birth_date")
    var birth_date: String
)