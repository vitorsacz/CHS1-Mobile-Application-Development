package br.com.fiap.prevdent

import com.google.gson.annotations.SerializedName


data class Registro(
    val tipo: String,
    val ocorrencia: String,
    val intensidade: String,

    @SerializedName("informacoes_adicionais")
    val informacoesAdicionais: String
)

