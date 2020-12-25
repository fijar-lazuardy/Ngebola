package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "team")
data class Team (
    @PrimaryKey var team_id: Int,
    val name: String?,
    val country: String?
): Serializable