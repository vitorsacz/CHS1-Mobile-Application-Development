package br.com.fiap.prevdent


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RegistroApi {
    @POST("novos-registros/cadastrar") // Ajuste o endpoint para envio de dados
    fun enviarRegistro(@Body registro: Registro): Call<Void>

    @GET("novos-registros") // Ajuste o endpoint para buscar registros
    fun obterRegistros(): Call<List<Registro>>

}