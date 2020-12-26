package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.start

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity.RESULT_OK
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.os.health.PackageHealthStats
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.MainActivity
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.external.AgeCategory
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.receiver.MorningReceiver
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.shared_preferences.UserSharedPreferenceManager
import java.lang.Exception
import java.util.*
import java.util.jar.Manifest

class FirstFragment : Fragment() {
    private lateinit var viewModel: OnBoardingSharedViewModel
    private lateinit var sharedPrefManager: UserSharedPreferenceManager
    private val GALLERY_REQUEST_CODE = 1
    private lateinit var image: ImageView
    private lateinit var imageUri: Uri
    private lateinit var bitmap: Bitmap

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity())[OnBoardingSharedViewModel::class.java]
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        var teamId = 40
        var leagueId = 2790
        var playerId = 306

        val button: Button = view.findViewById(R.id.next_button)
        val inputName: EditText = view.findViewById(R.id.name_input_placeholder)
        val inputAge: EditText = view.findViewById(R.id.age_input_placeholder)
        val rgTeam: RadioGroup = view.findViewById(R.id.team_button)
        val rgLeague: RadioGroup = view.findViewById(R.id.league_button)
        val rgPlayer: RadioGroup = view.findViewById(R.id.player_button)
        val loadingScreen: RelativeLayout = view.findViewById(R.id.loading_screen)
        val uploadImageBtn: Button = view.findViewById(R.id.choose_picture)
        image = view.findViewById(R.id.user_image)

        rgTeam.setOnCheckedChangeListener { _, checkedId ->
            teamId = if (checkedId.toString() == "liverpool_button") {
                64 // Liverpool
            } else {
                86 // Real Madrid
            }
        }
        uploadImageBtn.setOnClickListener {
            chooseImageFromGallery()
        }

        rgLeague.setOnCheckedChangeListener { _, checkedId ->
            leagueId = if (checkedId.toString() == "epl_button") {
                2021 // EPL
            } else {
                2014 //Spain Primera Division
            }
        }

        rgPlayer.setOnCheckedChangeListener { _, checkedId ->
            playerId = if (checkedId.toString() == "salah_button") {
                3754 // M Salah
            } else {
                3653 // Hazard
            }
        }
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                button.isEnabled = s.toString() != ""
            }
        }
        inputName.addTextChangedListener(textWatcher)
        button.setOnClickListener {
            loadingScreen.visibility = View.VISIBLE
            sharedPrefManager = UserSharedPreferenceManager(requireContext())
            sharedPrefManager.setFirstTime(false)
            viewModel.insertUserInfo(inputName.text.toString().trim(), inputAge.text.toString().toInt() ,leagueId, bitmap, playerId, teamId)
            setNotification()
            viewModel.isDoneLoading.observe(viewLifecycleOwner, Observer {
                if (it == true) {
                    loadingScreen.visibility = View.GONE
                    val intent = Intent(activity, MainActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                }
            })
        }
        return view
    }

    private fun chooseImageFromGallery() {

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        val mimeTypes = arrayOf("image/jpeg", "image/png")
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
        startActivityForResult(intent, GALLERY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            try {
                imageUri = data?.data!!
                val source: ImageDecoder.Source = ImageDecoder.createSource(activity?.contentResolver!!, imageUri)
                bitmap = ImageDecoder.decodeBitmap(source)
                image.setImageBitmap(bitmap)
                image.contentDescription = "User's profile picture"
            }
            catch (e: Exception) {
            }
        }
    }

    private fun setNotification() {
        try {
            val calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, 8)
            calendar.set(Calendar.MINUTE, 30)
            calendar.set(Calendar.SECOND, 0)
            if (calendar.timeInMillis < System.currentTimeMillis()) {
                calendar.add(Calendar.DAY_OF_YEAR, 1)
            }
            val alarmManager = activity?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(requireContext(), MorningReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(requireContext(), 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)
            val delay: Long = 24 * 60 * 60 * 1000
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, delay, pendingIntent)
        }
        catch (e: Exception) {
            Toast.makeText(requireContext(), "Notification failed", Toast.LENGTH_SHORT).show()
        }
    }
}