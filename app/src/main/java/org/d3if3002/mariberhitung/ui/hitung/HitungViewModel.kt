package org.d3if3002.mariberhitung.ui.hitung

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HitungViewModel : ViewModel(){

    private var hasil = MutableLiveData<Int>()

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