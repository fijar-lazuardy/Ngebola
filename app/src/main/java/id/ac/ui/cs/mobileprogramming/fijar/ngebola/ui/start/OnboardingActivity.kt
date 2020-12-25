package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.start

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
        }
        val fragmentManager = supportFragmentManager.beginTransaction()
        fragmentManager.add(R.id.fragment_holder, FirstFragment())
        fragmentManager.commit()
        }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            }
            else {

            }
        }
    }
}