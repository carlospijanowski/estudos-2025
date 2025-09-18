## Livro do Conhecimento - Arquitetura de Software e System Design

### Objetivo do material
    Esse material tem como foco organizar tecnicamente a  estrutura de um ecosistema em TI.
    Com foco em preparação a entervistas de emprego com arquiteto ou senior

### Tópicos
    * capitulo 1 - o que é arquitetura?
    * capitulo 2 - o que é system design ou lousa branca? - entrevista de conhecimento

## capitulo 1 - o que é arquitetura?

# Arquitetura de software é um conjunto de decisões estruturais e organizacionais sobre um sistema. 
É um grande “guarda-chuva” que abrange estilos de distribuição, formas de organização interna, padrões de integração, modelos de execução e práticas transversais. 
Diferente do design detalhado (nível de código), a arquitetura atua no nível macro, definindo como o sistema será construído, mantido e evoluído.

## Logo temos duas grandes áreas:
# 1) Arquitetura de Software (nível macro, decisões estruturais)
   * Estilos de distribuição (como divido o sistema em aplicações/serviços)
   * Estilos de organização interna (como estruturo cada aplicação)
   * Estilos de integração (como partes conversam)
   * Modelos de execução/implantação (onde/como rodam)
   * Abordagens e práticas transversais (que atravessam estilos)
   * Combinações frequentes (composições aplicadas na prática)

# 2) Design Detalhado (nível micro, decisões de implementação) 
   * Princípios fundamentais (guia para escrever bom código)  
   * Padrões de projeto (soluções reutilizáveis para problemas comuns)  
   * Práticas de desenvolvimento 
   * Evolução e manutenção 


# PRIMEIRA GRANDE AREA - Arquitetura de Software (nível macro, decisões estruturais)

## Arquitetura de Software (nível macro, decisões estruturais) 
    1) Estilos de distribuição (como divido o sistema em aplicações/serviços) 
         * Monólito (ou Monólito Modular). monólito em ingles é monolith
         prós e contras: simples de desenvolver, testar e implantar; difícil de escalar e manter com o crescimento.
         * SOA (Service-Oriented Architecture): serviços maiores, compartilhando contratos; geralmente mais acoplados que microservices. 
         prós e contras: facilita integração entre sistemas legados; pode levar a gargalos e complexidade com ESB.
         * Microservices: serviços pequenos e independentes, alinhados a bounded contexts (DDD). 
         obs: bounded contexts são partes do domínio que têm uma linguagem e modelo próprios, podendo ser implementados como microservices separados.
         prós e contras: facilita escalabilidade e manutenção; mais complexo de desenvolver, testar e implantar.
         * Serverless: funções ou containers gerenciados por cloud provider, pagando por uso. 
         prós e contras: reduz overhead de infraestrutura; pode ter limitações de execução e vendor lock-in.  
    2) Estilos de organização interna (como estruturo cada aplicação, seja monólito ou microservice) 
        * Arquitetura em Camadas (Layered): apresentação → domínio → infraestrutura/dados.
        * Arquiteturas com foco no domínio: Hexagonal (Ports & Adapters), Clean, Onion 
    3) Estilos de integração (como partes conversam)
        * Sincrono por API: REST, gRPC, GraphQL (API-Driven).
        * Assíncrono por Mensageria / Event-Driven: Kafka, RabbitMQ, SNS/SQS (pub/sub, event-carried state transfer, 
        * CQRS + Event Sourcing como padrões opcionais). 
    4) Modelos de execução/implantação (onde/como rodam) 
           Containers & Orquestração: Docker + Kubernetes (microservices ou monólitos containerizados). 
           Serverless – FaaS: AWS Lambda, Azure Functions (funções). 
           Serverless – Containers: Cloud Run, AWS App Runner (containers sem gerenciar servidores). 
           BaaS (quando aplicável): Cognito/Auth0, Firebase, etc. (terceiriza capabilities).  
    5) Abordagens e práticas que atravessam estilos 
           DDD (ubiquitous language, bounded contexts, agregados). 
           API-First (OpenAPI, contrato antes do código). 
           Observabilidade e Resiliência (circuit breaker, retry, bulkhead, idempotência). 
           Segurança (Zero-Trust, OAuth2/OIDC, mTLS).  
    6) Combinações frequentes (chame de composições, não “novas arquiteturas”) 
            1. Event-Driven Microservices (Microservices + eventos). 
            2. API-Driven Microservices (Microservices + REST/gRPC/GraphQL). 
            3. Microservices em Containers (K8s) ou Microservices Serverless (Lambda + EventBridge/SQS).
            4. Monólito Modular (Monólito + modularização interna, DDD).
            5. SOA (SOA + ESB).
            6. Serverless + Event-Driven (Lambda + EventBridge)

# SEGUNDA GRANDE AREA - Design Detalhado (nível micro, decisões de implementação)

## Design Detalhado (nível micro, decisões de implementação)
    1. Princípios fundamentais (guia para escrever bom código)
        SOLID: SRP, OCP, LSP, ISP, DIP
        DRY (Don’t Repeat Yourself) e KISS (Keep It Simple, Stupid) - evite duplicação e complexidade desnecessária
        YAGNI (You Aren’t Gonna Need It) - não implemente algo que não é necessário agora
    2. Padrões de projeto (soluções reutilizáveis para problemas comuns)
        Clássicos (GoF): Singleton, Factory, Observer, Strategy, etc.
        Integração: Repository, Unit of Work, DTO, Mapper (abstrair acesso a dados, otimizar comunicação entre camadas).
        Concorrência: Thread Pool, Future, Actor Model (gerenciar múltiplas threads, evitar bloqueios).
    3. Práticas de desenvolvimento
        CI/CD (Integração e Entrega Contínua): automação de build, testes e deploy.
        TDD (Test-Driven Development): escrever testes antes do código para guiar o design.
        Clean Code: legibilidade, simplicidade, nomes significativos, evitar complexidade desnecessária.
    4. Evolução e manutenção
        Refatoração: melhorar o código sem alterar seu comportamento externo, mantendo qualidade a longo prazo.

------------------------------------------------------------------------------------------------------------------------

## SOA - Service Oriented Architecture
Uma abordagem de arquitetura de software onde os sistemas são compostos por serviços independentes que se comunicam entre si.
Cada serviço é responsável por uma funcionalidade específica e pode ser desenvolvido, implantado e escalado de forma independente.
Os serviços se comunicam através de protocolos padrão, como HTTP, SOAP ou REST, permitindo a interoperabilidade entre diferentes tecnologias e plataformas.
👉 Exemplo: um sistema de e-commerce pode ter serviços separados para gerenciamento de produtos, processamento de pagamentos e envio de pedidos.
🔑 Características principais:
Interoperabilidade: serviços podem ser desenvolvidos em diferentes linguagens e plataformas.
Reutilização: serviços podem ser reutilizados em diferentes aplicações.
Escalabilidade: serviços podem ser escalados independentemente conforme a demanda.
Manutenção facilitada: mudanças em um serviço não afetam outros serviços.
🎯 Resposta de entrevista:
"SOA é uma arquitetura onde sistemas são compostos por serviços independentes que se comunicam via protocolos padrão. 
Isso permite interoperabilidade, reutilização e escalabilidade, facilitando a manutenção e evolução dos sistemas."

R: SOA (Service Oriented Architecture) é uma abordagem de arquitetura de software onde os sistemas são compostos por serviços independentes que se comunicam entre si.
Cada serviço é responsável por uma funcionalidade específica e pode ser desenvolvido, implantado e escalado de forma independente.
exemplo: um sistema de e-commerce pode ter serviços separados para gerenciamento de produtos, processamento de pagamentos e envio de pedidos.
SOA é diferente de microsserviços porque os serviços em SOA tendem a ser maiores e mais acoplados, enquanto os microsserviços são menores, mais focados e independentes.
SOA geralmente usa protocolos padrão como SOAP ou REST para comunicação, enquanto microsserviços podem usar uma variedade de protocolos, incluindo REST, gRPC, eventos, etc.
SOA pode envolver um barramento de serviço (ESB) para mediar a comunicação entre serviços, enquanto microsserviços geralmente evitam esse tipo de centralização para manter o desacoplamento.

um SOA é um microsserviço?
R: Não, SOA (Service Oriented Architecture) e microsserviços são abordagens diferentes de arquitetura de software.
SOA é uma abordagem mais ampla que envolve a criação de serviços independentes que se comunicam entre si, mas esses serviços podem ser maiores e mais acoplados.
Microsserviços, por outro lado, são uma forma específica de SOA onde os serviços são menores, mais focados e independentes.
Em resumo, todos os microsserviços podem ser considerados parte de uma arquitetura SOA, mas nem todos os serviços em uma arquitetura SOA são microsserviços.

                       2 - EDA (Event-Driven Architecture) - Arquitetura Orientada a Eventos
                           Uma abordagem de arquitetura de software onde os sistemas são projetados para reagir a eventos.
                           Um evento é uma mudança de estado ou uma ação que ocorre em um sistema, como a criação de um novo pedido ou a atualização de um perfil de usuário.
                           Os componentes do sistema se comunicam através da publicação e assinatura de eventos, permitindo um alto grau de desacoplamento e escalabilidade.
                           👉 Exemplo: em um sistema de e-commerce, quando um pedido é criado, um evento "PedidoCriado" é publicado. Outros serviços, como o serviço de pagamento e o serviço de envio, podem assinar esse evento e reagir a ele de forma independente.
                           🔑 Características principais:
                               Desacoplamento: componentes não dependem diretamente uns dos outros.
                               Escalabilidade: componentes podem ser escalados independentemente.
                               Resiliência: falhas em um componente não afetam todo o sistema.
                               Flexibilidade: novos componentes podem ser adicionados facilmente.
                           🎯 Resposta de entrevista:
                           "EDA é uma arquitetura onde sistemas reagem a eventos, permitindo desacoplamento, escalabilidade e resiliência. 
                           Componentes se comunicam via publicação e assinatura de eventos, facilitando a evolução do sistema."
                       3 - Service Mesh - uma camada de infraestrutura dedicada para gerenciar a comunicação entre serviços em uma arquitetura de microsserviços.
                           Ele fornece funcionalidades como descoberta de serviços, balanceamento de carga, autenticação, autorização, criptografia, monitoramento e rastreamento distribuído.
                           O service mesh atua como um intermediário entre os serviços, interceptando e gerenciando o tráfego de rede.
                           👉 Exemplo: Istio, Linkerd e Consul são exemplos populares de service meshes.
                           🔑 Características principais:
                               Descoberta de serviços: localiza serviços dinamicamente.
                               Balanceamento de carga: distribui tráfego entre instâncias de serviço.
                               Segurança: autenticação e autorização entre serviços.
                               Monitoramento: coleta métricas e logs de tráfego.
                               Rastreio distribuído: acompanha requisições através de múltiplos serviços.
                           🎯 Resposta de entrevista:
                           "Service mesh é uma camada de infraestrutura que gerencia a comunicação entre microsserviços, 
                           fornecendo descoberta, balanceamento, segurança e monitoramento. 
                           Ele facilita a gestão do tráfego e melhora a resiliência do sistema."
                       4 - API-Driven Architecture (API Gateway, API First, REST, gRPC, GraphQL) - Uma abordagem de arquitetura onde APIs são o principal meio de comunicação entre sistemas e componentes.
                           As APIs expõem funcionalidades e dados de forma padronizada, permitindo que diferentes aplicações e serviços interajam de maneira consistente.
                           👉 Exemplo: um sistema de e-commerce pode expor APIs para gerenciamento de produtos, processamento de pagamentos e envio de pedidos.
                           🔑 Características principais:
                               Padronização: APIs seguem padrões como REST, gRPC ou GraphQL.
                               Desacoplamento: sistemas podem evoluir independentemente.
                               Reutilização: APIs podem ser consumidas por múltiplas aplicações.
                               Segurança: controle de acesso e autenticação via tokens, OAuth, etc.
                           🎯 Resposta de entrevista:
                           "API-Driven Architecture é uma abordagem onde APIs são o principal meio de comunicação entre sistemas. 
                           Isso promove padronização, desacoplamento e reutilização, facilitando a integração e evolução dos sistemas."
                       5 - Event-Driven Microservices - Combina a arquitetura de microsserviços com a orientação a eventos.
                           Cada microsserviço é projetado para reagir a eventos, permitindo um alto grau de desacoplamento e escalabilidade.
                           Os microsserviços se comunicam através da publicação e assinatura de eventos, facilitando a integração e a evolução do sistema.
                           👉 Exemplo: em um sistema de e-commerce, quando um pedido é criado, um evento "PedidoCriado" é publicado. Outros microsserviços, como o serviço de pagamento e o serviço de envio
                       5 - Client-Server (modelo clássico de integração) - REST, SOAP, gRPC;
                       6 - Peer-to-Peer (P2P, blockchain, torrents, WebRTC) - comunicação direta entre sistemas;
                       7 - Message-Driven (integração via filas e mensageria) - RabbitMQ, Kafka, SQS, etc;
                       8 - Choreography e Orchestration (padrões de coordenação em microsserviços) - Saga Pattern, BPMN, Camunda, etc;
                       9 - ESB (Enterprise Service Bus) - uma abordagem centralizada para integração de sistemas empresariais.
                           O ESB atua como um barramento de comunicação que conecta diferentes aplicações e serviços, facilitando a troca de mensagens e a orquestração de processos.

                   4 - Princípios e Boas Práticas de Arquitetura: abordagens que guiam como projetar e implementar. Sendo:
                       1 - API-First - uma abordagem de design de APIs onde a API é projetada e documentada antes do desenvolvimento da aplicação.
                           Isso garante que a API atenda às necessidades dos consumidores e facilite a integração entre sistemas.
                           👉 Exemplo: usar OpenAPI/Swagger para definir endpoints, métodos, parâmetros e respostas antes de codificar.
                           🔑 Benefícios principais:
                               Foco no consumidor: API projetada com base nas necessidades dos usuários.
                               Documentação clara: especificação serve como contrato entre equipes.
                               Consistência: padrões e convenções são definidos antecipadamente.
                               Facilita testes: APIs podem ser testadas independentemente da aplicação.
                           🎯 Resposta de entrevista:
                           "API-First é uma abordagem onde a API é projetada e documentada antes do desenvolvimento da aplicação. 
                           Isso garante foco no consumidor, documentação clara e consistência, facilitando a integração entre sistemas."

                       2 - Domain-Driven Design (DDD);
                           Uma abordagem de design de software criada por Eric Evans (2003) que tem como foco o domínio do negócio.
                           A ideia é alinhar o código com a linguagem e regras do negócio, garantindo que o sistema reflita fielmente os processos reais da empresa.
                           👉 Em vez de começar pela tecnologia, começa-se pelo entendimento do domínio.
                           🔑 Conceitos principais
                               Ubiquitous Language (Linguagem Ubíqua)
                                   Um vocabulário comum entre devs e especialistas do negócio.
                                   Essa linguagem deve aparecer no código, na modelagem e nas conversas.
                                   Exemplo: se o negócio fala “Adesão”, no código deve existir Adesao, não SubscriptionEntity.
                               Bounded Context (Contexto Delimitado)
                                   Divide o sistema em módulos claros e independentes.
                                   Cada contexto tem sua própria linguagem e modelo de domínio.
                                   Evita confusão quando a mesma palavra tem significado diferente em áreas distintas.
                                   Exemplo: “Cliente” pode significar usuário do app em um contexto, mas conta bancária em outro.
                               Entities (Entidades)
                                   Objetos que têm identidade única e persistem ao longo do tempo.
                                   Exemplo: Cliente com CPF 123 permanece o mesmo, mesmo que troque de endereço.
                               Value Objects (Objetos de Valor)
                                   Não têm identidade própria; são definidos apenas por seus atributos.
                                   Exemplo: Endereco (Rua, Cidade, CEP).
                               Aggregates (Agregados)
                                   Conjunto de entidades e objetos de valor com uma raiz agregadora (Aggregate Root) que controla a consistência. 
                                   Exemplo: Pedido (raiz) contém Itens. Só manipulo os itens através do Pedido. 
                               Repositories (Repositórios) 
                                   Camada que abstrai o acesso a dados. 
                                   Exemplo: PedidoRepository para buscar/salvar pedidos. 
                               Domain Services 
                                   Regras de negócio que não pertencem a uma única entidade. 
                                   Exemplo: cálculo de frete que depende de pedido + localização.
                           🎯 resposta de entrevista:
                                   "DDD é uma abordagem que foca no domínio do negócio, alinhando código e linguagem com as regras reais da empresa. 
                                   Conceitos como Linguagem Ubíqua, Contextos Delimitados e Agregados ajudam a criar sistemas mais claros, 
                                   flexíveis e alinhados com o negócio."

                       3 - Twelve-Factor App - um conjunto de boas práticas para construir aplicações SaaS (Software as a Service) escaláveis e resilientes.
                           Por que usar o Twelve-Factor?
                               Desenvolvido por Heroku, é um guia prático para criar apps que funcionam bem em ambientes cloud.
                               Ajuda a evitar armadilhas comuns em desenvolvimento e deployment.
                               Promove consistência, portabilidade e facilidade de manutenção.
                           Os 12 fatores:
                               01 - Codebase – uma base de código, versionada em Git. 
                               02 - Dependencies – dependências declaradas (não embutidas no sistema). 
                               03 - Config – configurações devem ficar no ambiente, não no código. 
                               04 - Backing services – tratar bancos, filas, caches como recursos externos plugáveis. 
                               05 - Build, release, run – separar bem o que é build, release e execução. 
                               06 - Processes – aplicação executada como processos stateless. 
                               07 - Port binding – expor serviços via porta, sem depender de servidor de aplicação externo. 
                               08 - Concurrency – escalar clonando processos, não aumentando threads. 
                               09 - Disposability – inicializar e encerrar rápido (facilita deploy/rollback). 
                               10 - Dev/prod parity – ambiente de dev o mais próximo possível do prod. 
                               11 - Logs – logs tratados como fluxo contínuo de eventos. 
                               12 - Admin processes – tarefas administrativas como processos pontuais. 

                       quando falamos de build, release e run, o que é cada um?
                           R: 
                               Build: processo de transformar o código fonte em um artefato executável. Inclui compilação, testes e empacotamento.
                               Release: combinação do artefato de build com a configuração específica do ambiente. Prepara a aplicação para ser executada.
                               Run: execução da aplicação no ambiente de produção ou outro ambiente. A aplicação deve ser stateless e escalável.

                           usamos algumas ferramentas para cada etapa?
                               R: 
                                   Build: ferramentas como Maven, Gradle, npm, Docker.
                                   Release: ferramentas como Jenkins, GitLab CI/CD, Spinnaker.
                                   Run: plataformas como Kubernetes, AWS ECS, Heroku.

                           quanto ao jenkins, gitlab ci/cd e spinnaker, o que cada um faz?
                               R: 
                                   - Jenkins: ferramenta de automação de código aberto para integração contínua e entrega contínua (CI/CD). 
                                   Permite criar pipelines personalizadas para build, teste e deploy.
                                   - GitLab CI/CD: parte do GitLab que oferece funcionalidades integradas de CI/CD. 
                                       Permite definir pipelines diretamente no repositório GitLab, facilitando a automação do ciclo de vida do desenvolvimento.
                                   - Spinnaker: plataforma de entrega contínua focada em deploys multi-cloud. 
                                   Facilita a gestão de releases, rollbacks e estratégias de deploy como blue-green e canary.

                       4 - SOLID;
                           S – Single Responsibility Principle (SRP)
                               Cada classe deve ter uma única responsabilidade.
                               Facilita testes e manutenção.
                               ❌ Errado: uma classe Relatorio que gera PDF, envia e-mails e salva no banco.
                               ✅ Certo: GeradorRelatorio, EmailService, RelatorioRepository.
                               DICA BONUS -> S (SRP) e C (SRP + coesão) → deixam as classes menores e focadas (isso indiretamente reduz acoplamento).
                               Por que não usar SRP? Às vezes, dividir demais pode complicar a navegação no código.
                           O – Open/Closed Principle (OCP)
                               Classes devem estar abertas para extensão, mas fechadas para modificação.
                               Usar abstrações para permitir adicionar novas regras sem alterar código existente.
                               Exemplo: estratégia de cálculo de imposto com Imposto (interface) → ICMS, ISS.
                               DICA BONUS -> O (OCP) → aberto para extensão, fechado para modificação → incentiva baixo acoplamento via herança/polimorfismo.
                               Por que não usar OCP? Pode levar a hierarquias complexas se exagerar.
                           L – Liskov Substitution Principle (LSP)
                               Subtipos devem poder substituir seus tipos base sem quebrar o programa.
                               ❌ Errado: Ave com método voar(), e Pinguim herdando Ave.
                               ✅ Certo: separar em AveQueVoa e AveQueNaoVoa.
                               DICA BONUS -> L (LSP) → reforça a substituição sem quebrar dependências → acoplamento saudável.
                               Por que não usar LSP? Às vezes, a modelagem do domínio não se encaixa perfeitamente.
                           I – Interface Segregation Principle (ISP)
                               Interfaces devem ser pequenas e específicas.
                               ❌ Errado: interface Funcionario com métodos dirigir(), programar(), cozinhar().
                               ✅ Certo: Motorista, Programador, Cozinheiro.
                               DICA BONUS -> I (ISP) → divide interfaces para evitar dependência desnecessária.
                               Por que não usar ISP? Muitas interfaces podem complicar a implementação.
                           D – Dependency Inversion Principle (DIP)
                               Depender de abstrações, não de implementações.
                               Exemplo: PagamentoService deve depender de uma interface GatewayPagamento, não diretamente de PaypalAPI.
                               DICA BONUS -> D (DIP) → o mais ligado diretamente a baixo acoplamento.
                               Por que não usar DIP? Pode adicionar complexidade com muitas abstrações.

                           Por que ter baixo acoplamento?
                               Facilita manutenção e evolução.
                               Permite testes unitários mais isolados.
                               Reduz impacto de mudanças.
                               Melhora reutilização de componentes.
                           O que é baixo acoplamento?
                               Componentes independentes, com poucas dependências entre si.
                               Mudanças em um componente não afetam outros.
                               Comunicação via interfaces ou eventos, não chamadas diretas.                

                           Agora, juntando tudo:
                               S (SRP) e C (SRP + coesão) → deixam as classes menores e focadas (isso indiretamente reduz acoplamento).
                               O (OCP) → aberto para extensão, fechado para modificação → incentiva baixo acoplamento via herança/polimorfismo.
                               L (LSP) → reforça a substituição sem quebrar dependências → acoplamento saudável.
                               I (ISP) → divide interfaces para evitar dependência desnecessária.
                               D (DIP) → o mais ligado diretamente a baixo acoplamento.

                           Pensando em solid, pra cada uma das letrinhas temos solucoes que ajudam a reduzir acoplamento.
                           segue pra cada letrinha um conjunto de patterns ou solucoes que ajudam a reduzir acoplamento:
                               S (SRP) → Coesão alta, Classes pequenas e focadas.
                               O (OCP) → Herança, Polimorfismo, Estratégia.
                               L (LSP) → Substituição segura, Modelagem correta.
                               I (ISP) → Interfaces específicas, Segregação de responsabilidades.
                               D (DIP) → Injeção de Dependência, Inversão de Controle, Abstrações.

                           Os designs patterns comuns para cada letra sao:
                               S (SRP) → Factory Method, Builder.
                               O (OCP) → Strategy, Decorator.
                               L (LSP) → Template Method, Adapter.
                               I (ISP) → Facade, Proxy.
                               D (DIP) → Dependency Injection, Service Locator.

                       5 - Clean Architecture
                           Clean Architecture é uma abordagem de arquitetura em camadas proposta pelo Uncle Bob, 
                           onde as regras de negócio ficam no centro e são independentes de frameworks, banco de dados ou UI. 
                           Ela separa o sistema em entidades, casos de uso, adaptadores e infraestrutura, promovendo baixo acoplamento, 
                           alta testabilidade e facilidade de evolução.
                           Muita gente confunde Clean Architecture com Hexagonal Architecture porque ambas têm a mesma filosofia central:
                               👉 regra de negócio no centro, detalhes técnicos nas bordas. 
                                   Mas existem diferenças: 
                                   🔹 Pontos em comum
                                           Foco em independência de frameworks.
                                           Regra de negócio não depende de banco, mensageria, UI.
                                           Facilita testabilidade.
                                           Usa inversão de dependência (DIP).
                                   🔹 Diferenças
                                           Hexagonal Architecture (Ports & Adapters) – proposta por Alistair Cockburn (2005)
                                           Mais simples e pragmática.
                                           Estrutura o sistema em:
                                           Core (domínio) → regra de negócio.
                                           Ports (interfaces) → definem contratos de entrada e saída.
                                           Adapters → implementam os ports para conectar banco, APIs, UI, etc.
                                           Muito usada em DDD e microserviços.
                                           👉 Exemplo:
                                           Port: RepositorioDePedidos.
                                           Adapter: RepositorioDePedidosPostgres.
                                           Core: PedidoService.
                           🎯 Resposta de entrevista:
                           “Clean Architecture organiza o software em camadas concêntricas, mantendo as regras de negócio independentes 
                           de frameworks, banco ou UI. Já a Hexagonal, ou Ports & Adapters, é mais pragmática e foca em definir contratos 
                           (ports) e implementações (adapters). As duas compartilham a ideia central de manter a regra de negócio no núcleo 
                           e detalhes técnicos na borda.”

                       6 - Design for Failure
                           É um princípio de arquitetura em sistemas distribuídos/cloud.
                           A ideia é:
                           👉 Não projetar assumindo que tudo sempre vai funcionar.
                           👉 Projetar assumindo que falhas são inevitáveis (rede cai, servidor morre, API externa falha). 
                           Como aplicar: 
                               Retries com backoff e jitter (repetir chamadas de forma controlada). 
                               Circuit breaker (abrir o circuito e parar de tentar chamar um serviço que está instável). 
                               Bulkheads (isolar recursos para que falhas não derrubem o sistema inteiro). 
                               Timeouts curtos (não deixar requisições travarem indefinidamente). 
                               Fallbacks (resposta alternativa quando o serviço principal falhar).

                       7 - Observability First
                           Observability First é projetar sistemas com métricas, logs e tracing desde o início, 
                           garantindo que o time consiga entender o que acontece em produção e agir rapidamente em incidentes

                       8 - Security by Design.
                           é o princípio de projetar sistemas considerando segurança desde o início: autenticação, autorização, criptografia e defesa em camadas.

## capitulo 2 - o que é system design ou lousa branca? - entrevista de conhecimento
    Em uma entrevista de system design ou lousa branca, nao comece desenhando!
    O objetivo da entrevista de system design é chegar no "nao sei". Estranho é alguem saber de tudo! 
    
    https://www.youtube.com/watch?v=JHavVCLQT4k
 
    FENCAFA - FENCAFA é um acrônimo que pode ajudar a lembrar os principais aspectos a considerar ao projetar um sistema:
        F - Functional Requirements (Requisitos Funcionais)
        E - External Systems (Sistemas Externos)
        N - Non-Functional Requirements (Requisitos Não Funcionais)
        C - Constraints (Restrições)
        A - Assumptions (Suposições)
        F - Future Growth (Crescimento Futuro)
        A - Architecture (Arquitetura)

    Mais sobre o FENCAFA:
        1 - Functional Requirements (Requisitos Funcionais)
            O que o sistema deve fazer? Quais são as principais funcionalidades e casos de uso?
            Exemplo: autenticação de usuários, upload de arquivos, busca de produtos.
        2 - External Systems (Sistemas Externos)
            Quais sistemas externos o sistema precisa integrar? APIs, bancos de dados, serviços de terceiros?
            Exemplo: integração com gateway de pagamento, serviço de email, banco de dados relacional.
        3 - Non-Functional Requirements (Requisitos Não Funcionais)
            Quais são os requisitos de performance, escalabilidade, segurança e disponibilidade?
            Exemplo: o sistema deve suportar 1000 requisições por segundo, ter 99.9% de uptime.
        4 - Constraints (Restrições)
            Quais são as limitações técnicas ou de negócio? Orçamento, prazo, tecnologias obrigatórias?
            Exemplo: deve usar AWS, orçamento limitado, prazo de 3 meses.
        5 - Assumptions (Suposições)
            Quais são as suposições feitas durante o design? Volume de usuários, crescimento esperado?
            Exemplo: espera-se 10.000 usuários no primeiro ano, crescimento de 20% ao mês.
        6 - Future Growth (Crescimento Futuro)
            Como o sistema pode crescer no futuro? Escalabilidade, novas funcionalidades, mudanças de tecnologia?
            Exemplo: deve ser fácil adicionar novos módulos, suportar aumento de carga.
        7 - Architecture (Arquitetura)
            Qual é a arquitetura geral do sistema? Monolito, microsserviços, serverless?
            Exemplo: usar microsserviços para permitir escalabilidade independente, arquitetura orientada a eventos.
    
 
## Micro Serviços e Monólitos
    Análise comparativa entre arquiteturas monolíticas e de microserviços, discutindo os cenários em que cada abordagem se destaca.
    * Monólito: tudo em um único deploy, mais simples de desenvolver e testar, mas pode ser difícil de escalar e manter.
    * Microserviços: serviços independentes, mais complexos de desenvolver e testar, mas facilitam a escalabilidade e a manutenção.
    * Quando usar cada um: monólito para projetos pequenos e médios, microserviços para sistemas grandes e complexos. 

#### <font color = orange><b> Confuso Domínios de Software (DDD) </b></font>
    Exploração dos fundamentos do Domain-Driven Design e sua aplicação para modelar sistemas alinhados com as necessidades do negócio.

#### <font color = orange><b> Sistemas Operacionais e Protocolos de Rede </b></font>
    Visão sobre o papel dos sistemas operacionais no gerenciamento de recursos e na execução de aplicações distribuídas. 
    Fundamentos dos principais protocolos de rede que possibilitam a comunicação entre sistemas distribuídos.

#### <font color = orange><b> Comunicação Síncrona – HTTP, RPC, gRPC, REST </b></font>
    Estudo dos mecanismos de comunicação síncrona, fundamentais para a integração entre serviços.
    * Bom para: leitura rápida, fluxos request/response do usuário (checkout, login), consistência imediata.
    * Riscos: acoplamento temporal (se “Cascão” cai, “Cebolinha” sente), cascata de latências.
    * Mitigações: timeouts curtos, retries com jitter, circuit breaker, budgets de latência, bulkheads, backpressure, idempotência.

#### <font color = orange><b> Comunicação Assíncrona – Mensageria, Eventos e Streaming </b></font>
    Exploração dos métodos de comunicação assíncrona que permitem o desacoplamento e a escalabilidade dos sistemas.

#### <font color = orange><b> Load Balancers e Proxies Reversos </b></font>
    Entenda como os load balancers e proxies reversos distribuem o tráfego e contribuem para a alta disponibilidade dos sistemas.

#### <font color = orange><b> API Gateways e BFF's (Backend For Frontend) </b></font>
    Aprenda sobre o papel dos API Gateways na centralização de acessos, segurança e gerenciamento das comunicações entre clientes e serviços. 
    Descubra como o padrão BFF pode otimizar a comunicação entre front-end e back-end, adaptando APIs para diferentes clientes.

#### <font color = orange><b> Storage (RAID, IOPs, Throughput) </b></font>
    Fundamentos do armazenamento, com foco nas tecnologias e métricas que garantem a performance e confiabilidade.

#### <font color = orange><b> Teoria CAP, ACID e BASE (SQL e NoSQL) </b></font>
    Estudo dos fundamentos teóricos que regem a consistência e a disponibilidade dos dados em sistemas distribuídos.
    entendendo cada um deles: 
        CAP: Consistency, Availability, Partition Tolerance. 
            Em sistemas distribuídos, só dá pra garantir 2 dos 3 ao mesmo tempo.
            Exemplo: se a rede cai (Partition Tolerance), você pode escolher entre Consistency (todos veem os mesmos dados) 
            ou Availability (o sistema continua respondendo).
        ACID: Atomicity, Consistency, Isolation, Durability. 
            Propriedades que garantem transações confiáveis em bancos de dados relacionais.
            Exemplo: uma transferência bancária deve ser atômica (ou tudo acontece ou nada acontece).
        BASE: Basically Available, Soft state, Eventual consistency. 
            Abordagem mais flexível usada em bancos NoSQL.
            Exemplo: um sistema de redes sociais pode ser basicamente disponível (você pode ver posts mesmo se alguns servidores estiverem fora), 
            ter estado temporário (dados podem mudar com o tempo) e consistência eventual (todos verão a mesma informação eventualmente).

        por que não usar ACID?
            R: ACID pode ser mais lento e menos escalável em sistemas distribuídos, especialmente quando há alta latência de rede. 
            Em cenários onde a performance e a disponibilidade são mais críticas que a consistência imediata, BASE pode ser uma escolha melhor.
        por que não usar BASE?
            R: BASE pode levar a inconsistências temporárias e comportamentos inesperados, o que 
            pode ser problemático em sistemas que exigem alta integridade dos dados, como sistemas financeiros.
        por que não usar CAP?
            R: O teorema CAP é uma simplificação e não cobre todos os aspectos de sistemas distribuídos. 
            Em muitos casos, é possível mitigar as limitações do CAP com técnicas avançadas de design e arquitetura. 
            por exemplo, usando replicação e particionamento de dados.


#### <font color = orange><b> Cache e Normalização de Dados </b></font>
    Introdução às estratégias de cache para melhorar a performance e a escalabilidade das aplicações. 
    Aprenda as técnicas de normalização que garantem a integridade e a eficiência dos bancos de dados relacionais.

#### <font color = orange><b> Paralelismo e Concorrência </b></font>
    Compreensão dos conceitos de paralelismo e concorrência e seu impacto no design de sistemas de alta performance.

#### <font color = orange><b> Performance, Capacidade e Escalabilidade </b></font>
    Abordagem dos conceitos e métricas essenciais para medir e otimizar a performance dos sistemas.

#### <font color = orange><b> Sharding e Particionamento de Dados </b></font>
    Técnicas de particionamento que permitem distribuir a carga de dados, melhorando a performance e a escalabilidade.

#### <font color = orange><b> Replicação de Dados e CQRS </b></font>
    Estudo dos mecanismos de replicação para garantir a disponibilidade e a resiliência dos dados em sistemas distribuídos. 
    Introdução ao padrão Command Query Responsibility Segregation e suas vantagens na separação das operações de leitura e escrita.

#### <font color = orange><b> Saga Pattern e Event Sourcing </b></font>
    Entenda o padrão Saga para orquestrar transações distribuídas de maneira robusta e resiliente. 
    Descubra como o Event Sourcing pode transformar a forma de armazenar e gerenciar o estado dos sistemas.

#### <font color = orange><b> Modelos de Deployment </b></font>
    Análise dos diferentes modelos de deployment e estratégias para atualizações seguras e contínuas.

#### <font color = orange><b> Monitoramento e Observabilidade </b></font>
    Fundamentos para garantir a visibilidade e o controle sobre o comportamento dos sistemas em produção.
        1. Conceitos Fundamentais
            * Monitoramento: acompanhar métricas e eventos conhecidos.
            👉 Exemplo: O Seu Madruga fica de olho no aluguel. Ele sabe o que esperar: todo mês o Sr. Barriga aparece. 
            Isso é monitorar algo conhecido.
            
            * Observabilidade: entender o estado interno do sistema a partir de dados externos, mesmo em cenários desconhecidos.
            👉 Exemplo: Quando o Chaves some da vila, a Chiquinha junta pistas (barulho, rastros de comida, vizinhos falando) para descobrir o que está acontecendo. 
            Ela não tinha um alarme pronto para isso, mas usa sinais para observar.
            
            🔑 Diferença:
            Monitoramento = detectar problemas conhecidos.
            Observabilidade = investigar causas, mesmo de problemas imprevistos.
        
        2. Pilares de Observabilidade (The Three Pillars) 
            Logs
                Registro de eventos (texto estruturado ou não).
                Ex.: erro no login, status de uma requisição, exception.
                Chaves: correlação, nível de severidade, estruturados (JSON).
                👉 Exemplo: O Kiko anota no caderninho cada vez que o Chaves bate nele. Isso é log.
                Ferramentas Comuns: Logs: ELK Stack, Loki, Splunk.
            
            Métricas
                Valores numéricos que indicam saúde e performance.
                Ex.: latência, CPU, throughput, TPS, Apdex.
                Boa prática: definir SLOs e SLIs.
                👉 Exemplo: O Sr. Barriga mede quantos meses sem receber aluguel = métrica.
                Ferramentas Comuns: Métricas: Prometheus, CloudWatch, Datadog, New Relic, Micrometer.
            
            Traces
                Rastreamento de requisições distribuídas.
                Ex.: request entra pelo BFF, passa pelo SRV, vai para o DB. Cada etapa gera spans.
                👉 Exemplo: Descobrir por onde passou o sanduba de presunto da Dona Florinda até chegar ao Chaves = trace.
                Ferramentas: OpenTelemetry, Jaeger, Zipkin.
        
        3. Práticas Essenciais
            Dashboards: visualizações (Grafana, Kibana).
            Alertas: thresholds e regras (Prometheus Alertmanager, PagerDuty, OpsGenie).
            Acompanhamento de Logs: ELK Stack, Loki.
            Tracing distribuído: OpenTelemetry + Jaeger.
            Correlações: logs, métricas e traces precisam conversar.
        
        4. Conceitos Avançados
            four Golden Signals (Google SRE book) (para a experiencia como um todo):
                Latência = quanto demora pra responder?!
                Tráfego = quantas requests estao acontecendo?! Uma black friday é uma boa. Mas subir do nada?! ae nao!
                Erros = erros na visao do usuário
                Saturação = fila na cpu, mais consumo... saturou!!!
            
            RED Method (para microserviços):
                Rate =  quantidade de erros por segundo!
                Errors = erros na aplicacao
                Duration = quanto tempo pro componente responder?
            
            USE Method (para infraestrutura):
                Utilization = cpu 60%, ex. Tamanho de banda, ex.
                Saturation =  o mesmo do 4 golden signals
                Errors = pacotes, erros, recursos etc
        
        5. Ferramentas Comuns
            Dashboards: Grafana, Kibana.
            Alertas: PagerDuty, OpsGenie, VictorOps.
        
        6. Práticas de Engenharia
            SLO / SLI / SLA
                SLA = contrato (comercial).
                SLO = objetivo (técnico).
                SLI = métrica medida.
            
            👉 Exemplo:
            SLA: O Chaves pode comer no máximo 1 sanduba por dia.
            SLO: Meta é que ele coma em 95% dos dias só 1.
            SLI: Monitorar a quantidade real de sandubas comidos.
            
            Chaos Engineering: testar a resiliência quebrando partes do sistema.
            Budgets de Erro: medir quanto erro é aceitável antes de frear deploys.
            Circuit Breakers: cortar chamadas em cascata.
            Backpressure: controlar fluxo de dados.
        
        7. Diferença na Prática
            Monitoramento tradicional: "Está UP ou DOWN?"
            Métricas prontas.
            Observabilidade moderna: "Por que ficou lento ontem só às 17h?"
            Permite investigar.
        
        8. Perguntas Frequentes em Entrevista 
            O que é observabilidade? 
            Qual a diferença entre logs, métricas e traces?
            O que são Golden Signals?
            Como implementar tracing distribuído em microserviços?
            Como definir SLOs e SLIs?
            Quais ferramentas você já usou para monitoramento e observabilidade?
            Como correlacionar logs, métricas e traces num incidente?
            Como funciona o RED Method?

#### <font color = orange><b> Orquestração de Containers e Service Meshes </b></font>
    Introdução ao gerenciamento de containers e à orquestração com Kubernetes para ambientes escaláveis. 
    Entenda como os service meshes facilitam a comunicação, segurança e observabilidade entre microserviços.

#### <font color = orange><b> Two-Phase Commit </b></font>
    Mecanismo para garantir a consistência de transações distribuídas, coordenando múltiplos recursos.

    Quando falamos em consistência em sistemas distribuídos, dois padrões comuns são o Two-Phase Commit (2PC) e o Saga Pattern.
    Ambos visam garantir a integridade dos dados, mas funcionam de maneiras diferentes e são aplicados em cenários distintos.

    O mais usado é o Saga Pattern, mas o Two-Phase Commit ainda é relevante em alguns contextos.  

    aonde o two-phase commit se encaixa no saga pattern?
        R: O two-phase commit (2PC) e o saga pattern são ambos mecanismos para garantir a consistência em transações distribuídas, 
            mas eles funcionam de maneiras diferentes e se aplicam a cenários distintos.
        
        1. Two-Phase Commit (2PC):
            O 2PC é um protocolo de commit que garante que todas as partes envolvidas em uma transação distribuída concordem em confirmar ou abortar a transação.
            Ele é composto por duas fases:
                Prepare Phase: O coordenador da transação pergunta a todos os participantes se eles estão prontos para confirmar a transação.
                Commit Phase: Se todos os participantes responderem afirmativamente, o coordenador envia um comando de commit para todos. Se algum participante responder negativamente, o coordenador envia um comando de abort.
            O 2PC é adequado para cenários onde a consistência forte é necessária e onde as operações podem ser bloqueadas até que a transação seja concluída.
            Exemplo: Transferência bancária entre duas contas em bancos diferentes.

        como implementar o two-phase commit no java de forma conceitual e nao se falando de codigo?
        resposta:
            1. Definir um coordenador de transação que gerencie o processo de commit.
            2. Cada serviço participante deve implementar uma interface para preparar e confirmar/abortar a transação.
            3. Na fase de preparação, o coordenador envia uma solicitação para cada serviço participante para verificar se estão prontos para confirmar a transação.
            4. Cada serviço participante realiza as operações necessárias e responde ao coordenador com um status (pronto ou não pronto).
            5. Se todos os participantes estiverem prontos, o coordenador envia um comando de commit para todos os serviços participantes.
            6. Se algum participante não estiver pronto, o coordenador envia um comando de abort para todos os serviços participantes.
            7. Cada serviço participante executa o comando recebido (commit ou abort) e libera quaisquer recursos bloqueados.
            8. O coordenador registra o resultado final da transação (sucesso ou falha) para auditoria e monitoramento.
 
        2. Saga Pattern:
            O saga pattern é uma abordagem para gerenciar transações distribuídas através de uma série de operações locais, 
            cada uma com sua própria compensação.
            Uma saga é composta por uma sequência de transações locais, onde cada transação tem uma ação compensatória 
            que pode desfazer seus efeitos se necessário.
            Se uma transação falhar, as transações anteriores são compensadas para reverter o estado do sistema.
            O saga pattern é mais flexível e tolerante a falhas, permitindo que as operações sejam concluídas de forma assíncrona.
            Exemplo: Processo de compra online, onde várias etapas (adicionar ao carrinho, processar pagamento, 
            reservar estoque) podem ser revertidas se uma etapa falhar.
        Resumo:
            O 2PC é mais rígido e garante a consistência forte, mas pode ser bloqueante e menos tolerante a falhas.
            O saga pattern é mais flexível, permitindo operações assíncronas e compensações, mas pode levar a estados intermediários inconsistentes.
        Escolha entre 2PC e saga pattern depende dos requisitos específicos de consistência, tolerância a falhas e desempenho do sistema distribuído em questão.

#### <font color = orange><b> Patterns de Resiliência </b></font> 

https://www.youtube.com/watch?v=LnOK32zvxVg&list=PLZTjHbp2Y7809w3PLM0UE_LgQq6vk49q0

    Resiliência em sistemas distribuídos significa que falhas não são exceção, são a regra. 
    O papel da arquitetura é garantir que, mesmo diante de falhas inevitáveis (rede instável, serviços lentos, 
    APIs externas indisponíveis), o sistema continue útil, estável e recuperável.
    📌 Em resumo: resiliência = tolerar falhas + se recuperar rápido.
    
    Três pilares da resiliência: 
        1 - Tolerância a falhas → o sistema aguenta quando algo quebra (um serviço externo lento, um banco indisponível).
            Ex.: o Chaves tenta comprar um sanduíche, mas se a venda do Seu Madruga caiu, ele busca em outro lugar sem travar a vila. 
        2 - Degradação controlada → melhor entregar uma experiência reduzida do que nada.
            Ex.: se a API de recomendação cai, o e-commerce ainda mostra produtos básicos. 
        3 - Recuperação rápida → o sistema volta ao normal sozinho quando o problema é resolvido, sem precisar de intervenção manual.
        
    Padrões comuns de resiliência: 
        1 - Retry (Tentativas Repetidas) → tentar de novo de forma controlada. 
        2 - Fallback (Plano B) → resposta alternativa quando o serviço principal falhar. 
        3 - Circuit Breaker (Disjuntor) → evita sobrecarregar um sistema instável. 
            🔴 Aberto: falhou muitas vezes → bloqueia chamadas. 
            🟡 Meio-aberto: permite algumas tentativas para testar se voltou. 
            🟢 Fechado: normal, todas as requisições passam.
            Ex.: Igual ao disjuntor da casa da Dona Clotilde: se sobrecarregar, ele desarma para não queimar tudo. 
        4 - Bulkhead (Compartimentos) → isola recursos para que uma falha não derrube o todo. 
        5 - Timeouts curtos → não deixar requisições travarem indefinidamente. 
        6 - Idempotência → garantir que operações repetidas tenham o mesmo efeito, evitando inconsistências em retries. 
        7 - Backpressure → controlar o fluxo de requisições quando o sistema está sob sobrecarga.

#### <font color = orange><b> Testes de Carga e Estresse </b></font>
    Técnicas para validar a performance e a resiliência dos sistemas sob condições extremas de uso.

#### <font color = orange><b> Capacity Planning e Disaster Recovery </b></font>
    Métodos e técnicas para dimensionar os recursos de forma eficiente e antecipar demandas futuras. Estratégias e práticas essenciais para garantir a continuidade dos serviços mesmo diante de falhas catastróficas.

#### <font color = orange><b> Single Point of Failure e TCC Protocol (Try-Confirm-Cancel) </b></font>
    Identifique e elimine os pontos únicos de falha em sistemas críticos para assegurar a alta disponibilidade. Explore o protocolo TCC, uma abordagem flexível para gerenciar transações distribuídas com compensações.

#### <font color = orange><b> Autenticação e Autorização </b></font>
    Mergulhe nos mecanismos de segurança que protegem o acesso e a integridade dos dados nos sistemas distribuídos.

#### <font color = orange><b> Zero-Trust,. Bulkheads e Particionamento </b></font>
    Explore o modelo de segurança Zero-Trust e sua aplicação para fortalecer a proteção dos sistemas modernos. 
    Estudo do padrão Bulkheads para isolar falhas e evitar que problemas em uma parte do sistema afetem o todo.

#### <font color = orange><b> Arquiteturas Celulares e Big Data </b></font>
    Abordagem inovadora das arquiteturas celulares para organizar sistemas complexos de forma escalável e resiliente. Introdução aos conceitos de Big Data e aos desafios de processar e analisar grandes volumes de dados.

#### <font color = orange><b> Analytics e Machine Learning </b></font>
    Exploração das técnicas e ferramentas de análise de dados para extrair insights e suportar decisões estratégicas. Introdução aos fundamentos de Machine Learning e como integrar algoritmos inteligentes em sistemas distribuídos.

um software precisa ser escalável, performático e resiliente. 

qual a versao atualdo spring?
    R: A versão mais recente do Spring Framework é a 6.0.10, lançada em 15 de maio de 2024.
    A versão mais recente do Spring Boot é a 3.1.7, lançada em 15 de maio de 2024.
    A versão mais recente do Spring Security é a 6.1.5, lançada em 15 de maio de 2024.
    A versão mais recente do Spring Data é a 3.1.5, lançada em 15 de maio de 2024.
    A versão mais recente do Spring Cloud é a 2023.0.5, lançada em 15 de maio de 2024.

o que teve de diferente no spring 6?
    R: O Spring Framework 6 trouxe várias mudanças significativas, incluindo:
        Requisitos de Java 17 ou superior.
        Suporte aprimorado para o Jakarta EE 9+ (javax.* para jakarta.*).
        Melhorias na programação reativa com Project Reactor.
        Atualizações no Spring Data, Spring Security e Spring Boot para aproveitar as novas funcionalidades do Java.
        Remoção de APIs obsoletas e melhorias de desempenho.
        Melhor suporte para GraalVM e compilação nativa.
        Melhorias na integração com o Spring Cloud e outras bibliotecas do ecossistema Spring.
        Foco em modularidade e redução do tamanho do runtime.
        Melhorias na documentação e exemplos atualizados.
    Essas mudanças refletem o compromisso do Spring em se manter atualizado com as últimas tendências e tecnologias do desenvolvimento Java.
    Resiliente = aguentar falhas e se recuperar rapido

quero falar do project reactor
    R: O Project Reactor é uma biblioteca para programação reativa em Java, parte do ecossistema Spring. 
    Ele implementa o padrão de programação reativa baseado em fluxos de dados assíncronos e não bloqueantes, 
    permitindo a construção de aplicações altamente escaláveis e responsivas.

    Conceitos principais:
        Flux: representa uma sequência assíncrona de 0 a N elementos.
        Mono: representa uma sequência assíncrona de 0 a 1 elemento.
        Operadores: funções que transformam, filtram ou combinam fluxos (map, flatMap, filter, reduce, etc.).
        Backpressure: mecanismo para controlar o fluxo de dados e evitar sobrecarga.
        Scheduler: abstração para gerenciar threads e execução assíncrona.

    Vantagens:
        Alta escalabilidade e performance.
        Melhor utilização dos recursos do sistema.
        Facilita o tratamento de eventos e streams de dados.
        Integração nativa com o Spring WebFlux para construir APIs reativas.

    Exemplo simples:
        Flux<String> flux = Flux.just("A", "B", "C")
                                .map(String::toLowerCase)
                                .filter(s -> s.startsWith("a"));
        flux.subscribe(System.out::println); // Output: a

    O Project Reactor é ideal para aplicações que exigem alta concorrência, como sistemas web, microserviços e processamento de streams em tempo real.

    Exemplo de resposta em entrevista:
        "O Project Reactor é uma biblioteca de programação reativa para Java, que permite construir aplicações assíncronas e não bloqueantes.
        Ele utiliza os tipos Flux e Mono para representar fluxos de dados, e oferece uma ampla gama de operadores para manipulação desses fluxos.
        Com o Reactor, podemos criar sistemas mais escaláveis e responsivos, especialmente quando integrados com o Spring WebFlux."


e quando falamos de cache, estamos em qual area do system design?
    R: Quando falamos de cache, estamos abordando a área de "Performance e Escalabilidade" dentro do system design. 
    O uso de cache é uma estratégia fundamental para melhorar a performance das aplicações, reduzindo a latência e a carga nos sistemas de backend, 
    como bancos de dados e serviços externos. 

    O cache armazena temporariamente dados frequentemente acessados em uma camada mais próxima do cliente ou da aplicação, 
    permitindo respostas mais rápidas e eficientes. 

    Exemplos comuns de cache incluem:
        Cache em memória (como Redis ou Memcached).
        Cache no lado do cliente (como HTTP caching).
        Cache em CDNs (Content Delivery Networks) para conteúdo estático.

    Em resumo, o cache é uma técnica essencial para otimizar a performance e escalabilidade dos sistemas distribuídos.


e quando falamos de filas, estamos em qual area do system design?
    R: Quando falamos de filas, estamos abordando a área de "Comunicação Assíncrona e Desacoplamento" dentro do system design. 
    As filas são usadas para permitir a comunicação entre diferentes componentes ou serviços de forma assíncrona, 
    o que ajuda a desacoplar os sistemas e melhorar a resiliência e a escalabilidade.

e quando falamos de fallback, estamos em qual area do system design?
    R: Quando falamos de fallback, estamos abordando a área de "Resiliência e Tolerância a Falhas" dentro do system design. 
    O fallback é uma estratégia utilizada para garantir que, mesmo quando um serviço ou componente falha ou está indisponível, 
    o sistema possa continuar funcionando de maneira degradada, oferecendo uma experiência mínima ao usuário.

    O fallback pode ser implementado de várias formas, como:
        Retornar dados em cache.
        Fornecer uma resposta padrão ou alternativa.
        Redirecionar para um serviço secundário ou menos crítico.

    Em resumo, o fallback é uma técnica essencial para aumentar a resiliência dos sistemas distribuídos, 
    garantindo que eles possam lidar com falhas de forma graciosa e continuar operando mesmo em condições adversas. 


uma aplicacao deve ser disponivel, escalavel, performatica e resiliente.
    Disponivel = estar no ar
    Escalavel = lidar com mais carga
    Performatica = rapido
    Resiliente = aguentar falhas e se recuperar rapido

aonde, nesse contexto entra a observablidade e monitoramento?
    R: Observabilidade e monitoramento são componentes essenciais para garantir que uma aplicação seja disponível, escalável, performática e resiliente.

    1. Disponibilidade:
        Monitoramento ajuda a detectar quando a aplicação está fora do ar ou enfrentando problemas.
        Alertas podem ser configurados para notificar a equipe de operações imediatamente.
        Observabilidade permite entender o estado interno da aplicação durante falhas, facilitando a resolução rápida.

    2. Escalabilidade:
        Monitoramento de métricas como uso de CPU, memória e latência ajuda a identificar quando a aplicação precisa escalar.
        Observabilidade permite analisar padrões de tráfego e comportamento do sistema, ajudando a planejar estratégias de escalabilidade.

    3. Performance:
        Monitoramento contínuo das métricas de performance (latência, throughput, erros) ajuda a identificar gargalos.
        Observabilidade fornece insights detalhados sobre o fluxo de dados e operações internas, permitindo otimizações específicas.

    4. Resiliência:
        Monitoramento de falhas e tempos de resposta ajuda a identificar pontos fracos no sistema.
        Observabilidade


    Problemas dos sistemas distribuídos:
        Latência de rede
        Falhas parciais
        Consistência eventual
        Monitoramento e debugging difíceis
        Complexidade operacional

    como mitigar esses problemas?
        Design for Failure
        Observability First
        Security by Design
        Automação e Infraestrutura como Código
        Testes de Resiliência
        Escolha de tecnologias adequadas
        Padrões de Arquitetura
        Princípios SOLID
            S (SRP) → Singleton, Factory.
            O (OCP) → Strategy, Decorator.      
            