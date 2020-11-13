package id.ac.ui.cs.mobileprogramming.fijar.ngebola.start

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.MainActivity
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.shared_preferences.UserSharedPreferenceManager

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPref = UserSharedPreferenceManager(applicationContext)
        if (!sharedPref.isFirstTime()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        setContentView(R.layout.activity_onboarding)
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.add(R.id.fragment_holder, FirstFragment())
        fragmentManager.commit()
        }
}