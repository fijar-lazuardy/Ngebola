package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db

import androidx.room.Database
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.LeagueDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.Player
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.PlayerDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.Team
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.TeamDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.UserDao

@Database(entities = [User::class, Player::class, Team::class, League::class], version = 1, exportSchema = false)
abstract class NgebolaRepository {
    abstract fun UserDao(): UserDao
    abstract fun PlayerDao(): PlayerDao
    abstract fun TeamDao(): TeamDao
    abstract fun LeagueDao(): LeagueDao



}