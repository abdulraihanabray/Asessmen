package org.d3if3002.mariberhitung.ui.profile

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3002.mariberhitung.Profile
import org.d3if3002.mariberhitung.network.KalkulatorApi
import org.d3if3002.mariberhitung.network.UpdateWorker
import java.util.concurrent.TimeUnit

class ProfileViewModel : ViewModel(){

    private val data = MutableLiveData<Profile>()
    private val status = MutableLiveData<KalkulatorApi.ApiStatus>()

    init {
        retrieveData()
    }
    private fun retrieveData() {
        viewModelScope.launch (Dispatchers.IO) {
            status.postValue(KalkulatorApi.ApiStatus.LOADING)
            try {
                data.postValue(KalkulatorApi.service.getProfile())
                status.postValue(KalkulatorApi.ApiStatus.SUCCESS)

            } catch (e: Exception) {
                Log.d("MainViewModel", "Failure: ${e.message}")
                status.postValue(KalkulatorApi.ApiStatus.FAILED)

            }
        }
    }

    fun getData(): LiveData<Profile> = data
    fun getStatus(): LiveData<KalkulatorApi.ApiStatus> = status

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            request
        )
    }

}