package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.PlayerRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.Player
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    val playerRepository = PlayerRepository(application)
    val playerInfo = MutableLiveData<Player>()

    fun getPlayer() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                var player: Player?
                withContext(Dispatchers.IO) {
                    player = playerRepository.getPlayerInfo()
                }
                playerInfo.value = player
            }

        }
    }
}