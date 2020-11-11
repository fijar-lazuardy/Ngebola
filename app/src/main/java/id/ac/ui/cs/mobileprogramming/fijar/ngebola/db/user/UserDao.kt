package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user

import androidx.room.Dao
import androidx.room.Query


@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE name=:name")
    fun getUserByName(name: String): User
}