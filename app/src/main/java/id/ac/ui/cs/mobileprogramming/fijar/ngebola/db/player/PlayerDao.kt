package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player

import androidx.room.Dao
import androidx.room.Query

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player WHERE player_id = :player_id")
    fun getPlayerById(player_id: String): Player

    
}