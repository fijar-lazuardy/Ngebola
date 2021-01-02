package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.league

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.LeagueRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.Standing
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.model.Table
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LeagueViewModel(application: Application) : AndroidViewModel(application) {
    private val retrofit = RetrofitClient.RETROFIT_SERVICE
    val leagueInfo = MutableLiveData<League>()
    val standingInfo = MutableLiveData<List<Table>>()
    private val leagueRepository = LeagueRepository(application)

    fun getLeagueInfo() {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                leagueInfo.value = leagueRepository.getFirstLeagueInfo()
            }
            catch (e: Error) {
                Log.d("ERROR", "Error occurred")
            }
        }
    }

    fun getStandingInfo(league_id: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val standingResponse = retrofit.getStandingInfo(league_id).body()?.standings?.get(0)?.table?.take(5)
                standingInfo.value = standingResponse
            }
            catch (e: Error) {
                Log.d("ERROR", "Error occurred")
            }
        }
    }
    
}