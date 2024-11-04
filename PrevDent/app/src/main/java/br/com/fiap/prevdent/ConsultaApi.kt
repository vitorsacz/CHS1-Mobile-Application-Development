package br.com.fiap.prevdent


import retrofit2.http.GET
import retrofit2.Call

interface ConsultaApi {
    @GET("consulta")
    fun obterConsultas(): Call<List<Consultation>>
}