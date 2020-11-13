package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface LeagueDao {
    @Query("SELECT * FROM league")
    suspend fun getAllLeague(): List<League>

    @Query("SELECT * FROM league WHERE league_id=:league_id")
    suspend fun getLeagueById(league_id: String): League

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLeague(league_id: String)
}