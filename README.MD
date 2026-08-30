# PingPongScoreBoard

Placar de ping-pong entre Jogador A e Jogador B, implementado com quatro
abordagens diferentes de retenção de estado (Etapas 1 a 4).

## Quadro comparativo

| Abordagem                     | Rotação de tela | Morte do processo |
|--------------------------------|:---------------:|:-----------------:|
| remember                       |  Não sobrevive  |   Não sobrevive   |
| ViewModel + mutableStateOf     |    Sobrevive    |   Não sobrevive   |
| ViewModel + StateFlow          |    Sobrevive    |   Não sobrevive   |
| ViewModel + SavedStateHandle   |    Sobrevive    |     Sobrevive     |

## Perguntas

### 1. Por que o ViewModel sozinho (etapas 2 e 3) não é suficiente para sobreviver à morte do processo, mesmo sobrevivendo à rotação de tela?

_O ViewModel também é mantido em RAM durante a execução do aplicativo, através da associação com a Activity via ViewModelStore. Na rotação de tela, somente a Activity é destruída e recriada, mas o processo continua rodando, ou seja, o ViewModel permanece. Já quando o processo inteiro é encerrado, toda a memória RAM associada a ele é apagada, incluindo o ViewModel, pois nada ali estava salvo em disco. Quando o app volta, um processo novo é criado e um ViewModel novo é instanciado do zero._

### 2. Qual a diferença prática entre usar mutableStateOf e StateFlow dentro do ViewModel nesta aplicação? Em algum momento essa diferença foi perceptível nos testes?

_Nos testes de rotação e morte de processo, o comportamento das etapas 2 e 3 foi igual. Isso acontece porque a diferença entre mutableStateOf e StateFlow não está relacionada a sobrevivência de estado, mas sim a testabilidade e desacoplamento da UI. O mutableStateOf é uma API do Compose, só funciona dentro de uma composição. Já o StateFlow é uma API do Kotlin Coroutines, por isso pode ser usado e testado fora do Compose, além de poder ter vários coletores observando o mesmo valor._

### 3. Se este placar precisasse ser salvo permanentemente (mesmo após o usuário fechar o app e abrir dias depois), qual das quatro abordagens ainda seria insuficiente, e o que seria necessário adicionar?

_Todas as quatro abordagens seriam insuficientes, inclusive o SavedStateHandle. Ele sobrevive à morte de processo simulada nos testes porque o sistema salva os dados num Bundle temporário, vinculado àquela mesma sessão/tarefa do app, com a intenção de restaurá-la em seguida. Mas esse Bundle não é um mecanismo de persistência permanente: ele é descartado quando o usuário fecha o app explicitamente (removendo da lista de recentes) ou após muito tempo, já que nunca foi escrito em nenhum lugar duradouro como um arquivo ou banco de dados. Para persistência de verdade, seria necessário adicionar uma camada de armazenamento em disco, como um banco de dados ou, para um caso simples como este (só dois números), alternativas mais leves como DataStore ou SharedPreferences também resolveriam. O ViewModel continuaria orquestrando o estado em memória durante o uso do app, mas passaria a ler o valor inicial dessa fonte persistente e gravar nela a cada alteração, em vez de depender só do SavedStateHandle._

### 4. Na sua opinião, qual abordagem você usaria em produção para este placar e por quê?

_Usaria a Etapa 4 (ViewModel + SavedStateHandle), porque é a única que cobre o cenário mais comum de uso real de um placar assim: o usuário girar a tela, trocar de app ou o sistema fechar o app em segundo plano sem que o usuário perceba, tudo sem zerar o placar. Persistência permanente (banco de dados) seria desnecessária aqui, já que uma partida de ping-pong não precisa ser recuperada dias depois._
 
