package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamDao {
    @Query("SELECT * FROM team WHERE team_id=:teamId")
    suspend fun getTeamById(teamId: String): Team

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(team: Team)
}