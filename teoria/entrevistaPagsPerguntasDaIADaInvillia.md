## 1. Se você tivesse que escolher entre RabbitMQ e Kafka para um novo sistema, quais critérios levaria em consideração? 
Quais cenários favorecem cada tecnologia e por quê? Explique também as principais diferenças entre filas e tópicos em sistemas de mensageria.

    **Resposta:**
    
    A escolha depende de requisitos como latência, throughput, garantia de entrega e retenção.
    
    **RabbitMQ:** ótimo para cenários command/task-based, baixa latência, roteamento flexível (direct, topic, fanout). Ideal para workloads moderadas que exigem ACK por mensagem e flexibilidade no consumo.
    
    **Kafka:** indicado para event streaming em larga escala, retenção longa, reprocessamento e integração de múltiplos consumidores. Alta taxa de transferência e ordenação por partição.
    
    **Fila:** cada mensagem é consumida por apenas um consumidor de um grupo (trabalho único).
    
    **Tópico:** permite múltiplos grupos de consumidores receberem a mesma mensagem (notificação/evento).

---

## 2. Como você utilizaria os serviços AWS (SNS, SQS, S3) para criar uma arquitetura escalável e tolerante a falhas?

    **Resposta:**
    
    **SNS:** pub/sub para difundir eventos a múltiplos consumidores.
    
    **SQS:** filas desacopladas para processar eventos no próprio ritmo, usando DLQ para falhas e filas FIFO quando houver necessidade de ordenação.
    
    **S3:** armazenar dados grandes, históricos ou logs de eventos, e servir de gatilho para processamento (Lambda).
    
    **Combinação:** SNS publica → SQS assina → consumidores processam. Multi-AZ, DLQ e escalonamento automático garantem tolerância a falhas.

---

## 3. Quais métricas você considera essenciais para monitorar em um ambiente de microserviços? Como implementaria a observabilidade? Com quais ferramentas você já trabalhou?

    **Resposta:**
    
    **Métricas técnicas:** latência p95/p99, throughput, erros por tipo, uso de CPU/memória, pool de conexões, filas internas, lag de mensageria.
    
    **Métricas de negócio:** taxa de conversão, pedidos aprovados, tempo médio de checkout.
    
    **Ferramentas:** Prometheus/Grafana, OpenTelemetry para traces, logs estruturados em ELK/OpenSearch, integração com PagMon.
    
    **Boas práticas:** correlação de logs por traceId, dashboards unificados, alertas proativos.

---

## 4. Em um sistema distribuído onde dois microsserviços se comunicam via Kafka, como você estruturaria essa comunicação? 
Quais configurações essenciais você aplicaria no Producer e no Consumer para garantir confiabilidade e performance? E como lidaria com falhas de entrega, duplicidade de mensagens e ordenação?

**Resposta:**

**Modelagem:** tópicos por evento, chave de partição por agregado para ordenação, contrato via Schema Registry.

**Producer:** acks=all, enable.idempotence=true, retries alto, compressão (snappy/zstd), linger.ms e batch.size otimizados.

**Consumer:** commit manual (enable.auto.commit=false), controle de max.poll.interval.ms, tratamento de exceções e DLQ.

**Falhas:** retry topic com backoff, DLQ para mensagens inválidas.

**Duplicidade:** idempotência no app com chave de negócio em cache/banco.

**Ordenação:** 1 consumer por partição para manter sequência.

---

## 5. Explique como você projetaria um banco de dados para um sistema de alta escala. Quando optaria por SQL vs NoSQL?

**Resposta:**

**SQL:** para consistência forte, transações ACID e integridade relacional. Escalabilidade via read replicas, particionamento e cache.

**NoSQL:** para alta taxa de escrita/leitura, flexibilidade de schema e escalabilidade horizontal, modelando dados pelo padrão de acesso.

Escolha depende de requisitos de consistência (CAP), volume de dados, e tipo de consulta.

Em alta escala, adoto CQRS, índices otimizados e caches para aliviar carga do banco.

---

## 6. Imagine que você está liderando uma equipe DevOps em um projeto crítico com múltiplos desenvolvedores trabalhando simultaneamente. Como você utilizaria Git-Flow para gerenciar releases, hotfixes e branches de desenvolvimento, garantindo integração contínua e minimizando conflitos? Quais práticas avançadas você recomendaria para otimizar esse fluxo?

**Resposta:**

**Branches:** main (prod), develop (integração), feature/*, release/*, hotfix/*.

**Release:** congela features, foca em bugfix, merge em main + tag, back-merge para develop.

**Hotfix:** cria da main, corrige, merge em main e develop.

**Práticas avançadas:** PRs pequenos, code review, integração contínua com testes e análise de qualidade (Sonar), uso de feature flags para deploy contínuo, proteção de branches, versionamento semântico.

---

## 7. Quais recursos introduzidos no Java 16 ou superior você já utilizou, como records, sealed classes, ou melhorias no Pattern Matching? Explique como esses recursos funcionam e em quais cenários você os considera vantajosos.

**Resposta:**

**Records:** DTOs imutáveis com menos código, ideais para transporte de dados.

**Sealed classes:** controlam quais classes podem estender uma hierarquia, úteis para modelar domínios fechados.

**Pattern Matching para instanceof e switch:** reduz boilerplate e melhora legibilidade.

**Text Blocks:** strings multilinha, úteis para JSON e SQL.

Esses recursos trazem imutabilidade, segurança de tipo e código mais limpo.

---

## 8. Imagine que precisamos criar um ecommerce com alta demanda. Esporadicamente vamos realizar campanhas televisivas que gerarão acessos elevados em determinados momentos. 
A busca de nosso ecommerce também será bastante requisitada, sendo que muitos usuários pesquisam pelo mesmo produto várias vezes ao dia. 
Como você estruturaria este projeto visando resolver os problemas relatados? Lembre-se que precisamos garantir escalabilidade, resiliência e rapidez.

**Resposta:**

Escala horizontal via Kubernetes com auto scaling.

CDN + cache para páginas e imagens.

Busca em Elasticsearch/OpenSearch com cache Redis para termos mais buscados.

Checkout isolado (bulkhead) para proteger pagamento em picos.

Mensageria (Kafka/SQS) para operações não críticas.

Banco: SQL para transações, NoSQL para catálogo e sessões.

Feature flags para desligar partes não essenciais em picos.

---

## 9. Como você implementaria uma arquitetura de microserviços resiliente utilizando Java? Descreva os padrões que utilizaria para garantir alta disponibilidade.

**Resposta:**

**Padrões:** Circuit Breaker, Retry com backoff, Bulkhead, Timeout, Rate Limiting, Idempotência.

**Ferramentas:** Resilience4j, Spring Cloud, Service Mesh (Istio/Linkerd).

**Deploy:** Blue/Green ou Rolling, health checks e readiness probes.

**Observabilidade:** métricas, logs e tracing.

**Config centralizada** com fallback local.

---

## 10. Em um sistema de microserviços, como você lidaria com transações distribuídas que envolvem múltiplos serviços e bases de dados?

**Resposta:**

Evitar 2PC.

Usar Sagas (coreografia ou orquestração) com eventos compensatórios.

Outbox Pattern para garantir atomicidade entre gravação no banco e publicação de eventos.

Idempotência nos handlers para tolerar reprocessamento.

---

## 11. Como você abordaria a implementação de uma feature que exige alta performance e precisa processar grandes volumes de dados em tempo real?

**Resposta:**

**Pipeline:** ingestão via Kafka, processamento com Kafka Streams ou Flink, armazenamento otimizado (Redis/Elastic/S3).

**Uso de serialização binária** (Avro/Protobuf).

**Particionamento e paralelismo controlado.**

**Monitoramento de lag e throughput.**

---

## 12. Na sua experiência com Java, quais os trade-offs entre utilizar um ORM como Hibernate/JPA e JDBC puro? Cite quais cenários você recomendaria cada abordagem, considerando aspectos como performance, produtividade e manutenibilidade.

**Resposta:**

**ORM:** +produtividade, abstração, menos código repetitivo; -overhead, N+1 queries, tuning complexo. Bom para CRUDs e domínio rico.

**JDBC puro:** +performance e controle; -mais código e manutenção. Bom para queries complexas ou de alto volume.

Uso combinado em projetos grandes (ORM + JDBC/jOOQ para hotspots).

---

## 13. Descreva como você configuraria um aplicativo Spring Boot para um ambiente de produção de alta disponibilidade. Cite quais recursos específicos do Spring Boot (como profiles, externalized configuration, actuators) você utilizaria e como implementaria métricas personalizadas.

**Resposta:**

**Profiles:** separar configs de QA/Prod.

**Externalized config:** Spring Cloud Config, AWS SSM ou Vault.

**Actuator:** health/readiness/liveness, métricas via Micrometer.

**Custom métricas:** Counter, Timer para KPIs de negócio.

**Segurança:** TLS, OAuth2, headers HTTP.

**Logs estruturados** e correlação de traceId.

---

## 14. Descreva sua experiência na identificação e resolução de problemas em sistemas concorrentes, como deadlocks, race conditions e contenção de recursos. 
Cite um caso específico onde você precisou resolver um problema de concorrência.

**Resposta:**

**Caso:** deadlock em transações SQL por ordem de locks inconsistente.

**Ação:** análise via pg_stat_activity, thread dumps; padronização da ordem de acesso às tabelas, redução do escopo da transação e índices adicionais.

**Resultado:** remoção do deadlock e ganho de performance.

---

## 15. Como você implementaria feature flags em uma aplicação Java para permitir lançamentos graduais? 
Explique a importância da utilização de feature flags e o potencial risco de não utilizarmos dessa metodologia.

**Resposta:**

**Ferramentas:** Unleash, Togglz, LaunchDarkly.

**Uso:** rollout gradual por porcentagem, região ou perfil de usuário.

**Importância:** desacoplar deploy de release, testar em produção com segurança, rollback instantâneo.

**Risco de não usar:** necessidade de rollback via novo deploy, exposição a todos os usuários ao mesmo tempo.

---

## 16. Quais estratégias você utiliza para garantir a qualidade do código? Como você implementaria uma pipeline de CI/CD com Jenkins que inclua testes e análise de Sonar?

**Resposta:**

**Estratégias:** code review, testes unitários/integrados, análise estática, padrões de codificação, cobertura mínima.

**Jenkins pipeline:** stages para build, testes, análise SonarQube, segurança (OWASP Dependency Check), deploy em QA, testes automatizados, aprovação manual e deploy em Prod.

---

## 17. Descreva uma situação em que você precisou refatorar um código legado para melhorar sua manutenibilidade. 
Qual foi sua abordagem e quais princípios de Clean Code você aplicou?

**Resposta:**

**Abordagem:** criar testes de caracterização, extrair métodos, remover duplicações, aplicar nomes claros, reduzir acoplamento e aumentar coesão.

**Princípios:** SRP, DRY, KISS, código autoexplicativo, pequenas funções.

---

## 18. Que estratégias você usa para mentorar desenvolvedores mais junior? 
Como você equilibra o tempo entre mentoria e suas próprias entregas?

**Resposta:**

**Mentoria:** pair programming, code review com feedback construtivo, roadmap de aprendizado, incentivo a documentação e POCs.

**Equilíbrio:** timeboxing de sessões, delegação gradual de responsabilidades, priorização de tarefas críticas.

---

## 19. Você foi designado para criar uma API RESTful para gerenciamento de usuários em um sistema. 
A API deve permitir operações de criação, leitura, atualização e exclusão de usuários. 
Quais boas práticas você adotaria para garantir que essa API siga os princípios RESTful? 
Como você estruturaria os endpoints e utilizaria os métodos HTTP adequadamente? 
Cite também como lidaria com versionamento, autenticação, autorização, códigos de status HTTP e tratamento de erros.

**Resposta:**

**Endpoints:** POST /v1/users, GET /v1/users/{id}, PUT/PATCH /v1/users/{id}, DELETE /v1/users/{id}, GET /v1/users?filter=.

**Métodos HTTP adequados** e idempotência onde necessário.

**Versionamento no path** (/v1).

**Segurança:** OAuth2/JWT, RBAC.

**Códigos HTTP corretos** (201 para criação, 204 para deleção, 400/404/409 para erros).

**Tratamento de erros** com payload padronizado (code, message).

---

## 20. Como você estrutura seus testes unitários em projetos Java? Quais boas práticas você segue para garantir que os testes sejam confiáveis, legíveis e de fácil manutenção? Pode citar ferramentas que costuma utilizar e como você lida com mocks e dependências externas?

**Resposta:**

**Estrutura:** Given-When-Then, 1 assert principal por teste, nomes claros.

**Boas práticas:** isolamento de dependências, evitar mocks desnecessários, manter testes rápidos.

**Ferramentas:** JUnit 5, Mockito, Testcontainers, WireMock.

**Dependências externas:** mocks/stubs ou containers temporários para evitar acoplamento a serviços reais.