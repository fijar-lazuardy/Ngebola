package id.ac.ui.cs.mobileprogramming.fijar.ngebola.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "https://api.football-data.org/v2/"

    private val httpClient = OkHttpClient.Builder().addInterceptor {
        val request = it.request().newBuilder().addHeader("X-Auth-Token", "9fefd9d44ceb4e0484bf4932e80b04e7").build()
//        val request = it.request().newBuilder().addHeader("X-Auth-Token", "9fefd9d44ceb4e0484bf4932e80b04e7sadaw").build()
        return@addInterceptor it.proceed(request)
    }.build()

    private val client = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    val RETROFIT_SERVICE: ApiService = client.create(ApiService::class.java)
}