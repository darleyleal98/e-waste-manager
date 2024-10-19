package com.darleyleal.ewastemanager.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.darleyleal.ewastemanager.model.Equipament
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Equipament::class], version = 1)
abstract class EWasteDatabase : RoomDatabase() {
    abstract fun eWasteManagerDAO(): EquipamentDAO

    companion object {
        private lateinit var INSTANCE: EWasteDatabase

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): EWasteDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(EWasteDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        EWasteDatabase::class.java, "ewaste"
                    ).addMigrations(MIGRATION)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM EWaste")
            }
        }
    }
}