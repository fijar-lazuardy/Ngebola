package id.ac.ui.cs.mobileprogramming.fijar.ngebola

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification.Actions
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification.NotificationService
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification.ServiceState
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification.getServiceState
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver.HeadsetPlugReceiver

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_league,
            R.id.navigation_team,
            R.id.navigation_profile
        ).build()
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun actionOnService(action: Actions) {
        if (getServiceState(this) == ServiceState.STOPPED && action == Actions.STOP) return
        Intent(this, NotificationService::class.java).also {
            it.action = action.name
            startForegroundService(it)
            return
        }
    }
}