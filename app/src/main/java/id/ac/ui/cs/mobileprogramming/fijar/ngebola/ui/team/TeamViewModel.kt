package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.team

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.TeamRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.Team
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class TeamViewModel(application: Application): AndroidViewModel(application) {
    private val teamRepository = TeamRepository(application)
    val teamInfo = MutableLiveData<Team>()

    fun getTeam() {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                var team: Team?
                withContext(Dispatchers.IO) {
                    team = teamRepository.getTeamInfo()
                }
                teamInfo.value = team
            }
        }
    }

    fun convertToBitmap(stringImage: String): Bitmap {
        val decodedBytes = Base64.getDecoder().decode(stringImage)
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }
}