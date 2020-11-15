package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player WHERE player_id = :player_id")
    suspend fun getPlayerById(player_id: String): Player

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayer(player: Player)
}