package com.darleyleal.ewastemanager.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.darleyleal.ewastemanager.model.Equipament
import kotlinx.coroutines.flow.Flow

@Dao
interface EquipamentDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(equipamento: Equipament): Long

    @Update
    fun update(equipamento: Equipament): Int

    @Delete
    fun delete(equipamento: Equipament)

    @Query("SELECT * FROM equipaments WHERE id = :id")
    fun getItem(id: Int): Equipament

    @Query("SELECT * FROM equipaments")
    fun getAllItems(): List<Equipament>
}