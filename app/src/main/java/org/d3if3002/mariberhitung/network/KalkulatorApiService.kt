package org.d3if3002.mariberhitung.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3002.mariberhitung.Profile
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/abdulraihanabray/Asessmen/static-api/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface KalkulatorApiService {
    @GET("about.json")
    suspend fun getProfile(): Profile
}
object KalkulatorApi {
    val service: KalkulatorApiService by lazy {
        retrofit.create(KalkulatorApiService::class.java)
    }

    enum class ApiStatus { LOADING, SUCCESS, FAILED }

    fun getProfileUrl(): String {
        return "${BASE_URL}foto_abray.jpg"
    }
}