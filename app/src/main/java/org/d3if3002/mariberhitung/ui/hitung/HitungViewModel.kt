package org.d3if3002.mariberhitung.ui.hitung

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if3002.mariberhitung.db.HasilDao
import java.util.concurrent.TimeUnit

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

    }


    fun getHasil() : MutableLiveData<Int> = hasil


}