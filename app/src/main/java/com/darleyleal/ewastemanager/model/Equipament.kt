package com.darleyleal.ewastemanager.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "equipaments")
data class Equipament(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Long = 0,

    @ColumnInfo(name = "userNeme")
    var userName: String? = null,

    @ColumnInfo(name = "telephoneNumber")
    var telephoneNumber: String? = null,

    @ColumnInfo(name = "workSector")
    var workSector: String? = null,

    @ColumnInfo(name = "date")
    var date: String? = null,

    @ColumnInfo(name = "equipamentType")
    var equipamentType: String? = null,

    @ColumnInfo(name = "equipamentFabricant")
    var equipamentFabricant: String? = null,

    @ColumnInfo(name = "serieNumber")
    var serieNumber: String? = null,

    @ColumnInfo(name = "equipamentVoltage")
    var equipamentVoltage: String? = null,

    @ColumnInfo(name = "description")
    var description: String? = null,

    @ColumnInfo(name = "equipamentStatus")
    var equipamentStatus: String? = null
)