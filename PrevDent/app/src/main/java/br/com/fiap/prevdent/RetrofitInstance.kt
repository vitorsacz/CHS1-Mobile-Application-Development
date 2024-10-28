package br.com.fiap.prevdent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://sua_api_base_url/") // Substitua pela URL base do seu back-end
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: RegistroApi by lazy {
        retrofit.create(RegistroApi::class.java)
    }
}