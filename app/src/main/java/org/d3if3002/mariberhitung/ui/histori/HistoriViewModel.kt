package org.d3if3002.mariberhitung.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3002.mariberhitung.db.HasilDao


class HistoriViewModel(private val db: HasilDao) : ViewModel() {
    val data = db.getLastHitung()

    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            db.clearData()
        }
    }
}