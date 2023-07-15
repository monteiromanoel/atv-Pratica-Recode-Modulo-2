Algoritmo "VIAGEM"

Var
   maxCliente: inteiro
   vetCliente: vetor[1..3] de caracter
   vetDestino: vetor[1..3] de caracter

   ind, opcao: inteiro
   proc: caracter

   // Procedimento de pesquisa por CLIENTE
Procedimento procuraCliente(nome: caracter)
Var
   i: inteiro
   achou: logico

Inicio
   achou <- falso
   i <- 1

   enquanto (achou = falso) e (i <= 3) faca
      se vetCliente[i] = nome entao
         achou <- verdadeiro
      senao
         i <- i + 1
      fimSe
   fimEnquanto

   se achou = verdadeiro entao
      escreval("O cliente: ", nome, " possui o destino: ", vetDestino[i])
   senao
      escreval("O cliente: ", nome, " não foi localizado!")
   fimSe
fimProcedimento

// Procedimento de pesquisa por DESTINO
Procedimento procuraDestino(destino: caracter)
Var
   i: inteiro
   achou: logico
Inicio
   achou <- falso
   i <- 1

   enquanto (achou = falso) e (i <= 3) faca
      se vetDestino[i] = destino entao
         achou <- verdadeiro
      senao
         i <- i + 1
      fimSe
   fimEnquanto

   se achou = verdadeiro entao
      escreval("O destino: ", destino, " foi localizado com o cliente: ", vetCliente[i])
   senao
      escreval("Não foi localizado nenhum cadastro com o destino: ", destino)
   fimSe
fimProcedimento



Inicio
   escreval("******************************")
   escreval("----- AGÊNCIA DE VIAGENS -----")
   escreval("---- CADASTRO DE CLIENTES ----")

   escreval("")
   
   // Inputs para o vetor
   para ind de 1 ate 3 faca
      escreva("Digite o NOME do cliente: ")
      leia(vetCliente[ind])
      escreva("Digite o DESTINO do cliente: ")
      leia(vetDestino[ind])
      escreval("")
   fimPara

   escreval("")
   
   // Menu de escolha de pesquisa
   escreval("Digite a opção desejada: ")
   escreval("1- Consulta de Clientes / 2- Consulta de Destino")
   leia(opcao)

   escreval("")
   
   // Sistema de Opções
   escolha opcao
   caso 1
      escreval("Digite o nome do cliente ou FIM para finalizar a pesquisa: ")
      leia(proc)

      enquanto (proc <> "FIM") faca
         procuraCliente(proc)
         escreval("")
         escreval("Digite o nome do cliente ou FIM para finalizar a pesquisa: ")
         leia(proc)
         escreval("")
      fimEnquanto
   caso 2
      escreva("Digite o nome do destino ou FIM para finalizar a pesquisa: ")
      leia(proc)

      enquanto (proc <> "FIM") faca
         procuraDestino(proc)
         escreval("")
         escreva("Digite o nome do destino ou FIM para finalizar a pesquisa: ")
         leia(proc)
         escreval("")
      fimEnquanto

      escreval("******************************")
Fimalgoritmo

