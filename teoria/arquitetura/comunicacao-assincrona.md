## Quanto falamos de comunicacao assincrona, temos algumas opcoes como kafka, rabbit, sqs.
    mas existem outras como: ActiveMQ, NATS, Pulsar, Google Pub/Sub, Azure Service Bus

## o que elas se proproe a resolver?
    Garantir que produtores e consumidores não precisem estar online ao mesmo tempo. 
    Controlar picos de carga (buffer de mensagens). Como fazer isso? 
        Com filas que armazenam mensagens temporariamente. 
        Permitir desacoplamento entre serviços (produtores e consumidores independentes). 
        Garantir entrega confiável (persistência, confirmações).
    Oferecer mecanismos de retry, DLQ e idempotência para evitar perda ou duplicação. 
    Possibilitar escalabilidade horizontal (vários consumidores paralelos). 
    Viabilizar event-driven architecture (sistemas reagindo a eventos em vez de polling síncrono).

    🔑 Técnica de Memorização (mnemônico)  
        Estou dentro da renner. em uma fila e entao recebo uma mensagem no meu WhatsApp. Mando uma mensagem pra tatiana e ela esta offline.
            como é legal saber que ela vai receber minha mensagem quando ela voltar online.
        Ja que estou na fila, vejo que a fila esta enorme. Muitas pessoas esperando. Percebo que tem um gerente analizando e abrindo mais caixas. 
        E a fila anda mais rapido. Isso é otimo para controlar picos de carga.
                como garantir uma entrega confiavel? 
                    Vejo que cada caixa tem um computador que registra cada compra. 
                    E quando a compra é feita, o caixa confirma a compra no sistema.
                    Assim, se houver algum problema, a compra pode ser refeita sem perder os dados.
        Estranhamente vejo um carteiro tentando entregar uma carta pra mim. Ele disse que era uma carta da tatiana. A sorte que 
            ele disse que tentaria de novo amanha se eu nao estivesse. E se eu nao estivesse por varios dias, ele deixaria na caixa de cartas perdidas.
        Como garantir Possibilitar escalabilidade horizontal? 
            Vejo que a renner tem varios caixas. E cada caixa é um consumidor diferente. Assim, varias pessoas podem ser atendidas ao mesmo tempo.
        E viabilizando o evento-driven architecture, vejo que um sensor de movimento acende a luz automaticamente quando alguem passa confirmando
            que o cliente esta saindo da loja. so acende a luz quando alguem passa.

## o que levar em conta entre escolher uma ou outra?
    o natural é pensar em performance, escalabilidade, durabilidade, facilidade de uso, custo.
    Mas também: 
        1 - modelo de mensagens (fila vs tópico)
        2 - garantias de entrega (at-least-once, at-most-once, exactly-once),
        3 - suporte a transações, ecossistema (ferramentas, bibliotecas), 
        4 - facilidade de operação (monitoramento, alertas),
        5 - requisitos de latência, complexidade de roteamento, 
        6 - integração com outras tecnologias (cloud providers, frameworks).            
    
    Volume de mensagens (milhares por segundo ou milhões?).
    Precisa reprocessar histórico ou vários times lerem o mesmo evento? → Kafka. 
    É fila de trabalho com tratamento de erro previsível (retry/DLQ/TTL)? → RabbitMQ. 
    Ordenação por entidade (cliente/pedido) é crucial? → Kafka com message key. 
    Roteamento complexo (topic/direct) e RPC? → RabbitMQ. 
    Escala absurda de eventos e pipelines analíticos? → Kafka.  
    Precisa de simplicidade e baixo custo operacional em nuvem? → SQS ou Pub/Sub. 
    Integração com ecossistema Microsoft/Azure? → Azure Service Bus. 
    Quer algo leve e ultra-rápido para IoT ou microserviços menores? → NATS.

### 1. qual a diferença entre fila e tópico? 
    Fila: mensagens são consumidas por um único consumidor (load balancing). 
    Fila é um modelo de comunicação em sistemas de mensageria onde as mensagens são armazenadas em uma estrutura de dados FIFO (First In, First Out). 
    As mensagens são enviadas por produtores para a fila e são consumidas por consumidores. 
    Cada mensagem é entregue apenas a um consumidor, permitindo o balanceamento de carga e a escalabilidade horizontal. 
    Filas são ideais para cenários de processamento de tarefas assíncronas, onde a ordem de processamento é importante. 

    Tópico: mensagens são publicadas para múltiplos assinantes (publish-subscribe).
    Tópico é um modelo de comunicação em sistemas de mensageria onde as mensagens são publicadas para múltiplos assinantes. 
    As mensagens enviadas para um tópico são recebidas por todos os consumidores que estão inscritos nesse tópico. 
    Isso permite um padrão de publicação-assinatura (publish-subscribe), onde múltiplos serviços podem reagir a eventos de forma independente. 
    Tópicos são ideais para cenários onde a disseminação de informações para vários destinatários é necessária, como em sistemas de notificação ou eventos de sistema.  

    Ainda nao esta claro? Pense em uma fila de supermercado (fila) vs um canal de TV (tópico). 
    por que esse exemplo? 
        Na fila de supermercado, cada cliente (consumidor) é atendido por um caixa (mensagem) de cada vez. 
        Se houver vários caixas, os clientes podem ser atendidos em paralelo, mas cada cliente só pode ser atendido por um caixa. 
        Isso é como uma fila, onde cada mensagem é entregue a apenas um consumidor.

        Em um canal de TV, várias pessoas (consumidores) podem assistir ao mesmo programa (mensagem) ao mesmo tempo. 
        Se o programa for interessante, muitas pessoas podem estar assistindo simultaneamente. 
        Isso é como um tópico, onde cada mensagem é entregue a todos os consumidores inscritos.
 
### 2. o que é garantia de entrega at-least-once, at-most-once, exactly-once?
    At-least-once: cada mensagem é entregue pelo menos uma vez, mas pode ser duplicada. 
    At-most-once: cada mensagem é entregue no máximo uma vez, podendo ser perdida. 
    Exactly-once: cada mensagem é entregue exatamente uma vez, sem duplicação ou perda. 

### 3. o que é idempotência?
    Idempotência é a propriedade de uma operação que pode ser aplicada múltiplas vezes sem alterar o resultado além da aplicação inicial. 
    Em sistemas distribuídos, isso significa que se uma mensagem for processada mais de uma vez (devido a falhas ou retries), 
    o resultado final permanece o mesmo, evitando efeitos colaterais indesejados.

### 4. o que é DLQ?
    DLQ (Dead Letter Queue) é uma fila especial onde mensagens que não puderam ser processadas com sucesso são enviadas. 
    Isso permite que essas mensagens sejam analisadas posteriormente para identificar e corrigir problemas, 
    sem perder os dados ou impactar o fluxo normal de processamento.

### 5. o que é retry?
    Retry é o mecanismo de tentar reprocessar uma mensagem que falhou na primeira tentativa.
    Isso pode ser configurado com políticas específicas, como número máximo de tentativas, intervalos entre tentativas, 
    e estratégias de backoff (exponencial, linear) para evitar sobrecarregar o sistema.

    um retry pode ser imediato (tentar novamente logo após a falha) ou diferido (esperar um tempo antes de tentar novamente).
    pode ser configuradon no app ou no broker (ex: RabbitMQ suporta retries nativamente com TTL e DLQ).
    o que levar em conta: se a operação é idempotente, quantas tentativas são aceitáveis, impacto na latência, complexidade de implementação. 

### 6. o que é particionamento?
    Particionamento é a divisão de uma fila ou tópico em múltiplas partes menores (partições) para distribuir a carga de trabalho entre vários consumidores. 
    Isso melhora a escalabilidade e a performance, permitindo que múltiplos consumidores processem mensagens em paralelo.   

    no rabbitmq, particionamento pode ser feito com múltiplas filas e exchanges.
    no kafka, particionamento é nativo e cada partição pode ser consumida por um consumidor diferente dentro de um consumer group.

### 7. o que é sharding?
    Sharding é a prática de dividir um banco de dados ou sistema em partes menores e mais gerenciáveis, chamadas shards. 
    Cada shard contém um subconjunto dos dados e pode ser hospedado em um servidor diferente. 
    Isso melhora a escalabilidade, performance e disponibilidade do sistema.

### 8. o que é broker?
    Broker é o componente central em sistemas de mensageria que gerencia a recepção, armazenamento e entrega de mensagens entre produtores e consumidores. 
    Ele atua como intermediário, garantindo que as mensagens sejam roteadas corretamente, armazenadas de forma confiável e entregues conforme as políticas definidas (como ordenação, retries, DLQ).    

### 9. o que é consumer group?
    Consumer group é um conjunto de consumidores que trabalham juntos para processar mensagens de uma fila ou tópico. 
    Cada mensagem é entregue a apenas um consumidor dentro do grupo, permitindo balanceamento de carga e escalabilidade horizontal. 
    Se um consumidor falhar, outro do grupo pode assumir o processamento das mensagens.

    um exeplo real seria um sistema de processamento de pedidos onde múltiplos serviços (consumidores) estão inscritos em um tópico de pedidos.
    Cada serviço processa diferentes pedidos, garantindo que todos os pedidos sejam atendidos de forma eficiente.

### 10. o que é message key?
    Message key é um identificador associado a uma mensagem que determina como ela será particionada e roteada dentro do sistema de mensageria. 
    No Kafka, por exemplo, mensagens com a mesma key são garantidas a serem enviadas para a mesma partição, 
    o que é útil para manter a ordem de processamento para entidades específicas (como um cliente ou pedido).

### 11. o que é backpressure?
    Backpressure é um mecanismo usado em sistemas de processamento de dados para controlar o fluxo de mensagens entre produtores e consumidores. 
    Quando um consumidor está sobrecarregado e não consegue processar mensagens na mesma velocidade que elas são produzidas, 
    o sistema aplica backpressure para desacelerar o produtor, evitando a perda de mensagens e garantindo a estabilidade do sistema.

### 12. o que é event-driven architecture?
    Event-driven architecture (EDA) é um estilo de arquitetura de software onde os componentes do sistema se comunicam através de eventos. 
    Em vez de chamadas diretas entre serviços, um serviço publica um evento quando algo significativo acontece, 
    e outros serviços que estão interessados nesse evento reagem    
    de forma assíncrona. Isso promove desacoplamento, escalabilidade e flexibilidade no design do sistema.

### 13. o que é polling síncrono?
    Polling síncrono é uma técnica onde um consumidor verifica periodicamente uma fila ou tópico para ver se há novas mensagens disponíveis. 
    Isso pode levar a latência e ineficiência, pois o consumidor pode estar ocioso esperando por mensagens ou pode perder mensagens se não verificar com frequência suficiente. 
    Em contraste, sistemas baseados em eventos notificam os consumidores imediatamente quando novas mensagens chegam, permitindo um processamento mais reativo e eficiente.

### 14. o que é transação em sistemas de mensageria?
    Transação em sistemas de mensageria refere-se a um conjunto de operações que são executadas como uma única unidade de trabalho. 
    Isso significa que todas as operações dentro da transação devem ser concluídas com sucesso para que a transação seja confirmada (committed). 
    Se qualquer operação falhar, todas as operações são revertidas (rolled back) para garantir a consistência dos dados.
    Em sistemas de mensageria, isso pode incluir o envio de mensagens para múltiplas filas ou tópicos, garantindo que todas as mensagens sejam entregues ou nenhuma seja entregue em caso de falha. 

### 15. o que é latência em sistemas de mensageria?
    Latência em sistemas de mensageria refere-se ao tempo que leva para uma mensagem ser enviada por um produtor, transmitida através do sistema de mensageria, 
    e finalmente recebida por um consumidor. 
    Isso inclui o tempo de processamento no broker, o tempo de rede, e o tempo que o consumidor leva para processar a mensagem. 
    Baixa latência é crucial para aplicações que exigem respostas rápidas e em tempo real.

### 16. o que é complexidade de roteamento em sistemas de mensageria?
    Complexidade de roteamento em sistemas de mensageria refere-se à dificuldade de definir e gerenciar as regras e políticas que determinam como as mensagens são encaminhadas do produtor para o consumidor. 
    Isso pode incluir a necessidade de diferentes tipos de roteamento, como roteamento baseado em tópicos, filas, ou regras específicas (como filtros ou transformações). 
    Sistemas com alta complexidade de roteamento podem exigir configuração e manutenção adicionais, o que pode aumentar a sobrecarga operacional.

### 17. o que é facilidade de operação em sistemas de mensageria?
    Facilidade de operação em sistemas de mensageria refere-se à simplicidade e eficiência com que o sistema pode ser instalado, configurado, monitorado e mantido. 
    Isso inclui aspectos como a disponibilidade de ferramentas de gerenciamento, documentação clara, suporte a automação (como infraestrutura como código), e a capacidade de escalar o sistema conforme necessário. 
    Um sistema fácil de operar reduz a carga sobre as equipes de operações e permite uma resposta mais rápida a problemas ou mudanças nos requisitos.   

### 18. o que é custo em sistemas de mensageria?
    Custo em sistemas de mensageria refere-se aos recursos financeiros necessários para implementar, operar e manter o sistema. 
    Isso pode incluir custos diretos, como licenças de software, infraestrutura (servidores, armazenamento, largura de banda), e custos de suporte.
    Também pode incluir custos indiretos, como o tempo e esforço da equipe para gerenciar o sistema, treinamento, e possíveis custos de downtime ou falhas. 
    Avaliar o custo total de propriedade (TCO) é crucial para tomar decisões informadas sobre qual sistema de mensageria adotar.

### 19. o que é exactly-once em sistemas de mensageria?
    Exactly-once é uma garantia de entrega em sistemas de mensageria que assegura que cada mensagem seja entregue exatamente uma vez ao consumidor, sem duplicação ou perda. 
    Isso é particularmente desafiador em sistemas distribuídos devido a falhas de rede, crashes de consumidores, e outros problemas que podem levar a mensagens sendo processadas múltiplas vezes ou não sendo processadas.
    Para alcançar exactly-once, sistemas de mensageria podem implementar mecanismos como transações, idempotência, e coordenação entre produtores e consumidores.   

### 20. o que é at-most-once em sistemas de mensageria?
    At-most-once é uma garantia de entrega em sistemas de mensageria que assegura que cada mensagem seja entregue no máximo uma vez ao consumidor, podendo ser perdida. 
    Isso significa que, em caso de falhas, uma mensagem pode não ser processada, mas nunca será processada mais de uma vez. 
    Essa abordagem é útil em cenários onde a perda ocasional        

    de mensagens é aceitável, mas a duplicação não é tolerada.      

### 21. o que é at-least-once em sistemas de mensageria?
    At-least-once é uma garantia de entrega em sistemas de mensageria que assegura que cada mensagem seja entregue pelo menos uma vez ao consumidor, mas pode ser duplicada.    

    Isso significa que, em caso de falhas, uma mensagem pode ser processada múltiplas vezes, mas nunca será perdida.        
    Essa abordagem é útil em cenários onde a perda de mensagens não é aceitável, mas a duplicação pode ser gerenciada, geralmente através de idempotência no processamento das mensagens.


### 22. o que é Kafka?
    Apache Kafka é uma plataforma de streaming distribuída de código aberto, projetada para construir pipelines de dados em tempo real e aplicações de streaming. 
    Ele é altamente escalável, durável e oferece alta performance para o processamento de grandes volumes de dados. 
    Kafka utiliza um modelo de publicação-assinatura (publish-subscribe) baseado em tópicos, onde produtores enviam mensagens para tópicos e consumidores se inscrevem para receber essas mensagens. 
    Ele é amplamente utilizado em sistemas de mensageria, análise de dados em tempo real, e integração de sistemas.     

### 23. o que é RabbitMQ?
    RabbitMQ é um broker de mensagens de código aberto que implementa o protocolo AMQP (Advanced Message Queuing Protocol). 
    Ele é projetado para facilitar a comunicação assíncrona entre diferentes componentes de um sistema, 
    permitindo o envio e recebimento de mensagens de forma confiável e escalável.
    RabbitMQ suporta múltiplos modelos de roteamento, como filas, tópicos, e exchanges, 
    e oferece recursos como garantias de entrega, retries, DLQ, e transações. 
    Ele é amplamente utilizado em aplicações empresariais, microserviços, e sistemas distribuídos.  

### 24. o que é SQS?
    Amazon SQS (Simple Queue Service) é um serviço de fila de mensagens totalmente gerenciado pela AWS. 
    Ele permite que componentes de software se comuniquem de forma assíncrona, 
    enviando, armazenando e recebendo mensagens entre diferentes partes de um sistema. 
    SQS oferece alta disponibilidade, escalabilidade automática, e integração com outros serviços da AWS.
    Ele suporta dois tipos de filas: Standard (entrega pelo menos uma vez, ordem não garantida) e FIFO (entrega exatamente uma vez, ordem garantida). 
    SQS é ideal para desacoplar componentes de aplicações, balancear carga, e processar tarefas em segundo plano.

### 25. o que é ActiveMQ?
    Apache ActiveMQ é um broker de mensagens de código aberto que implementa o protocolo JMS (Java Message Service). 
    Ele é projetado para facilitar a comunicação assíncrona entre diferentes componentes de um sistema, 
    permitindo o envio e recebimento de mensagens de forma confiável e escalável. 
    ActiveMQ suporta múltiplos modelos de roteamento, como filas, tópicos, e virtual topics, 
    e oferece recursos como garantias de entrega, retries, DL   

### 26. como implementar no java o kafka?
    No java, voce pode usar a biblioteca oficial do Kafka, chamada Kafka Clients ou usar frameworks como Spring Kafka para facilitar a integração.

### 27. como implementar no java o rabbitmq?
    No java, voce pode usar a biblioteca oficial do RabbitMQ, chamada RabbitMQ Java Client ou usar frameworks como Spring AMQP para facilitar a integração.

### 28. como implementar no java o sqs?
    No java, voce pode usar a biblioteca oficial do AWS SDK for Java, que inclui suporte para o SQS, ou usar frameworks como Spring Cloud AWS para facilitar a integração.


### 29. se eu tenho um sistema que precisa produzir logs para datalake, qual a melhor ferramenta de comunicacao assincrona?
    Kafka é geralmente a melhor escolha para esse cenário devido à sua alta performance, escalabilidade e durabilidade. 
    Ele é projetado para lidar com grandes volumes de dados em tempo real, tornando-o ideal para pipelines de dados e análise em tempo real. 
    Além disso, Kafka oferece suporte nativo para retenção de mensagens, permitindo que os logs sejam armazenados por um período definido, 
    o que é útil para reprocessamento e auditoria.
    RabbitMQ também pode ser usado, mas é mais adequado para cenários de processamento de tarefas assíncronas e comunicação entre microserviços, 
    onde a ordem de processamento e garantias de entrega são mais críticas.
    SQS é uma opção viável se você estiver procurando por uma solução totalmente gerenciada e integrada com outros serviços da AWS, 
    mas pode não oferecer a mesma performance e flexibilidade que Kafka para grandes volumes de dados.

### 30. se eu tenho um sistema que precisa processar tarefas em segundo plano, qual a melhor ferramenta de comunicacao assincrona?
    RabbitMQ é geralmente a melhor escolha para esse cenário devido ao seu suporte robusto para filas de trabalho, garantias de entrega, retries e DLQ. 
    Ele é projetado para facilitar o processamento assíncrono de tarefas, permitindo que múltiplos consumidores processem mensagens em paralelo, 
    o que é ideal para balanceamento de carga e escalabilidade horizontal.
    Kafka também pode ser usado, especialmente se a ordem de processamento for importante ou se você precisar reprocessar mensagens, 
    mas pode ser mais complexo de configurar e operar para esse tipo de tarefa.
    SQS é uma opção viável se você estiver procurando por uma solução totalmente gerenciada e integrada com outros serviços da AWS, 
    mas pode não oferecer a mesma flexibilidade e controle que RabbitMQ para cenários de processamento de tarefas.
### 31. se eu tenho um sistema que precisa escalar absurdamente, qual a melhor ferramenta de comunicacao assincrona?
    Kafka é geralmente a melhor escolha para esse cenário devido à sua arquitetura distribuuída, que permite escalar horizontalmente adicionando mais brokers e partições. 
    Ele é projetado para lidar com grandes volumes de dados e altas taxas de transferência, tornando-o ideal para aplicações que exigem escalabilidade extrema.
    RabbitMQ também pode ser escalado, mas pode enfrentar limitações de performance em cenários de altíssima escala devido à sua arquitetura centralizada.
    SQS é uma opção viável se você estiver procurando por uma solução totalmente gerenciada e integrada com outros serviços da AWS, 
    mas pode não oferecer a mesma performance e flexibilidade que Kafka para cenários de altíssima escala.

### 32. se eu tenho um sistema que precisa de simplicidade e baixo custo operacional em nuvem, qual a melhor ferramenta de comunicacao assincrona?
    SQS é geralmente a melhor escolha para esse cenário devido ao seu modelo de serviço totalmente gerenciado pela AWS. 
    Ele elimina a necessidade de gerenciar infraestrutura, escalabilidade e manutenção,
    permitindo que você se concentre no desenvolvimento da aplicação.
    SQS oferece uma interface simples e integração nativa com outros serviços da AWS,
    tornando-o uma opção econômica e fácil de usar para comunicação assíncrona em nuvem.
    Kafka e RabbitMQ podem ser mais complexos de configurar e operar, especialmente em ambientes de nuvem, 
    e podem envolver custos adicionais relacionados à infraestrutura e manutenção.
### 33. se eu tenho um sistema que precisa de integração com ecossistema Microsoft/Azure, qual a melhor ferramenta de comunicacao assincrona?
    Azure Service Bus é geralmente a melhor escolha para esse cenário devido à sua integração nativa com o ecossistema Microsoft e Azure. 
    Ele oferece suporte a múltiplos modelos de mensageria, como filas e tópicos, e é projetado para facilitar a comunicação assíncrona entre diferentes componentes de um sistema.
    Azure Service Bus oferece recursos avançados, como garantias de entrega, retries, DLQ, e transações, além de integração com outros serviços do Azure, como Azure Functions e Logic Apps. 
    Kafka e RabbitMQ podem ser usados em ambientes Azure, mas podem não oferecer a mesma integração e suporte nativo que o Azure Service Bus.
    SQS é uma opção viável se você estiver procurando por uma solução totalmente gerenciada na
    AWS, mas pode não ser a melhor escolha para integração com o ecossistema Microsoft/Azure.   

### 34. como garantir idempotência em sistemas de mensageria?
    Para garantir idempotência em sistemas de mensageria, você pode implementar as seguintes estratégias:

    1. Identificadores únicos: Atribua um identificador único a cada mensagem (como um UUID ou um hash) e armazene esses identificadores em um banco de dados ou cache. 
       Antes de processar uma mensagem, verifique se o identificador já foi processado. Se sim, ignore a mensagem; se não, processe-a e registre o identificador como processado.

    2. Operações idempotentes: Projete as operações que processam as mensagens para serem idempotentes, ou seja, que possam ser aplicadas múltiplas vezes sem alterar o resultado além da aplicação inicial. 
       Por exemplo, ao atualizar um registro no banco de dados, use uma operação que defina o valor diretamente em vez de incrementá-lo.

    3. Controle de versão: Inclua uma versão ou timestamp na mensagem e use isso para determinar se a mensagem é mais recente do que a última processada. 
       Se a mensagem for mais antiga, ignore-a.

    4. Transações: Use transações para garantir que o processamento da mensagem e a atualização do estado do sistema sejam atômicos. 
       Se o processamento falhar, a transação pode ser revertida, evitando efeitos colaterais indesejados.

    5. Retries com backoff: Implemente políticas de retry com backoff exponencial para evitar sobrecarregar o sistema com tentativas repetidas de processamento da mesma mensagem.

    6. Monitoramento e alertas: Monitore o sistema para detectar mensagens duplicadas ou falhas no processamento e configure alertas para investigar e corrigir problemas rapidamente.

    Combinando essas estratégias, você pode minimizar os riscos associados à duplicação de mensagens e garantir que seu sistema permaneça consistente e confiável.
