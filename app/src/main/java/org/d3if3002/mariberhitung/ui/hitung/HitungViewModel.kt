package org.d3if3002.mariberhitung.ui.hitung

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3002.mariberhitung.db.HasilDao
import org.d3if3002.mariberhitung.db.HitungEntity

class HitungViewModel(private val db: HasilDao) : ViewModel() {

    private var hasil = MutableLiveData<Int>()

//    val data = db.getLastHitung()
    fun do_hitung_hasil(nilai1:Int,nilai2:Int, pilih_operator:String) {
        when (pilih_operator) {
            "x" -> hasil.value = nilai1 * nilai2
            "/" -> hasil.value = nilai1 / nilai2
            "+" -> hasil.value = nilai1 + nilai2
            "-" -> hasil.value = nilai1 - nilai2
            "%" -> hasil.value = nilai1 % nilai2


        }
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataEntity = HitungEntity(
                    hasil = hasil.value!!.toFloat()
                )
                db.insert(dataEntity)
            }
        }
    }



    fun getHasil() : MutableLiveData<Int> = hasil
}