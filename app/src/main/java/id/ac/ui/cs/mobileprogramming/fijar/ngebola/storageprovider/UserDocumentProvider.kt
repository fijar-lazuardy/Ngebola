package id.ac.ui.cs.mobileprogramming.fijar.ngebola.storageprovider

import android.content.UriMatcher
import android.database.Cursor
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.provider.DocumentsProvider
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.NgebolaDb
import id.ac.ui.cs.mobileprogramming.fijar.ngebola.db.user.UserDao

class UserDocumentProvider: DocumentsProvider() {
    val TAG: String = this.javaClass.name
    val AUTHORITY: String = "id.ac.ui.cs.mobileprogramming.fijar.ngebola.storageprovider.documents"
    val USER_TABLE_NAME: String = "user_info"
    val ID_USER_DATA: Int = 1
    val ID_USER_DATA_ITEM: Int = 2
    val uriMatcher: UriMatcher = UriMatcher(UriMatcher.NO_MATCH)
    

    private lateinit var userDao: UserDao
    override fun openDocument(documentId: String?, mode: String?, signal: CancellationSignal?): ParcelFileDescriptor {
        TODO("Not yet implemented")
    }

    override fun queryChildDocuments(parentDocumentId: String?, projection: Array<out String>?, sortOrder: String?): Cursor {
        TODO("Not yet implemented")
    }

    override fun queryDocument(documentId: String?, projection: Array<out String>?): Cursor {
        TODO("Not yet implemented")
    }

    override fun onCreate(): Boolean {
        userDao = NgebolaDb.getDatabase(context!!)!!.userDao()
        return false
    }

    override fun queryRoots(projection: Array<out String>?): Cursor {
        TODO("Not yet implemented")
    }

}