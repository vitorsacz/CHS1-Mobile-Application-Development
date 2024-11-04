package br.com.fiap.prevdent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.prevdent.databinding.FragmentHomeBinding
import retrofit2.Call
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ConsultationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView()
        fetchConsultations()
        setupBottomNavigationView()

        return binding.root
    }

    private fun setupRecyclerView() {
        binding.recyclerViewConsultations.layoutManager = LinearLayoutManager(requireContext())
        adapter = ConsultationAdapter(emptyList())
        binding.recyclerViewConsultations.adapter = adapter
    }

    private fun fetchConsultations() {
        RetrofitInstance.consultaApi.obterConsultas().enqueue(object : Callback<List<Consultation>> {
            override fun onResponse(call: Call<List<Consultation>>, response: Response<List<Consultation>>) {
                if (response.isSuccessful) {
                    response.body()?.let { consultations ->
                        Log.d("HomeFragment", "Consultations fetched: $consultations")
                        adapter = ConsultationAdapter(consultations)
                        binding.recyclerViewConsultations.adapter = adapter
                    } ?: run {
                        Log.e("HomeFragment", "Response body is null")
                    }
                } else {
                    Log.e("HomeFragment", "Erro ao buscar consultas: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<Consultation>>, t: Throwable) {
                Log.e("HomeFragment", "Falha na conexão: ${t.message}")
            }
        })
    }


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
