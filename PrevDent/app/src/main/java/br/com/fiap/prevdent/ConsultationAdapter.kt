package br.com.fiap.prevdent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ConsultationAdapter(private val consultations: List<Consultation>) :
    RecyclerView.Adapter<ConsultationAdapter.ConsultationViewHolder>() {

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
        private val textMonth: TextView = itemView.findViewById(R.id.textMonth)
        private val textTime: TextView = itemView.findViewById(R.id.textTime)
        private val textDoctorName: TextView = itemView.findViewById(R.id.textDoctorName)
        private val textSpecialty: TextView = itemView.findViewById(R.id.textSpecialty)

        fun bind(consultation: Consultation) {
            textDate.text = consultation.date // ex: "07"
            textMonth.text = consultation.month // ex: "Out"
            textTime.text = consultation.time // ex: "09:30 AM"
            textDoctorName.text = consultation.doctorName // ex: "Dr. Keven Ike"
            textSpecialty.text = consultation.specialty // ex: "Periodontia"
        }
    }
}