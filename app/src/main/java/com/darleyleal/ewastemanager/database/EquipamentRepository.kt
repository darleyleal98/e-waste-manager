package com.darleyleal.ewastemanager.database

import android.content.Context
import com.darleyleal.ewastemanager.model.Equipament

class EquipamentRepository(context: Context) {

    private val dao = EWasteDatabase.getDatabase(context).eWasteManagerDAO()

    fun getAllItems(): List<Equipament> {
        return dao.getAllItems()
    }

    fun getItem(id: Int): Equipament {
        return dao.getItem(id)
    }

    fun insert(equipament: Equipament): Boolean {
        return dao.insert(equipament) > 0
    }

    fun delete(equipament: Equipament) {
        return dao.delete(equipament)
    }

    fun update(equipament: Equipament): Boolean{
        return dao.update(equipament) > 0
    }
}