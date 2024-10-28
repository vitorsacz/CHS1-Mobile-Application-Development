package br.com.fiap.prevdent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.prevdent.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        /*setupRecyclerView()*/
        setupBottomNavigationView()

        return binding.root
    }

    /*rivate fun setupRecyclerView() {
        val consultations = listOf(
            Consultation("07", "Out", "09:30 AM", "Dr. Keven Ike", "Periodontia"),
            Consultation("12", "Out", "09:30 AM", "Dr. José Ribeiro", "Dentista")
        )

        // Log para verificar se a lista de consultas está sendo criada corretamente
        Log.d("HomeFragment", "RecyclerView consultations: $consultations")

        val adapter = ConsultationAdapter(consultations)
        binding.recyclerViewConsultations.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewConsultations.adapter = adapter
    }*/

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_info_gerais -> {
                    findNavController().navigate(R.id.action_homeFragment_to_infoGeraisFragment)
                    true
                }
                R.id.nav_registro -> {
                    findNavController().navigate(R.id.action_homeFragment_to_registroFragment)
                    true
                }
                else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
