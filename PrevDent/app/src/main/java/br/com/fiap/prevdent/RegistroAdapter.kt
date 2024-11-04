package br.com.fiap.prevdent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RegistroAdapter(private var registros: List<Registro>) :
    RecyclerView.Adapter<RegistroAdapter.RegistroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RegistroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_registro, parent, false)
        return RegistroViewHolder(view)
    }

    override fun onBindViewHolder(holder: RegistroViewHolder, position: Int) {
        val registro = registros[position]
        holder.tvTipoRegistro.text = "Tipo: ${registro.tipo}"
        holder.tvOcorrenciaRegistro.text = "Ocorrência: ${registro.ocorrencia}"
        holder.tvIntensidadeRegistro.text = "Intensidade: ${registro.intensidade}"
        holder.tvInformacoesAdicionais.text = "Info: ${registro.informacoesAdicionais}"

        holder.tvInformacoesAdicionais.text = "Info: ${registro.informacoesAdicionais ?: "Sem informações adicionais"}"
    }

    override fun getItemCount(): Int = registros.size

    fun atualizarRegistros(novosRegistros: List<Registro>) {
        registros = novosRegistros
        notifyDataSetChanged()
    }

    inner class RegistroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTipoRegistro: TextView = itemView.findViewById(R.id.tvTipoRegistro)
        val tvOcorrenciaRegistro: TextView = itemView.findViewById(R.id.tvOcorrenciaRegistro)
        val tvIntensidadeRegistro: TextView = itemView.findViewById(R.id.tvIntensidadeRegistro)
        val tvInformacoesAdicionais: TextView = itemView.findViewById(R.id.tvInformacoesAdicionais)
    }
}