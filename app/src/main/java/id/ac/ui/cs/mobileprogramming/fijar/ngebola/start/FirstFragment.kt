package id.ac.ui.cs.mobileprogramming.fijar.ngebola.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private lateinit var viewModel: OnBoardingSharedViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(requireActivity())[OnBoardingSharedViewModel::class.java]
        val view =  inflater.inflate(R.layout.fragment_first, container, false)
        val inputName: EditText = view.findViewById(R.id.name_input_placeholder)
        val button: Button = view.findViewById(R.id.next_button)
        button.setOnClickListener {

        }
        return view
    }

}