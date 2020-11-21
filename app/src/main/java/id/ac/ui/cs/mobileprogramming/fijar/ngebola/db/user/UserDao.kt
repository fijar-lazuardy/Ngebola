package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.*
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.league.League
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.player.Player
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.team.Team
import java.io.ByteArrayOutputStream
import java.util.*

@Dao
abstract class UserDao {
    @Query("SELECT * FROM users WHERE name=:name")
    abstract fun getUserByName(name: String): User

    @Query("SELECT * FROM users WHERE id=1")
    abstract fun getUser(): User

    @Query("SELECT * FROM users")
    abstract fun getAllUser(): List<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user: User)
    }
