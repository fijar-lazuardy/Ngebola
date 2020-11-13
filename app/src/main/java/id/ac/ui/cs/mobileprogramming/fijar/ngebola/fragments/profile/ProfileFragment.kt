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
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import java.util.*

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)
        profileViewModel = ViewModelProvider(requireActivity())[ProfileViewModel::class.java]
        val languageUsed = view?.findViewById<TextView>(R.id.preferred_lang)

        val card = view?.findViewById<Button>(R.id.button)
        Toast.makeText(context, card.toString(), Toast.LENGTH_LONG).show()
        val userName = view?.findViewById<TextView>(R.id.user_name)
        card?.setOnClickListener {
            Log.d("DEBUG", "KLIK TOMBOL KIRI")
            Toast.makeText(context, "TOMBOL KIRI", Toast.LENGTH_LONG).show()
            profileViewModel.insertUser("kontol")
        }

        val cardLang = view?.findViewById<Button>(R.id.button2)

        cardLang?.setOnClickListener {
            Log.d("DEBUG", "KLIK TOMBOL KANAN")
            Toast.makeText(context, "TOMBOL KANAN", Toast.LENGTH_LONG).show()
            profileViewModel.getUser()
        }
        profileViewModel.userScreen.observe(viewLifecycleOwner, Observer<User> {
            userName?.text = it.name
        })


        languageUsed?.text = Locale.getDefault().displayName.toString()
        return view
    }


}