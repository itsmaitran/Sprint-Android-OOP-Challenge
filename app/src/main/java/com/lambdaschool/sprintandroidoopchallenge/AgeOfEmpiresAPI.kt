package com.lambdaschool.sprintandroidoopchallenge

import com.lambdaschool.sprintandroidoopchallenge.model.Civilizations
import com.lambdaschool.sprintandroidoopchallenge.model.Structures
import com.lambdaschool.sprintandroidoopchallenge.model.Technologies
import com.lambdaschool.sprintandroidoopchallenge.model.Units
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import java.util.concurrent.TimeUnit

interface AgeOfEmpiresAPI {

    @Headers("accept: application/json")

    @GET("civilizations")
    fun getCivilitzation(): Call<List<Civilizations>>

    @GET("units")
    fun getUnits(): Call<List<Units>>

    @GET("structures")
    fun getStructures(): Call<List<Structures>>

    @GET("technologies")
    fun getTechnologies(): Call<List<Technologies>>

    class Factory {

        companion object {
            private const val BASE_URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/"

            fun create(): AgeOfEmpiresAPI {

                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BASIC

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .retryOnConnectionFailure(false)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(15, TimeUnit.SECONDS)
                    .build()

                val retrofit = Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                return retrofit.create(AgeOfEmpiresAPI::class.java)
            }
        }
    }
}