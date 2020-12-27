package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.profile

import android.graphics.Bitmap
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User

class ProfileFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.profile_fragment, container, false)
        val userName: TextView = view.findViewById(R.id.user_name)
        val userImage: ImageView = view.findViewById(R.id.user_image_detail)
        val languageUsed: TextView = view.findViewById(R.id.preferred_lang)
        val userCategory: TextView = view.findViewById(R.id.category_value)

        profileViewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        profileViewModel.getUser()
        profileViewModel.getLanguage()

        profileViewModel.userScreen.observe(viewLifecycleOwner, Observer<User> {
            userName.text = it?.name
            val bitmap: Bitmap = profileViewModel.convertToBitmap(it?.image!!)
            userImage.setImageBitmap(bitmap)
            userCategory.text = it.ageCategory
        })

        profileViewModel.languageName.observe(viewLifecycleOwner, Observer {
            languageUsed.text = it
        })
        return view
    }
}