package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.start

import android.content.Intent
import android.os.Bundle
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

class FirstFragment : Fragment() {
    private lateinit var viewModel: OnBoardingSharedViewModel
    private lateinit var sharedPrefManager: UserSharedPreferenceManager

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

        rgTeam.setOnCheckedChangeListener { _, checkedId ->
            teamId = if (checkedId.toString() == "liverpool_button") {
                40
            } else {
                541
            }
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
            viewModel.insertUserInfo(inputName.text.toString().trim(), leagueId)
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

}