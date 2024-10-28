package br.com.fiap.prevdent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.prevdent.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // Configura o botão de voltar
        binding.imageView3.setOnClickListener {
            findNavController().navigateUp()
        }

        // Configura o botão de login
        binding.idBtnTelaLoginEntar.setOnClickListener {
            val cpf = binding.idTelaLoginUsuario.text.toString()
            val senha = binding.editTextTextPassword2.text.toString()

            if (cpf == "12345678900" && senha == "senha123") {

                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            } else {

                Toast.makeText(requireContext(), "CPF ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}