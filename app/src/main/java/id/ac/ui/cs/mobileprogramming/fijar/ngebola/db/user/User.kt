package id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
        var name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 1
}

