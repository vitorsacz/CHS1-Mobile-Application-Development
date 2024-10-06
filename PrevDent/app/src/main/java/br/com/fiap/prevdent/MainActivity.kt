package br.com.fiap.prevdent

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.prevdent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEntrar.setOnClickListener {
            val cpf = binding.editTextLoginCpf.text.toString()
            val senha = binding.editTextLoginPassword.text.toString()

            if (cpf.isNotEmpty() && senha.isNotEmpty()) {

                if (cpf == "12345678900" && senha == "1234") {
                    Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "CPF ou senha incorretos!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textViewCadastraSe.setOnClickListener {
            Toast.makeText(this, "Redirecionando para a tela de cadastro...", Toast.LENGTH_SHORT).show()
        }
    }
}