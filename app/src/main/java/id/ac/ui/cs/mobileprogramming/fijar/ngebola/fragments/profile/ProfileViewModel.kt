package id.ac.ui.cs.mobileprogramming.fijar.ngebola.fragments.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.UserRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import kotlinx.coroutines.launch
import java.util.*

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val languageName = MutableLiveData<String>()
    val userScreen = MutableLiveData<User>()
    private var repository: UserRepository = UserRepository(application)

    fun getUser() {
//        repository.getUserByName()
        viewModelScope.launch {
            userScreen.value = repository.getUserByNameBg()
        }
    }

    fun insertUser(name: String) {
        val user = User(name = name)
        repository.insertUser(user)
    }

    fun getLanguage() {
        languageName.value = Locale.getDefault().displayName.toString()
    }
}