package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db

import android.app.Application
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.UserDao
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.UserOnlyDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class UserRepository(application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var userOnlyDao: UserOnlyDao?
    private var userDao: UserDao?

    init {
        val db = NgebolaDb.getDatabase(application)
        userOnlyDao = db?.userOnlyDao()
        userDao = db?.userDao()
    }

    suspend fun getUserByNameBg(): User? {
        var user: User?
        withContext(Dispatchers.IO) {
            user = userOnlyDao?.getUser()
        }
        return user
    }

    fun insertUser(user: User) {
//        launch {
//            insertUserBg(user)
//        }
        userOnlyDao?.insertUser(user)
    }

    private suspend fun insertUserBg(user: User) {
        withContext(Dispatchers.IO) {
            userOnlyDao?.insertUser(user)
        }
    }

//    fun insertUser(user: User, league: League) {
////        launch {
////        insertUserBg(user, league)
////        }
//        userDao?.insertUserWithLeague(user, league)
//    }
//
//    private suspend fun insertUserBg(user: User, league: League) {
//        withContext(Dispatchers.IO) {
//            userDao?.insertUserWithLeague(user, league)
//        }
//    }


}