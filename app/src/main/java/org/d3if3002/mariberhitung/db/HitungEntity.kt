package org.d3if3002.mariberhitung.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hasil")
data class HitungEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var hasil: Float,
    )

