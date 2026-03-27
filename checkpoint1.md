Descrição do projeto:

O projeto é um aplicativo Android desenvolvido com Jetpack Compose que implementa um sistema de navegação entre múltiplas telas. A estrutura conta com telas fundamentais como Login, Menu principal, Perfil do usuário e página de Pedidos, utilizando a biblioteca Compose Navigation para gerenciar o fluxo contínuo e a transferência de dados dinâmicos entre os componentes de interface.

Objetivo da prova:
O objetivo principal desta prova é evidenciar a compreensão clara do que está sendo feito e implementado no código. Em vez de apenas apresentar o resultado final, o foco é demonstrar o entendimento prático de como o fluxo de navegação funciona com o Jetpack Compose, explicando a lógica por trás da configuração de rotas e da passagem de parâmetros (obrigatórios, opcionais e de múltiplos tipos) entre as telas do aplicativo.

Explicação de cada evolução implementada:
Commit 1: Passagem de parâmetros obrigatórios na tela de Perfil

O que foi implementado: A tela de Perfil foi modificada para exigir e exibir uma informação dinâmica (o nome do usuário) passada através da navegação.

Como a navegação foi configurada: No arquivo MainActivity.kt (dentro do NavHost), a definição da rota foi alterada de composable("perfil") para composable("perfil/{nome}"). A sintaxe com chaves {} indica que a rota agora espera receber uma variável obrigatória chamada "nome" embutida na URL da navegação.

Como os parâmetros são enviados e recebidos:

Envio: No arquivo MenuScreen.kt, a ação do botão que leva ao perfil foi atualizada para navController.navigate("perfil/Fulano de Tal"), passando a string desejada diretamente no caminho da rota.

Recebimento: No NavHost, o valor é extraído usando it.arguments?.getString("nome") e então repassado para o componente da tela. O arquivo PerfilScreen.kt teve sua assinatura alterada para receber o parâmetro nome: String e passou a utilizá-lo na construção da interface, exibindo o texto "PERFIL - $nome".

Commit 2: Passagem de parâmetros opcionais na tela de Pedidos

O que foi implementado: A rota da tela de Pedidos foi preparada para receber uma informação adicional opcional (o nome do cliente) que não quebra a navegação caso não seja informada.

Como a navegação foi configurada: No NavHost, a rota mudou de composable("pedidos") para composable("pedidos?cliente={cliente}"). Além disso, foi declarada uma lista de arguments especificando que a chave "cliente" possui um valor padrão (em inglês, default value) de "Cliente Genérico" usando a função navArgument.

Como os parâmetros são enviados e recebidos:

Envio: Neste passo específico da implementação, a navegação de origem não precisou ser alterada de imediato. Se a rota "pedidos" for chamada sem o parâmetro, o Compose Navigation automaticamente assume o valor definido no defaultValue ("Cliente Genérico").

Recebimento: O valor é resgatado no NavHost através de it.arguments?.getString("cliente"). A assinatura da função PedidosScreen foi ajustada para aceitar a variável cliente: String? (aceitando nulos) e renderizar a informação na tela ("PEDIDOS - $cliente").

Commit 3: Inserindo valor ao parâmetro opcional na tela de Pedidos

O que foi implementado: Atualização do evento de clique na tela de Menu para de fato enviar um valor customizado para o parâmetro opcional configurado no commit anterior.

Como a navegação foi configurada: As configurações estruturais do NavHost e o recebimento na tela PedidosScreen permaneceram as mesmas feitas no Commit 2.

Como os parâmetros são enviados e recebidos:

Envio: No MenuScreen.kt, o código de navegação do botão de pedidos foi alterado de navController.navigate("pedidos") para navController.navigate("pedidos?cliente=Cliente XPTO"). Essa construção utiliza o padrão de query parameters da web (indicado pelo ? seguido de chave=valor) para empacotar e enviar o dado.

Recebimento: O recebimento se mantém transparente. O NavHost processa a string recebida e sobrepõe o defaultValue, fazendo com que a tela de pedidos agora exiba "Cliente XPTO" em vez de "Cliente Genérico".

Commit 4: Passagem de múltiplos parâmetros

O que foi implementado: A rota de Perfil, que antes recebia apenas o nome, foi expandida para receber também a idade do usuário, demonstrando a passagem de múltiplos valores e de tipos diferentes de dados (String e Integer).

Como a navegação foi configurada: No NavHost, a string de rota foi alterada para aceitar dois blocos de parâmetros: route = "perfil/{nome}/{idade}". Uma lista detalhada de arguments foi criada para tipar explicitamente as informações, definindo que "nome" é NavType.StringType e "idade" é NavType.IntType.

Como os parâmetros são enviados e recebidos:

Envio: No botão correspondente em MenuScreen.kt, a rota invocada passou a ser navController.navigate("perfil/Fulano de Tal/27"), adicionando o segundo valor (27) separado por uma barra /, respeitando o formato da URL.

Recebimento: Dentro do escopo do composable no NavHost, os dois argumentos são extraídos com as respectivas funções de tipagem: getString("nome") e getInt("idade"). A função PerfilScreen foi modificada para receber ambos (agora aceitando também idade: Int) e atualizou sua interface para incorporar os dados: "PERFIL - $nome tem $idade anos".
