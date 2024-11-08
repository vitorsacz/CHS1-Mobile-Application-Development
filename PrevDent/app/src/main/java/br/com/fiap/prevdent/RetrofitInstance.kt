package br.com.fiap.prevdent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: RegistroApi by lazy {
        retrofit.create(RegistroApi::class.java)
    }

    val consultaApi: ConsultaApi by lazy {
        retrofit.create(ConsultaApi::class.java)
    }
}