package id.ac.ui.cs.mobileprogramming.fijar.ngebola

import android.app.AlarmManager
import android.app.PendingIntent
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
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver.MorningReceiver
import java.lang.Exception
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        try {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, 10)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(this, MorningReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 100, intent, PendingIntent.FLAG_CANCEL_CURRENT)
            alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
            Toast.makeText(applicationContext, calendar.toString(), Toast.LENGTH_SHORT).show()
        }
        catch (e: Exception) {
            Toast.makeText(applicationContext, "GAGAL ANJINGGG", Toast.LENGTH_SHORT).show()
        }

        val appBarConfiguration = AppBarConfiguration.Builder(
            R.id.navigation_home,
            R.id.navigation_league,
            R.id.navigation_team,
            R.id.navigation_profile
        ).build()
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}
