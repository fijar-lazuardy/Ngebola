package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        @PrimaryKey(autoGenerate = true) val id: Long,
        var name: String
)

