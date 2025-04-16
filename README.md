# Dados de Jogadores de Futebol

Este exercício tem como objetivo trabalhar o conceito de coleções em Java,
especificamente HashMaps.

## Orientações Gerais

- Você deve fazer um passo de cada vez, testá-lo, fazer o commit e enviar suas alterações.
Somente depois disso é que você deve passar para o próximo passo.

- **ATENÇÃO**: **desligue o GitHub Copilot para fazer o exercício!**
  - Se você utilizá-lo você não estará realmente exercitando os conceitos aprendidos e
    não terá o domínio adequado para desenvolver as habilidades necessárias para se tornar
	um bom programador/desenvolvedor.
  - Sem contar ainda a questão do plágio.
  - Lembre-se que você pode (e deve) consultar os materiais da disciplina para fazer o exercício.

- Esse arquivo README pode ser melhor visualizado no VS Code (com formatação adequada) 
  abrindo-o no modo de visualização. Para isso, basta apertar Ctrl+Sfhit+V com ele aberto.

## Passo 0 - Conhecendo o sistema

Neste passo você deve fazer duas coisas: entender o funcionamento do sistema e entender o código implementado.

Primeiramente, execute o programa e acesse todas as opções de menu para entender como ele funciona do
ponto de vista do usuário.

- Experimente visualizar dados de vários jogadores diferentes.
- Obs.: os nomes não possuem acentos.

Em seguida, estude o código das classes `Jogador` e `Principal`.

- Com o que estudamos na disciplina até agora é esperado que você entenda todo o código das duas classes.
- Em caso de dúvidas, chame o professor ou monitor.

Já o código da classe `Dados` utiliza conceitos que ainda não vimos 
(como leitura de arquivos e tratamentos de exceção).

- De todo modo, dê uma olhada na classe.
- É importante que você entenda, pelo menos, como a classe `ArrayList` está sendo utilizada.

## Passo 1 - Carregando os dados para um HashMap

Neste exercício, vamos alterar o sistema para que ele passe a utilizar um `HashMap`.

- A ideia é manter o uso do `ArrayList` e acrescentar o `HashMap` de forma que, ao final,
  você consiga comparar como cada um deles é utilizado.
- Você perceberá ao final que, em um sistema real, certamente não utilizaríamos as duas coleções 
  ao mesmo tempo (já que vamos acabar tendo várias replicações no código).
- Mas, como já mencionado, a ideia é que você tenha o código das duas coleções para comparar. 

Neste passo, você deve carregar os dados do arquivo em um `HashMap`.
Para isso:

- Altere a classe `Dados` criando um método chamado `carregarDadosJogadoresParaHashMap`.
- O método deve retornar um `HashMap` formado por pares com a chave sendo o nome do jogador e o valor sendo o objeto `Jogador`. 
- Comece o código do método copiando o código do método `carregarDadosJogadores`.
- Veja que você precisará fazer poucas alterações, já que a leitura dos dados e a criação do objeto `Jogador` em si não precisarão ser alteradas.

## Passo 2 - Carregando o HashMap na classe Principal

Você deve agora alterar a classe `Principal` para que:

- ela tenha um atributo que é um `HashMap` de jogadores;
- e os dados dos jogadores sejam carregados no `HashMap` no método `carregarJogadores` (logo após o carregamento do `ArrayList`) usando o método que você criou no passo anterior.

Teste seu programa para confirmar que não ocorrem erros ao acessar a primeira opção do menu.

## Passo 3 - Utilizando o HashMap

Vamos agora adicionar uma nova opção no menu, chamada `Buscar jogador por nome no HashMap`.

Crie um método para tratar essa nova opção de menu.

- O método deve pedir o nome do jogador para o usuário, buscar o jogador no `HashMap` e exibir seus detalhes para o usuário.

Compare o seu código com o método que trata a busca do jogador pelo nome usando o `ArrayList`.

- O que achou? 
- O código usando `HashMap` é mais fácil ou mais difícil?
- E no caso de muitos dados haveria alguma diferença de eficiência?

<< Digite sua resposta aqui (trocando o texto dessa linha pela sua resposta) >>

Lembre-se de testar sua alteração para confirmar se o método funciona corretamente.

## Passo 4 - Cuidados no uso do HashMap

Execute o programa e exiba os dados de um jogador chamado `Pedro` tanto na opção 
`Buscar jogador por nome` (que usa `ArrayList`), quanto na opção `Buscar jogador por nome no HashMap`.

- O resultado é o que você esperava? O que acha que aconteceu?
- Obs.: responda o que você acha no momento antes de ler o resto do exercício.

<< Digite sua resposta aqui (trocando o texto dessa linha pela sua resposta) >>

Algo está estranho, certo? Vamos explorar isso um pouco mais.

- Altere o método `carregarJogadores` da classe `Principal` de forma que ele exiba a quantidade
  de jogadores carregados tanto no `ArrayList`, quanto no `HashMap`.

Os números batem? O que acha que está acontecendo?

<< Digite sua resposta aqui (trocando o texto dessa linha pela sua resposta) >>

Você acha que há alguma forma de resolver esse problema alterando o código?
O que você mudaria na busca usando `ArrayList`?
E como você trataria o uso do `HashMap`?

- Obs.: não é necessário tratar essa questão no código, basta que responda abaixo.

<< Digite sua resposta aqui (trocando o texto dessa linha pela sua resposta) >>

## Passo 5 - Melhorando a busca

Atualmente a busca exige que o nome do jogador seja digitado corretamente, inclusive os caracteres maiúsculos e minúsculos.

Altere o sistema de forma que a busca dos jogadores pelo nome (tanto do `ArrayList` quanto do `HashMap`) ignorem os caracteres maiúsculos e minúsculos.

## Passo 6 - Nova busca com ArrayList

Uma dificuldade de utilizar o sistema é que precisamos acertar exatamente o nome do jogador.

- Seria bom se pudéssemos digitar apenas as primeiras letras do nome do jogador e o sistema mostrasse todos os jogadores que começam com essas letras.

Neste passo vamos criar uma nova opção de menu `Buscar jogador pelo início do nome`.

- Nesta opção devem ser usados os dados do `ArrayList`.

Dicas:

- Lembre-se que deve ser considerado apenas o início do nome.
- Assim, se o usuário digitar `ar`, por exemplo, poderia aparecer algum jogador chamado `arnaldo`, mas não `carlos`. 

Teste suas alterações!

## Passo 7 - Nova busca com HashMap

Vamos agora criar uma nova opção de menu `Buscar jogador pelo início do nome no HashMap`.

- Você deve fazer basicamente a mesma coisa do passo anterior, mas agora com os dados do `HashMap`.

Teste suas alterações e, em seguida, responda às perguntas abaixo.

Compare as alterações que você fez nesse passo e no passo anterior.

- O que achou? 
- O código usando `HashMap` é mais fácil ou mais difícil?
- E no caso de muitos dados haveria alguma diferença de eficiência?
- Quando é vantagem usar um `HashMap` em vez de um `ArrayList`?

<< Digite sua resposta aqui (trocando o texto dessa linha pela sua resposta) >>

## [Opcional] Passo 8 - Usando HashMap para dados pré-processados

Suponha que o usuário quisesse consultar quantos jogadores nasceram em cada país.

Nós poderíamos facilmente tratar isso fazendo uma busca no `ArrayList` de jogadores, 
da mesma forma que foi feita a busca pelo nome do jogador, 
mas agora buscando pelo nome de um país e contando quantas vezes ele aparece.

Mas se essa fosse uma consulta feita muitas vezes no sistema, 
seria melhor se a contabilização fosse feita uma única vez,
para todos os países, e ficasse disponível para consulta de forma rápida.

- Nós podemos fazer isso usando um `HashMap`.

Seguindo essa ideia, neste passo, você deve criar uma nova opção de menu
`Número de jogadores por país`.

- Para tratá-la, você precisará criar um novo atributo `HashMap` na classe `Principal`.
- Esse atributo será usado para guardar a quantidade de jogadores que nasceram em cada país.
- Os dados deste novo `HashMap` devem ser carregados a partir do `HashMap` de jogadores que você já tinha implementado, logo
  depois dele ser carregado.
  - Crie um método separado para tratar esse carregamento.
- Quando o usuário acessar a nova opção de menu, ele deve informar o nome correto do país
  e a quantidade de jogadores que nasceram nele deve ser exibida para o usuário.
