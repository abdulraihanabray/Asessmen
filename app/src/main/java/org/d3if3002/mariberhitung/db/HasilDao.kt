package org.d3if3002.mariberhitung.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HasilDao {
    @Insert
    fun insert(hitung: HitungEntity)

    @Query("SELECT * FROM hasil ORDER BY id DESC")
    fun getLastHitung(): LiveData<List<HitungEntity>>

    @Query("DELETE FROM hasil")
    fun clearData()

}