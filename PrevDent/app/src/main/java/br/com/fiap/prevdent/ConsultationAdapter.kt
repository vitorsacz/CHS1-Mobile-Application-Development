package br.com.fiap.prevdent

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale


class ConsultationAdapter(private val consultations: List<Consultation>) :
    RecyclerView.Adapter<ConsultationAdapter.ConsultationViewHolder>() {

    init {
        // Log para verificar se a lista de consultas contém dados
        Log.d("ConsultationAdapter", "Consultations list: $consultations")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_consultation_card, parent, false)
        return ConsultationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConsultationViewHolder, position: Int) {
        val consultation = consultations[position]
        holder.bind(consultation)
    }

    override fun getItemCount() = consultations.size

    inner class ConsultationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textDate: TextView = itemView.findViewById(R.id.textDate)
        private val textDentist: TextView = itemView.findViewById(R.id.textDentist)
        private val textPatient: TextView = itemView.findViewById(R.id.textPatient)
        private val textTreatmentType: TextView = itemView.findViewById(R.id.textTreatmentType)
        private val textDiagnosis: TextView = itemView.findViewById(R.id.textDiagnosis)

        fun bind(consultation: Consultation) {

            val originalFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.getDefault())
            val targetFormat = SimpleDateFormat("dd MMM", Locale("pt", "BR"))

            try {
                val date = originalFormat.parse(consultation.data)
                val formattedDate = targetFormat.format(date)
                textDate.text = formattedDate
            } catch (e: Exception) {
                textDate.text = consultation.data
            }



            Log.d("ConsultationAdapter", "Data: ${consultation.data}, Dentista: ${consultation.dentista.nomeDentista}, Paciente: ${consultation.paciente.nome}, Tipo Tratamento: ${consultation.tipoTratamento}, Descrição: ${consultation.diagnostico.descricao}")

            textDentist.text = consultation.dentista.nomeDentista
            textPatient.text = consultation.paciente.nome
            textTreatmentType.text = consultation.tipoTratamento
            textDiagnosis.text = consultation.diagnostico.descricao
        }
    }
}