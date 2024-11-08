package br.com.fiap.prevdent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.prevdent.databinding.FragmentRegistroBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RegistroFragment : Fragment(R.layout.fragment_registro) {

    private var _binding: FragmentRegistroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)

        setupButtonClick()

        setupBottomNavigationView()

        return binding.root
    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    findNavController().navigate(R.id.action_registroFragment_to_homeFragment)
                    true
                }
                R.id.nav_info_gerais -> {
                    findNavController().navigate(R.id.action_registroFragment_to_infoGeraisFragment)
                    true
                }
                R.id.nav_registro -> true
                else -> false
            }
        }
    }

    private fun setupButtonClick() {
        binding.buttonAdicionarRegistro.setOnClickListener {
            val tipo = binding.editTextTipo.text.toString()
            val ocorrencia = binding.editTextOcorrencia.text.toString()
            val intensidade = binding.editTextIntensidade.text.toString()
            val informacoesAdicionais = binding.editTextInformacoesAdicionais.text.toString()

            Log.d("RegistroFragment", "Dados coletados - Tipo: $tipo, Ocorrência: $ocorrencia, Intensidade: $intensidade, Informações Adicionais: $informacoesAdicionais")

            if (tipo.isNotBlank() && ocorrencia.isNotBlank() && intensidade.isNotBlank() && informacoesAdicionais.isNotBlank()) {
                val registro = Registro(
                    tipo = tipo,
                    ocorrencia = ocorrencia,
                    intensidade = intensidade,
                    informacoesAdicionais = informacoesAdicionais
                )
                enviarRegistroParaBackend(registro)
            } else {
                Toast.makeText(requireContext(), "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun enviarRegistroParaBackend(registro: Registro) {
        Log.d("RegistroFragment", "Enviando registro: $registro")
        val call = RetrofitInstance.api.enviarRegistro(registro)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Toast.makeText(requireContext(), "Registro adicionado com sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    Log.e("RegistroFragment", "Falha ao adicionar o registro: Código ${response.code()}, Mensagem: ${response.message()}")
                    Toast.makeText(requireContext(), "Falha ao adicionar o registro: Código ${response.errorBody()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("RegistroFragment", "Erro na requisição: ${t.message}", t)
                Toast.makeText(requireContext(), "Erro: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}