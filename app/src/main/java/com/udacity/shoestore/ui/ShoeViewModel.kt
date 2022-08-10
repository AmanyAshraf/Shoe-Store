package  com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList
    lateinit var newName :String
    lateinit var newSize :String
    lateinit var newCompany :String
    lateinit var newDescription :String

    init {
        _shoeList.value = mutableListOf()
    }
    fun clear() {
        newName = ""
        newSize = ""
        newCompany = ""
        newDescription = ""
    }
    fun addNewShoes(): Boolean {
        if (!checkData()) return false
        addShoes(
            newName,
            newSize.toDouble(),
            newCompany,
            newDescription
        )
        return true
    }
    private fun addShoes(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe("Name & size: ${name}", size, "Company : ${company}", "description : ${description}")
        _shoeList.value!!.add(shoe)
    }
    private fun checkData(): Boolean {
        if (newName.isBlank() ||
            newCompany.isBlank() ||
            newSize.isBlank()  ||
            newDescription.isBlank()) {
            return false
        }
        return true
    }
}