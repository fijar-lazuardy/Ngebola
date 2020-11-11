package id.ac.ui.cs.mobileprogramming.fijar.ngebola.fragments.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import java.util.*

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.profile_fragment, container, false)
        val languageUsed = view?.findViewById<TextView>(R.id.preferred_lang)

        languageUsed?.text = Locale.getDefault().displayName.toString()
        return root
    }


}