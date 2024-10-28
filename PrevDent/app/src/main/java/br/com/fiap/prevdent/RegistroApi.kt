package br.com.fiap.prevdent


import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RegistroApi {
    @POST("seu_endpoint_de_envio") // Ajuste o endpoint para envio de dados
    fun enviarRegistro(@Body registro: Registro): Call<Void>

    @GET("seu_endpoint_de_recebimento") // Ajuste o endpoint para buscar registros
    fun obterRegistros(): Call<List<Registro>>
}