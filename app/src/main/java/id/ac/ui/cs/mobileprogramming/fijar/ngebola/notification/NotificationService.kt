package id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaParser.SeekPoint.START
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.PowerManager
import android.support.v4.media.session.PlaybackStateCompat
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.getSystemService
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.MainActivity
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class NotificationService : Service() {
    private val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    private var mHandler: Handler? = null
    private var mTimer: Timer? = null
    private var wakeLock: PowerManager.WakeLock? = null

    private var isServiceStarted = false

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        if (intent != null) {
            when (intent.action) {
                Actions.START.name -> startService()
                Actions.STOP.name -> stopService()
            }
        }
        return START_STICKY
    }

    override fun onCreate() {
        super.onCreate()
        var notification = createNotification()
        startNotificationListener()
//        startForeground(1, notification)
    }

    fun startNotificationListener() {
        Thread(Runnable {
            showNotification()
        })
    }

    private fun showNotification() {
        val nm = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val notif = createNotification()
        nm.notify(0, notif)

    }

    private fun createNotification(): Notification? {
        val notificationChannelId = "ENDLESS SERVICE CHANNEL"
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager;
        val channel = NotificationChannel(
                notificationChannelId,
                "Endless Service notifications channel",
                NotificationManager.IMPORTANCE_DEFAULT
        ).let {
            it.description = "Endless Service channel"
            it.enableLights(true)
            it.lightColor = Color.RED
            it.enableVibration(true)
            it.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            it
        }
        notificationManager.createNotificationChannel(channel)
        val pendingIntent: PendingIntent = Intent(this, MainActivity::class.java).let { notificationIntent ->
            PendingIntent.getActivity(this, 0, notificationIntent, 0)
        }

        val builder: Notification.Builder = Notification.Builder(this, notificationChannelId)
        var notifBuilder = NotificationCompat.Builder(
                this,
                notificationChannelId
        ).setSmallIcon(R.drawable.ic_football_ball)
                .setContentTitle("Top of morning!")
                .setContentText("Cheecck")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build()

//        return builder
//                .setContentTitle("Top of morning!")
//                .setContentText("Checkout newest standing of your choice!")
//                .setContentIntent(pendingIntent)
//                .setSmallIcon(R.mipmap.ic_launcher_ball)
//                .setTicker("Ticker text")
//                .setAutoCancel(true)
//                .build()
        return notifBuilder
    }


    private fun startService() {
        if (isServiceStarted) return
        setServiceState(this, ServiceState.STARTED)
        wakeLock =
                (getSystemService(Context.POWER_SERVICE) as PowerManager).run {
                    newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "EndlessService::lock").apply {
                        acquire(10*60*1000L /*10 minutes*/)
                    }
                }

        // we're starting a loop in a coroutine
        GlobalScope.launch(Dispatchers.IO) {
            while (isServiceStarted) {
                launch(Dispatchers.IO) {
                    Toast.makeText(applicationContext, "Cek service", Toast.LENGTH_SHORT).show()
                }
                delay(1 * 15 * 1000)
            }
        }
    }

    private fun stopService() {

    }

}