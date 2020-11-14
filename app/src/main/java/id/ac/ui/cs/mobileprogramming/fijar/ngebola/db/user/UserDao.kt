package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE name=:name")
    fun getUserByName(name: String): User

    @Query("SELECT * FROM users WHERE name='kontol'")
    fun getUser(): User

    @Query("SELECT * FROM users")
    fun getAllUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)
}