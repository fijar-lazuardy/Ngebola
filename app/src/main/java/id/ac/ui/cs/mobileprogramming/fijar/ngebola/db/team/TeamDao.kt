package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team

import androidx.room.Dao
import androidx.room.Query


@Dao
interface TeamDao {
    @Query("SELECT * FROM team WHERE team_id=:teamId")
    fun getTeamById(teamId: String): Team
}