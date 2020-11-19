package id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Handler
import androidx.core.app.JobIntentService
import androidx.core.app.NotificationCompat
import androidx.core.app.TaskStackBuilder
import androidx.core.content.getSystemService
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.MainActivity
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R

class NotifJobService: JobIntentService() {

    companion object {
        private val JOB_ID = 2

        fun enqueueWork(context: Context, intent: Intent) {
            enqueueWork(context, NotifJobService::class.java, JOB_ID, intent)
        }
    }

    override fun onHandleWork(intent: Intent) {
        createNotification(this)
        stopSelf()
    }

    fun createNotification(context: Context) {
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notifId = 1
        val channelId = "1"
        val channelName = "Channel notification name"
        val mChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
        ).let {
            it.enableLights(true)
            it.lightColor = Color.RED
            it.enableVibration(true)
            it.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 300, 200, 400)
            it
        }
        nm.createNotificationChannel(mChannel)

        val mBuilder = NotificationCompat.Builder(context, channelId)
                .setContentTitle(resources.getString(R.string.notification_title))
                .setContentText(resources.getString(R.string.notification_text))
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.ic_football_ball)

        val stackBuilder = TaskStackBuilder.create(context)
        stackBuilder.addNextIntent(Intent(context, MainActivity::class.java))
        val pendingIntent = stackBuilder.getPendingIntent(1, PendingIntent.FLAG_UPDATE_CURRENT)
        mBuilder.setContentIntent(pendingIntent)

        nm.notify(notifId, mBuilder.build())
    }
}