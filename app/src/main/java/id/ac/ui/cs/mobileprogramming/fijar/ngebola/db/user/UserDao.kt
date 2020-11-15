package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.Player
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.Team

@Dao
abstract class UserDao {
    @Query("SELECT * FROM users WHERE name=:name")
    abstract fun getUserByName(name: String): User

    @Query("SELECT * FROM users WHERE id=1")
    abstract fun getUser(): User

    @Query("SELECT * FROM users")
    abstract fun getAllUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user: User)

//    fun insertUserWithLeague(user: User, league: League, player: Player, team: Team) {
//        user.league = league
//        user.player = player
//        user.team = team
//    }
}