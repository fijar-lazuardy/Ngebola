package id.ac.ui.cs.mobileprogramming.fijar.ngebola.start

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.UserRepository
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.User

class OnBoardingSharedViewModel : ViewModel() {
    private lateinit var user: User
    val userRepository = UserRepository(Application())

    fun inputUser(name: String) {
        user = User(name = name)
        userRepository.insertUser(user)
    }
}