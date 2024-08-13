Trabalho 2: Simulação de Processamento de Pedidos em Pizzaria
Disciplina: Algoritmo e Estrutura de Dados I
Semestre: 2024/01

Descrição do Projeto
Este trabalho consiste na implementação de um programa para simular o recebimento e processamento de pedidos em uma pizzaria. A simulação é feita com base em unidades de tempo fictícias, onde o tempo começa em 0 e avança de 1 em 1 até que todos os pedidos tenham sido processados.

Regras da Simulação
Unidade de Tempo: A simulação ocorre em unidades de tempo discretas. Cada pedido é realizado em um instante de tempo específico e possui um tempo de preparo associado.
Capacidade do Pizzaiolo: A pizzaria possui apenas um pizzaiolo, que pode preparar apenas uma pizza por vez. Se o pizzaiolo estiver ocupado, os pedidos seguintes devem aguardar em uma fila de espera.
Ordem de Processamento: Quando o pizzaiolo termina um pedido, ele imediatamente inicia o próximo pedido da fila.
Exemplo de Execução
No instante t=1, o pedido 75853-Calabresa é recebido e o pizzaiolo está disponível, portanto, este pedido entra em produção imediatamente. No mesmo instante, o pedido 85744-Portuguesa é recebido, mas como o pizzaiolo está ocupado, este pedido é colocado na fila de espera.

Enquanto o pizzaiolo trabalha na pizza de calabresa, novos pedidos podem chegar e serão adicionados à fila. Quando a pizza de calabresa é finalizada no instante t=5, o pedido 85744-Portuguesa é retirado da fila e colocado em produção. A simulação continua até que todos os pedidos sejam processados.

Funcionalidades Implementadas
Leitura de Arquivo CSV: O programa lê os dados da simulação a partir de um arquivo CSV que contém o código do pedido, o sabor da pizza, o instante de tempo do pedido e o tempo de preparo.

Processamento da Simulação: A simulação pode ser executada passo a passo ou de forma contínua. O usuário pode avançar um ciclo a cada vez que pressionar a tecla <ENTER> ou pode optar pela execução contínua digitando "C".

Fila de Pedidos: Os pedidos que não podem ser imediatamente processados pelo pizzaiolo são armazenados em uma fila dinâmica, implementada sem o uso de ArrayList ou estruturas semelhantes do Java.

Árvore Binária de Pesquisa (ABP): Cada pedido processado é inserido em uma Árvore Binária de Pesquisa na ordem em que foram sendo produzidos. A ABP permite a organização dos pedidos de forma eficiente.

Geração de Relatórios: O programa gera três arquivos CSV contendo:

Situação da fila a cada instante t.
Caminhamento central da ABP gerada pelos pedidos processados.
Relatório geral com o total de pedidos processados, o tempo total de execução e os pedidos mais demorados.
Para executar o programa o usuário deve optar por uma simulação contínua ou passo a passo. 


