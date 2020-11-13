package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.LeagueDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.Player
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.PlayerDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.Team
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.TeamDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.UserDao

@Database(entities = [User::class, League::class, Player::class, Team::class], version = 1, exportSchema = false)
abstract class NgebolaDb : RoomDatabase() {
    abstract fun UserDao(): UserDao
//    abstract fun LeagueDao(): LeagueDao
//    abstract fun PlayerDao(): PlayerDao
//    abstract fun TeamDao(): TeamDao

    companion object {
        @Volatile
        private var INSTANCE: NgebolaDb? = null

        fun getDatabase(context: Context): NgebolaDb? {
            if (INSTANCE == null) {
                synchronized(NgebolaDb::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            NgebolaDb::class.java, "ngebola_db"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}