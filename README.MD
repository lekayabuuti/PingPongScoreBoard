# PingPongScoreBoard

Placar de ping-pong entre Jogador A e Jogador B, implementado com quatro
abordagens diferentes de retenção de estado (Etapas 1 a 4).

## Quadro comparativo

| Abordagem                     | Rotação de tela | Morte do processo |
|--------------------------------|:---------------:|:-----------------:|
| remember                       |  Não sobrevive  |   Não sobrevive   |
| ViewModel + mutableStateOf     |    Sobrevive    |   Não sobrevive   |
| ViewModel + StateFlow          |    Sobrevive    |                   |
| ViewModel + SavedStateHandle   |                 |                   |

## Perguntas

### 1. Por que o ViewModel sozinho (etapas 2 e 3) não é suficiente para sobreviver à morte do processo, mesmo sobrevivendo à rotação de tela?

_O ViewModel também é mantido em RAM durante a execução do aplicativo, através da associação com a Activity via ViewModelStore. Na rotação de tela, somente a Activity é destruída e recriada, mas o processo continua rodando, ou seja, o ViewModel permanece. Já quando o processo inteiro é encerrado, toda a memória RAM associada a ele é apagada, incluindo o ViewModel, pois nada ali estava salvo em disco. Quando o app volta, um processo novo é criado e um ViewModel novo é instanciado do zero._

### 2. Qual a diferença prática entre usar mutableStateOf e StateFlow dentro do ViewModel nesta aplicação? Em algum momento essa diferença foi perceptível nos testes?

_Nos testes de rotação e morte de processo, o comportamento das etapas 2 e 3 foi igual. Isso acontece porque a diferença entre mutableStateOf e StateFlow não está relacionada a sobrevivência de estado, mas sim a testabilidade e desacoplamento da UI. O mutableStateOf é uma API do Compose, só funciona dentro de uma composição. Já o StateFlow é uma API do Kotlin Coroutines, por isso pode ser usado e testado fora do Compose, além de poder ter vários coletores observando o mesmo valor._

### 3. Se este placar precisasse ser salvo permanentemente (mesmo após o usuário fechar o app e abrir dias depois), qual das quatro abordagens ainda seria insuficiente, e o que seria necessário adicionar?

_(responder após concluir todas as etapas)_

### 4. Na sua opinião, qual abordagem você usaria em produção para este placar e por quê?

_(responder após concluir todas as etapas)_
 
