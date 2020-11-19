package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db

import android.app.Application
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.Player
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.PlayerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class PlayerRepository (application: Application): CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var playerDao: PlayerDao?

    init {
        val db = NgebolaDb.getDatabase(application)
        playerDao = db?.PlayerDao()
    }

    fun insertPlayer(player: Player) {
        playerDao?.insertPlayer(player)
    }

    suspend fun getPlayerInfo(): Player? {
        return playerDao?.getPlayer()?.get(0)
    }
}