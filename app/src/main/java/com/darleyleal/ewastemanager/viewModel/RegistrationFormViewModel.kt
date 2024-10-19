package com.darleyleal.ewastemanager.viewModel

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.darleyleal.ewastemanager.database.EquipamentRepository
import com.darleyleal.ewastemanager.model.Equipament

class RegistrationFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = EquipamentRepository(application.applicationContext)

    var userName by mutableStateOf("")
    var telephoneNumber by mutableStateOf("")
    var workSector by mutableStateOf("")
    var equipamentType by mutableStateOf("")
    var equipamentFabricant by mutableStateOf("")
    var serieNumber by mutableStateOf("")
    var equipamentVoltage by mutableStateOf("")
    var description by mutableStateOf("")
    var equipamentStatus by mutableStateOf("")
    var selectedDate by mutableStateOf("")

    var currentEquipament: Equipament? by mutableStateOf(null)
        private set

    private var _insertEquipament = mutableStateOf<Boolean>(false)
    val insertEquipament: MutableState<Boolean> = _insertEquipament

    private fun validateFieldForm(): Boolean {
        when {
            userName.trim().isEmpty() -> return false
            telephoneNumber.trim().isEmpty() -> return false
            workSector.trim().isEmpty() -> return false
            equipamentType.trim().isEmpty() -> return false
            serieNumber.trim().isEmpty() -> return false
            selectedDate.trim().isEmpty() -> return false
            equipamentVoltage.trim().isEmpty() -> return false
            equipamentStatus.trim().isEmpty() -> return false
            equipamentFabricant.trim().isEmpty() -> return false
            description.trim().isEmpty() -> return false
        }
        return true
    }

    fun insert(
        userName: String, telephoneNumber: String, workSector: String, date: String,
        equipamentType: String, serieNumber: String, equipamentVoltage: String,
        equipamentStatus: String, equipamentFabricant: String, description: String
    ) {
        val equipament = Equipament().apply {
            this.userName = userName
            this.telephoneNumber = telephoneNumber
            this.workSector = workSector
            this.date = date
            this.equipamentType = equipamentType
            this.serieNumber = serieNumber
            this.equipamentVoltage = equipamentVoltage
            this.equipamentStatus = equipamentStatus
            this.equipamentFabricant = equipamentFabricant
            this.description = description
        }
        _insertEquipament.value = repository.insert(equipament)

        this.userName = ""
        this.telephoneNumber = ""
        this.workSector = ""
        this.equipamentType = ""
        this.equipamentFabricant = ""
        this.serieNumber = ""
        this.equipamentVoltage = ""
        this.description = ""
        this.equipamentStatus = ""
        selectedDate = ""
    }

    fun delete(equipament: Equipament) {
        repository.delete(equipament)
    }

    fun update(equipament: Equipament) {
        repository.update(equipament)
    }

    fun listAllEquipaments(): List<Equipament> {
        return repository.getAllItems()
    }

    fun getEquipament(id: String): Equipament {
        val equipament = repository.getItem(id.toInt())
        currentEquipament = equipament
        return equipament
    }
}
