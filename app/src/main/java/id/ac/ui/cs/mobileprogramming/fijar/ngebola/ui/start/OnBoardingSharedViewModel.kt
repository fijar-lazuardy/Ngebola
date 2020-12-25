package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.start

import android.app.Application
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.renderscript.ScriptGroup
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.LeagueRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.PlayerRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.TeamRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.UserRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.Player
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.Team
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.external.AgeCategory
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.URL
import java.util.*

class OnBoardingSharedViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var user: User
    private lateinit var league: League
    private lateinit var player: Player
    private lateinit var team: Team
    private val userRepository = UserRepository(application)
    private val leagueRepository = LeagueRepository(application)
    private val playerRepository = PlayerRepository(application)
    private val teamRepository = TeamRepository(application)
    private val ageCategory = AgeCategory()
    private val retrofit = RetrofitClient.RETROFIT_SERVICE
    val isDoneLoading = MutableLiveData<Boolean>()

    fun insertUserInfo(name: String, age: Int, league_id: Int, image: Bitmap, playerId: Int, teamId: Int) {
        isDoneLoading.value = false
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                val imageString = convertBitmap(image)
                val userCategory = ageCategory.categorizedAge(age)
                user = User(name = name, leagueId = league_id, image = imageString, ageCategory = userCategory)
                userRepository.insertUser(user)

                val leagueResponse = retrofit.getLeagueInfoAsync(league_id).body()
                league = League(league_id = leagueResponse?.leagueId,
                        name = leagueResponse?.leagueName,
                        country = leagueResponse?.area?.leagueCountry)
                leagueRepository.insertLeague(league)

                val teamResponse = retrofit.getTeamInfo(teamId).body()
                team = Team(
                        team_id = teamId,
                        name = teamResponse?.name,
                        country = teamResponse?.area?.teamCountry
                )
                teamRepository.insertTeam(team)

                val playerResponse = retrofit.getPlayerInfo(playerId).body()
                player = Player(
                        player_id = playerId,
                        name = playerResponse?.playerName,
                        nationality = playerResponse?.playerNationality
                )
                playerRepository.insertPlayer(player)
            }
            isDoneLoading.value = true
        }
    }

    private fun convertBitmap(bitmap: Bitmap): String {
        val bos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos)
        return Base64.getEncoder().encodeToString(bos.toByteArray())
    }
}