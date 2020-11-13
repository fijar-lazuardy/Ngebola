package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE name=:name")
    fun getUserByName(name: String): User

    @Query("SELECT * FROM users WHERE id=1")
    fun getUser(): User

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)
}