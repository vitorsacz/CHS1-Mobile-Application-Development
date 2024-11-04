package br.com.fiap.prevdent

import com.google.gson.annotations.SerializedName

data class Consultation(
    @SerializedName("paciente") val paciente: PacienteInfo,
    @SerializedName("dentista") val dentista: DentistaInfo,
    @SerializedName("data") val data: String,
    @SerializedName("tipoTratamento") val tipoTratamento: String,
    @SerializedName("diagnostico") val diagnostico: DiagnosticoInfo
)


data class PacienteInfo(
    @SerializedName("nome") val nome: String
)

data class DentistaInfo(
    @SerializedName("nome") val nomeDentista: String
)

data class DiagnosticoInfo(
    @SerializedName("descricao") val descricao: String
)