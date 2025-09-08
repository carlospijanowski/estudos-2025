Estudando o rabbitMQ!

nomenclaturas usadas no rabbitMQ:
- Producer: produtor de mensagens
- Consumer: consumidor de mensagens
- Queue: fila de mensagens
- Exchange: ponto de entrada das mensagens
- Binding: ligação entre exchange e queue
- Routing Key: chave de roteamento, usada para direcionar mensagens para filas específicas
- Virtual Host: ambiente isolado dentro do broker, permitindo múltiplas aplicações usarem o mesmo broker sem interferência
- Channel: canal de comunicação dentro de uma conexão TCP, permitindo múltiplas operações simultâneas
- Broker: servidor que gerencia as filas e troca de mensagens

principais Tipos de Exchange:
- Direct Exchange: roteia mensagens para filas com base na chave de roteamento exata
- Fanout Exchange: roteia mensagens para todas as filas ligadas, ignorando a chave de roteamento
- Topic Exchange: roteia mensagens para filas com base em padrões na chave de roteamento, permitindo correspondência parcial
- Headers Exchange: roteia mensagens com base em cabeçalhos personalizados, ignorando a chave de roteamento

O minimo do RabbitMQ é: "Receive, Store and Forward" (Receber, Armazenar e Encaminhar).

O RabbitMQ é um message broker que implementa o protocolo AMQP (Advanced Message Queuing Protocol). Ele é usado para facilitar a comunicação entre diferentes sistemas ou componentes de uma aplicação, permitindo o envio e recebimento de mensagens de forma assíncrona e confiável.

aonde o rabbitmq é instalado? 
O RabbitMQ é instalado em um servidor, que pode ser local (na máquina do desenvolvedor) ou remoto (em um servidor na nuvem ou em um data center). Ele pode ser instalado em diversos sistemas operacionais, incluindo Linux, Windows e macOS. A instalação pode ser feita através de pacotes pré-compilados, gerenciadores de pacotes (como apt para Debian/Ubuntu, yum para CentOS/RHEL) ou via Docker para ambientes containerizados.
Como o RabbitMQ funciona?
O RabbitMQ funciona como um intermediário entre produtores e consumidores de mensagens. O processo básico envolve os seguintes passos:
1. O produtor envia uma mensagem para uma exchange no RabbitMQ.
2. A exchange roteia a mensagem para uma ou mais filas (queues) com base em regras de roteamento (bindings) e na chave de roteamento (routing key).
3. A mensagem é armazenada na fila até que um consumidor a consuma.
4. O consumidor conecta-se ao RabbitMQ e consome mensagens da fila.
5. Após o consumo, o consumidor pode enviar uma confirmação (acknowledgment) para o RabbitMQ, indicando que a mensagem foi processada com sucesso.
6. O RabbitMQ remove a mensagem da fila após a confirmação do consumidor.
O RabbitMQ oferece recursos avançados, como persistência de mensagens, confirmação de entrega, suporte a transações, e alta disponibilidade através de clustering e replicação.

