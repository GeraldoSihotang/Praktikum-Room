package id.ac.unhas.praktikum_room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class NoteDb : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {

        private const val DB_NAME = "NOTE_DB"
        private var instance: NoteDb? = null

        fun getInstance(context: Context): NoteDb? {
            if (instance == null) {
                synchronized(NoteDb::class) {
                    instance = Room
                        .databaseBuilder(
                            context,
                            NoteDb::class.java,
                            DB_NAME
                        )
                        .build()
                }
            }
            return instance
        }
    }
}