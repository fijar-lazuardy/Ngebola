package id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.notification.NotifJobService

class MorningReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val serviceIntent = Intent(context, NotifJobService::class.java)
        NotifJobService.enqueueWork(context!!, serviceIntent)
    }
}