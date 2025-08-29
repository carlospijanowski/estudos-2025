🧪 1. Teste Unitário
✅ O que é:
Testa métodos ou classes isoladamente, sem dependência externa (banco, fila, etc.).

🔧 Ferramentas/frameworks:

JUnit 5 – framework principal de testes Java

Mockito – para mockar dependências em Java

MockK – para Kotlin

🧠 Observações:

Base de todo projeto.

Roda rápido, e costuma ter cobertura de 70~90%.

🔗 2. Teste de Integração
✅ O que é:
Garante que os componentes funcionam juntos: controller, service, repository, banco, etc.

🔧 Ferramentas/frameworks:

@SpringBootTest – carrega o contexto completo

Testcontainers – roda banco real em container (ex: PostgreSQL, Redis)

Embedded H2 – banco em memória

@Transactional – garante rollback entre testes

🧠 Observações:

Muito comum em microserviços e aplicações Spring Boot.

Mais lento, mas muito confiável.

🌐 3. Teste de API (REST/Contract)
✅ O que é:
Testa endpoints HTTP: status, corpo da resposta, headers.

🔧 Ferramentas/frameworks:

Rest Assured – DSL fluente para testar APIs

MockMvc – usado com Spring Web sem subir servidor

Pact – para contract testing entre produtor e consumidor

🧠 Observações:

Muito usado em pipelines de CI.

Pact é obrigatório em times que adotam consumer-driven contracts.

🔒 4. Teste de Segurança (Autenticação e Autorização)
✅ O que é:
Testa regras de roles, tokens JWT, autenticação, CSRF, headers.

🔧 Ferramentas/frameworks:

Spring Security Test – anotações como @WithMockUser

JWT mockado

Keycloak Test (em arquiteturas com Identity Provider)

🧠 Observações:

Fundamental em aplicações com login/autorização.

Requer cuidado com cenários de permissões inválidas.

🏗 5. Teste de Arquitetura
✅ O que é:
Garante que pacotes e camadas respeitam a arquitetura (ex: hexagonal, DDD, etc.)

🔧 Ferramentas/frameworks:

ArchUnit – define e executa regras de arquitetura como testes

ArchTest – estilo anotado

🧠 Observações:

Evita "atalhos" perigosos no código (ex: controller chamando repository direto).

Muito usado em times maduros e com padrões de arquitetura bem definidos.

🧼 6. Teste de Validação de Dados
✅ O que é:
Testa se validações nos DTOs (campos obrigatórios, tamanho, regex, etc.) estão funcionando.

🔧 Ferramentas/frameworks:

Bean Validation (javax.validation / jakarta.validation)

@Valid, @NotNull, @Size, @Pattern etc.

Testes com MethodArgumentNotValidException

🧠 Observações:

Muito útil pra evitar bugs no início da requisição.

Evita validar regra de negócio onde não deve.

🧪 7. Testes com Banco Real (via Testcontainers)
✅ O que é:
Roda testes usando bancos reais como PostgreSQL, Mongo, Redis… via Docker.

🔧 Ferramentas/frameworks:

Testcontainers – integra Docker nos testes

Integra com JUnit 5, Spring Boot

Roda containers durante os testes

🧠 Observações:

Muito útil pra garantir compatibilidade real.

Usado quando mocks não são suficientes (ex: queries específicas, índice).

📈 8. Teste de Performance / Carga
✅ O que é:
Avalia tempo de resposta, throughput, estabilidade sob carga alta.

🔧 Ferramentas/frameworks:

Apache JMeter – clássico e poderoso

k6 – moderno e programável (em JS)

Gatling – alternativa com DSL própria

🧠 Observações:

Usado em ambientes de staging ou stress test.

Pode ser integrado à pipeline.

📊 9. Cobertura de Código
✅ O que é:
Mede quantas linhas do seu código estão cobertas por testes.

🔧 Ferramentas/frameworks:

JaCoCo – gera relatórios de cobertura

SonarQube – mostra cobertura + code smells

IntelliJ Coverage Tool

🧠 Observações:

Útil para métricas e alertas de código sem testes.

Cobertura alta não garante qualidade, mas ajuda.

📄 10. Testes de Contrato entre Serviços (Consumer-Driven Contracts)
✅ O que é:
Garante que o produtor de uma API mantenha contrato com o consumidor.

🔧 Ferramentas/frameworks:

Pact – padrão ouro para Contract Testing

Spring Cloud Contract – alternativa Spring

🧠 Observações:

Muito usado em ambientes com muitos microserviços.

Evita que mudanças quebrem consumidores.

✅ Tabela Resumo Final
Tipo de Teste	Ferramentas/Frameworks principais
Unitário	JUnit 5, Mockito, MockK
Integração	SpringBootTest, Testcontainers, H2
API/REST	Rest Assured, MockMvc, Pact
Segurança	Spring Security Test, JWT Mock
Arquitetura	ArchUnit, ArchTest
Validação de Dados	Bean Validation (@Valid, @NotBlank, etc.)
Banco com container	Testcontainers (PostgreSQL, Redis, Mongo)
Performance/Carga	JMeter, Gatling, k6
Cobertura de Código	JaCoCo, SonarQube
Contratos entre serviços	Pact, Spring Cloud Contract