package id.ac.ui.cs.mobileprogramming.fijar.ngebola.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://v2.api-football.com/"

    private val httpClient = OkHttpClient.Builder().addInterceptor {
        val request = it.request().newBuilder().addHeader("X-RapidAPI-Key", "3f2224102a6b4ccaf006e9e9b06a6698").build()
        return@addInterceptor it.proceed(request)
    }

    private val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val RETROFIT_SERVICE: ApiService = client.create(ApiService::class.java)
}