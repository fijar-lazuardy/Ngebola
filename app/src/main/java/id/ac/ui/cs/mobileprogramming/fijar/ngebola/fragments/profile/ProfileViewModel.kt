package id.ac.ui.cs.mobileprogramming.fijar.ngebola.fragments.profile

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ProfileViewModel : ViewModel() {
    val languageName = MutableLiveData<String>()

    fun getLanguage() {
        languageName.value = Locale.getDefault().displayName.toString()
    }
}