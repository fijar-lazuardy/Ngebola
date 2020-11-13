package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db

import android.app.Application
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.LeagueDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.PlayerDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.TeamDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class UserRepository(application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var userDao: UserDao?

    init {
        val db = NgebolaDb.getDatabase(application)
        userDao = db?.UserDao()
    }

    fun getUserByName() = userDao?.getUser()

    fun insertUser(user: User) {
        launch {
            insertUserBg(user)
        }
    }

    private suspend fun insertUserBg(user: User) {
        withContext(Dispatchers.IO) {
            userDao?.insertUser(user)
        }
    }


}