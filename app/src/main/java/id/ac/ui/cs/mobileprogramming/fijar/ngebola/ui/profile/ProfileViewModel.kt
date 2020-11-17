package id.ac.ui.cs.mobileprogramming.fijar.ngebola.ui.profile

import android.app.Application
import androidx.lifecycle.*
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.UserRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User
import kotlinx.coroutines.launch
import java.util.*

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    val languageName = MutableLiveData<String>()
    val userScreen = MutableLiveData<User>()
    val users = MutableLiveData<List<User>>()
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