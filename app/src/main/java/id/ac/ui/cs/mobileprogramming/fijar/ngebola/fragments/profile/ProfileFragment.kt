package id.ac.ui.cs.mobileprogramming.fijar.ngebola.fragments.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import java.util.*

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)
        val userName: TextView = view.findViewById(R.id.user_name)
        val languageUsed: TextView = view.findViewById(R.id.preferred_lang)

        profileViewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]
        profileViewModel.getUser()
        profileViewModel.getLanguage()

        profileViewModel.userScreen.observe(viewLifecycleOwner, Observer<User> {
            userName?.text = it?.name
        })

        profileViewModel.languageName.observe(viewLifecycleOwner, Observer {
            languageUsed?.text = it
        })

        return view
    }
}