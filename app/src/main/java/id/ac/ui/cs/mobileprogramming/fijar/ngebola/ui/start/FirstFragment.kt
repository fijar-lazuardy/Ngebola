package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.start

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Bundle
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
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.shared_preferences.UserSharedPreferenceManager
import java.lang.Exception

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
        val rgTeam: RadioGroup = view.findViewById(R.id.team_button)
        val rgLeague: RadioGroup = view.findViewById(R.id.league_button)
        val rgPlayer: RadioGroup = view.findViewById(R.id.player_button)
        val progressBar: ProgressBar = view.findViewById(R.id.progressBar)
        val loadingScreen: RelativeLayout = view.findViewById(R.id.loading_screen)
        val uploadImageBtn: Button = view.findViewById(R.id.choose_picture)
        image = view.findViewById(R.id.user_image)

        rgTeam.setOnCheckedChangeListener { _, checkedId ->
            teamId = if (checkedId.toString() == "liverpool_button") {
                40
            } else {
                541
            }
        }
        uploadImageBtn.setOnClickListener {
            uploadImage()
        }

        rgLeague.setOnCheckedChangeListener { _, checkedId ->
            leagueId = if (checkedId.toString() == "epl_button") {
                2790
            } else {
                2833
            }
        }

        rgPlayer.setOnCheckedChangeListener { _, checkedId ->
            playerId = if (checkedId.toString() == "salah_button") {
                306
            } else {
                186
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
//            viewModel.inputUserInfo(inputName.text.toString().trim())
            viewModel.insertUserInfo(inputName.text.toString().trim(), leagueId, bitmap)
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
    fun uploadImage() {
        var intent = Intent(Intent.ACTION_PICK)
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
                Toast.makeText(activity, "masuk sini", Toast.LENGTH_SHORT).show()
                imageUri = data?.data!!
//                val photo: Bitmap = data?.extras?.get("data") as Bitmap
//                val photo: Bitmap = MediaStore.Images.Media.bi
                val source: ImageDecoder.Source = ImageDecoder.createSource(activity?.contentResolver!!, imageUri)
                bitmap = ImageDecoder.decodeBitmap(source)
                image.setImageBitmap(bitmap)
                image.contentDescription = "User's profile picture"
            }
            catch (e: Exception) {

            }
        }
    }

}