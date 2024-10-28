package br.com.fiap.prevdent


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.prevdent.databinding.FragmentInfoGeraisBinding

import retrofit2.Call



class InfoGeraisFragment : Fragment(R.layout.fragment_info_gerais) {

    private lateinit var registroAdapter: RegistroAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentInfoGeraisBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView e Adapter
        recyclerView = view.findViewById(R.id.recyclerViewRegistros) // Certifique-se de que o ID está correto
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Inicializar o Adapter com uma lista vazia
        registroAdapter = RegistroAdapter(emptyList())
        recyclerView.adapter = registroAdapter

        // Carregar dados da API (ou dados fictícios, caso o endpoint ainda não esteja pronto)
        carregarRegistros() // Mude para `carregarRegistrosFicticios()` se precisar de dados de teste

        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInfoGeraisBinding.bind(view)

        setupBottomNavigationView()
    }


    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    findNavController().navigate(R.id.action_infoGeraisFragment_to_homeFragment)
                    true
                }
                R.id.nav_info_gerais -> true // Mantém na tela atual
                R.id.nav_registro -> {
                    findNavController().navigate(R.id.action_infoGeraisFragment_to_registroFragment)
                    true
                }
                else -> false
            }
        }
    }

    // Função para carregar registros do backend
    private fun carregarRegistros() {
        RetrofitInstance.api.obterRegistros().enqueue(object : retrofit2.Callback<List<Registro>> {
            override fun onResponse(call: Call<List<Registro>>, response: retrofit2.Response<List<Registro>>) {
                if (response.isSuccessful && response.body() != null) {
                    val registros = response.body()!!
                    registroAdapter.atualizarRegistros(registros)
                }
            }

            override fun onFailure(call: Call<List<Registro>>, t: Throwable) {
                // Tratar erro, ex: mostrar uma mensagem ao usuário
            }
        })
    }

    // Função para carregar registros fictícios para teste
    private fun carregarRegistrosFicticios() {
        val registros = listOf(
            Registro("Dor no dente", "★★★☆☆", "Dor", "Frequente", "Alta", "Detalhes sobre a dor"),
            Registro("Alimentação", "★★★★☆", "Sensibilidade", "Ocasional", "Média", "Detalhes sobre a alimentação")
        )
        registroAdapter.atualizarRegistros(registros)
    }
}