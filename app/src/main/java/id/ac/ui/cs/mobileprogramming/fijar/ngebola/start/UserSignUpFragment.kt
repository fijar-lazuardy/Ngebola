package id.ac.ui.cs.mobileprogramming.fijar.ngebola.start

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R

class UserSignUpFragment : Fragment() {

    companion object {
        fun newInstance() = UserSignUpFragment()
    }

    private lateinit var viewModel: OnBoardingSharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(OnBoardingSharedViewModel::class.java)
        return inflater.inflate(R.layout.user_sign_up_fragment, container, false)
    }


}