## Livro do Conhecimento

### Objetivo do material
    Esse material tem como foco organizar tecnicamente a  estrutura de um ecosistema em TI.
    Com foco em preparação a entervistas de emprego com arquiteto ou senior

### Tópicos
    * capitulo 1 - o que é arquitetura?
    * capitulo 2 - o que é system design ou lousa branca? - entrevista de conhecimento

## capitulo 1 - o que é arquitetura?
    Arquitetura é um conceito muito amplo. Podemos estar falando de muita coisa no mundo de TI. É um grande guarda-chuva 
    de conhecimentos. Pode ser:
    1 - arquitetura de negócios: processos, regras e objetivos;

    2 - arquitetura de software: como será construido, organizado e mantido. Sendo:
        1 - monólito;
        2 - serviços distribuídos (ex framework de processamento distribuído de dados);
        3 - micro serviços (pois nem todo serviço distribuiído é um MS!)
        4 - Serverless

    3 - arquitetura de sistemas/aplicações: como os sistemas se conversam (integração entre sistemas). Sendo:
        1 - SOA
        2 - EDA (Event-Driven Architecture)
        3 - Service Mesh 
        4 - API-Driven Architecture (API Gateway, API First, REST, gRPC, GraphQL);
        5 - Client-Server (modelo clássico de integração);
        6 - Peer-to-Peer (P2P, blockchain, torrents, WebRTC);
        7 - Message-Driven (integração via filas e mensageria);
        8 - Choreography e Orchestration (padrões de coordenação em microsserviços).

    4 - Princípios e Boas Práticas de Arquitetura: abordagens que guiam como projetar e implementar. Sendo:
        1 - API-First

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

        3 - Twelve-Factor App
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

        4 - SOLID;
            S – Single Responsibility Principle (SRP)
                Cada classe deve ter uma única responsabilidade.
                Facilita testes e manutenção.
                ❌ Errado: uma classe Relatorio que gera PDF, envia e-mails e salva no banco.
                ✅ Certo: GeradorRelatorio, EmailService, RelatorioRepository.
                DICA BONUS -> S (SRP) e C (SRP + coesão) → deixam as classes menores e focadas (isso indiretamente reduz acoplamento).
            O – Open/Closed Principle (OCP)
                Classes devem estar abertas para extensão, mas fechadas para modificação.
                Usar abstrações para permitir adicionar novas regras sem alterar código existente.
                Exemplo: estratégia de cálculo de imposto com Imposto (interface) → ICMS, ISS.
                DICA BONUS -> O (OCP) → aberto para extensão, fechado para modificação → incentiva baixo acoplamento via herança/polimorfismo.
            L – Liskov Substitution Principle (LSP)
                Subtipos devem poder substituir seus tipos base sem quebrar o programa.
                ❌ Errado: Ave com método voar(), e Pinguim herdando Ave.
                ✅ Certo: separar em AveQueVoa e AveQueNaoVoa.
                DICA BONUS -> L (LSP) → reforça a substituição sem quebrar dependências → acoplamento saudável.
            I – Interface Segregation Principle (ISP)
                Interfaces devem ser pequenas e específicas.
                ❌ Errado: interface Funcionario com métodos dirigir(), programar(), cozinhar().
                ✅ Certo: Motorista, Programador, Cozinheiro.
                DICA BONUS -> I (ISP) → divide interfaces para evitar dependência desnecessária.
            D – Dependency Inversion Principle (DIP)
                Depender de abstrações, não de implementações.
                Exemplo: PagamentoService deve depender de uma interface GatewayPagamento, não diretamente de PaypalAPI.
                DICA BONUS -> D (DIP) → o mais ligado diretamente a baixo acoplamento.

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
 
## Micro Serviços e Monólitos
    Análise comparativa entre arquiteturas monolíticas e de microserviços, discutindo os cenários em que cada abordagem se destaca.

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
            👉 Exemplo: Quando o Chaves some da vila, a Chiquinha junta pistas (barulho, rastros de comida, vizinhos falando) para descobrir o que está acontecendo. Ela não tinha um alarme pronto para isso, mas usa sinais para observar.
            
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
    Introdução ao gerenciamento de containers e à orquestração com Kubernetes para ambientes escaláveis. Entenda como os service meshes facilitam a comunicação, segurança e observabilidade entre microserviços.

#### <font color = orange><b> Two-Phase Commit </b></font>
    Compreenda o protocolo Two-Phase Commit e seu papel na garantia da integridade em transações distribuídas.

#### <font color = orange><b> Patterns de Resiliência </b></font>
    Introdução aos padrões de resiliência, com foco em estratégias como retry e fallback para manter a estabilidade dos sistemas. 
    Vamos também explorar mecanismos avançados como circuit breakers e bulkheads.   

    Quando falamos de resiliência em sistemas distribuídos, a ideia é simples:
        👉 garantir que mesmo diante de falhas inevitáveis (rede instável, serviços lentos, APIs externas indisponíveis), a aplicação continue funcionando de forma estável e recuperável.
        
    Esses padrões são fundamentais em arquiteturas modernas (como microsserviços) porque ajudam a evitar cascatas de falhas.

    1. Retry (Tentativas Repetidas)
    2. Fallback (Plano B)
    3. Circuit Breaker (Disjuntor) = O que é: Evita sobrecarregar um sistema que já está falhando. 
        Funcionamento: 
        🔴 Aberto: Falhou muitas vezes → bloqueia chamadas diretas. 
        🟡 Meia-aberto: Permite algumas tentativas para ver se voltou. 
        🟢 Fechado: Normal, todas as requisições passam. 
        Exemplo: Igual ao disjuntor da casa da Dona Clotilde. Se sobrecarregar, ele desarma para não queimar tudo.
    4. Bulkhead (Compartimentos)

#### <font color = orange><b> Testes de Carga e Estresse </b></font>
    Técnicas para validar a performance e a resiliência dos sistemas sob condições extremas de uso.

#### <font color = orange><b> Capacity Planning e Disaster Recovery </b></font>
    Métodos e técnicas para dimensionar os recursos de forma eficiente e antecipar demandas futuras. Estratégias e práticas essenciais para garantir a continuidade dos serviços mesmo diante de falhas catastróficas.

#### <font color = orange><b> Single Point of Failure e TCC Protocol (Try-Confirm-Cancel) </b></font>
    Identifique e elimine os pontos únicos de falha em sistemas críticos para assegurar a alta disponibilidade. Explore o protocolo TCC, uma abordagem flexível para gerenciar transações distribuídas com compensações.

#### <font color = orange><b> Autenticação e Autorização </b></font>
    Mergulhe nos mecanismos de segurança que protegem o acesso e a integridade dos dados nos sistemas distribuídos.

#### <font color = orange><b> Zero-Trust,. Bulkheads e Particionamento </b></font>
    Explore o modelo de segurança Zero-Trust e sua aplicação para fortalecer a proteção dos sistemas modernos. Estudo do padrão Bulkheads para isolar falhas e evitar que problemas em uma parte do sistema afetem o todo.

#### <font color = orange><b> Arquiteturas Celulares e Big Data </b></font>
    Abordagem inovadora das arquiteturas celulares para organizar sistemas complexos de forma escalável e resiliente. Introdução aos conceitos de Big Data e aos desafios de processar e analisar grandes volumes de dados.

#### <font color = orange><b> Analytics e Machine Learning </b></font>
    Exploração das técnicas e ferramentas de análise de dados para extrair insights e suportar decisões estratégicas. Introdução aos fundamentos de Machine Learning e como integrar algoritmos inteligentes em sistemas distribuídos.

