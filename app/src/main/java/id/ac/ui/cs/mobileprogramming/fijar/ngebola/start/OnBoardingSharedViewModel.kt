package id.ac.ui.cs.mobileprogramming.fijar.ngebola.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.UserRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User

class OnBoardingSharedViewModel(application: Application) : AndroidViewModel(application) {
    private lateinit var user: User
    private val userRepository = UserRepository(application)

    fun inputUserInfo(name: String) {
        user = User(name = name)
        userRepository.insertUser(user)
    }
}