# MoneyAPI | Your eco API!

  

Uma APi que foi criada para ser utilizada em alguns projetos e economizar códigos de SQL.

O projeto foi desenvolvido com maior pensamento para jogos e não ambientes financeiros.

  

OBS: Dependendo do jogo ou da aplicação desejada deve ser realizado maiores verificações.

  

## Como utilizar?

  

1. Deve instanciar a classe **EcoTable** para criar a tabela no banco de dados.

  

2. O segundo passo é instanciar a classe **EcoController**.

  

## Métodos disponíveis

  

### Usuário


*Cria uma conta para o usuário.*

    void criarConta(String player)

*Deleta uma conta.*

    void deletarConta(String player)

*Consulta saldo de uma conta,retornando o valor.*

    Integer consultar(String player)


### Dinheiro


*Adiciona dinheiro na conta.*

    void adicionar(String player, Integer saldo)

*Subtrai dinheiro da conta.*

    void diminuir(String player, Integer saldo)
