# PrevDent

## Descrição das Telas

1. **Tela de Entrar**:
   - Tela inicial do aplicativo, oferecendo a opção de entrar ou cadastrar-se.
   - Botões para "Entrar com login" e "Cadastrar-se", além de uma opção para continuar sem login.
   - Logotipo do aplicativo PrevDent exibido na parte inferior.

2. **Tela de Login**:
   - Tela para que o usuário insira suas credenciais de login, incluindo os campos de usuário e senha.
   - Opção para acessar através de contas Google, Apple e Facebook.
   - Link para redirecionamento à tela de cadastro para novos usuários.

3. **Tela de Cadastro**:
   - Tela para novos usuários criarem uma conta, com campos para Nome Completo, Usuário, E-mail e Senha.
   - Botão de cadastro e link para redirecionamento à tela de login.
   - Opção para cadastro utilizando contas de terceiros (Google, Apple e Facebook).

4. **Tela Inicial (Home)**:
   - Tela de boas-vindas, mostrando o nome do usuário e as próximas consultas agendadas com detalhes de data e horário.
   - Sessão "Consultas agendadas" exibindo os próximos compromissos.
   - Sugestões de conteúdos informativos, como "Cuidar da saúde com o Vitor".

5. **Tela de Informações Gerais**:
   - Apresenta informações gerais sobre o usuário, como Tipo Sanguíneo, Idade, Altura e Peso.
   - Sessão "Últimos Registros" com cartões mostrando informações recentes registradas, como "Dores de dente", "Alimentação" e "Temperatura".

6. **Tela de Novo Registro**:
   - Formulário para adicionar um novo registro, permitindo que o usuário insira informações como tipo, quantidade e intensidade, além de campo para "Informações adicionais".
   - Botão para adicionar o registro, que será exibido posteriormente na sessão "Últimos Registros" na tela de Informações Gerais.
## Funcionalidades
- **Login de Usuário:** Permite a entrada de um CPF e senha, com validação básica.
- **Validação de Campos:** Exibe mensagens de alerta caso os campos estejam vazios ou com valores incorretos.
- **Feedback Visual:** Utiliza `Toast` para informar ao usuário se o login foi bem-sucedido ou se houve erro.

## Tecnologias Utilizadas
- **Linguagem:** Kotlin
- **IDE:** Android Studio
- **Ferramentas:**
  - ViewBinding
  - ConstraintLayout

## Link do Figma
Você pode acessar o design da tela de login no Figma através deste [link](https://www.figma.com/design/LdbWpLFI6QwxVDzIIAu9va/PrevDent?node-id=0-1&node-type=canvas&t=0mb1Hs0qjFSQtA78-0).

## Vídeo Demonstrativo
Confira o vídeo demonstrativo no YouTube [aqui](https://www.youtube.com/watch?v=yzYDaAhXnV4).

## Como Executar o Projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/seu-usuario/prevdent.git


