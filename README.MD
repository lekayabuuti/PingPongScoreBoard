# PingPongScoreBoard

Placar de ping-pong entre Jogador A e Jogador B, implementado com quatro
abordagens diferentes de retenção de estado (Etapas 1 a 4).

## Quadro comparativo

| Abordagem                     | Rotação de tela | Morte do processo |
|--------------------------------|:---------------:|:-----------------:|
| remember                       |  Não sobrevive  |   Não sobrevive   |
| ViewModel + mutableStateOf     |                 |                   |
| ViewModel + StateFlow          |                 |                   |
| ViewModel + SavedStateHandle   |                 |                   |

## Perguntas

### 1. Por que o ViewModel sozinho (etapas 2 e 3) não é suficiente para sobreviver à morte do processo, mesmo sobrevivendo à rotação de tela?

_(responder após testar as etapas 2 e 3)_

### 2. Qual a diferença prática entre usar mutableStateOf e StateFlow dentro do ViewModel nesta aplicação? Em algum momento essa diferença foi perceptível nos testes?

_(responder após testar as etapas 2 e 3)_

### 3. Se este placar precisasse ser salvo permanentemente (mesmo após o usuário fechar o app e abrir dias depois), qual das quatro abordagens ainda seria insuficiente, e o que seria necessário adicionar?

_(responder após concluir todas as etapas)_

### 4. Na sua opinião, qual abordagem você usaria em produção para este placar e por quê?

_(responder após concluir todas as etapas)_
 
