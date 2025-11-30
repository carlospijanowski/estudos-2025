# 🇬🇧 English Interview Practice Script
 
#### Introduction 
Okay, let’s start!  
Here I'm known as Cartaxo. You can call me Cartaxo.
when you don’t practice, you forget a few things.
One of my _main goals_ is _to work on_ an international project — to keep improving my English skills.
I can handle most work situations in English — reading, understanding business rules, and discussing technical topics.
Back in 2023, I went to Europe — one of my goals was to practice my English.
I went to Europe and visited some countries.
i visited London.
That same year, I also had the opportunity to be part of a team that included some English colleagues.
In that project, I was involved in several business decisions, mainly because I was the Tech Lead

--- 

#### Personal Life
Hi, my name is Carlos. 
I’m 47 years old, married, and i have two daughters.  
I live in Itajaí, Its a coastal city in southern Brazil.  
In my free time, I love going to the beach, exploring new places, and spending time with my family.  
Cycling is my favorite sport — it’s how I stay active and recharge my batteries

--- 

#### Academic Background
I graduated in Information Systems, and later I completed two postgrad courses in IT — one in Software Engineering and 
another focused on Java for Web development.

---

#### Falar um pouquinho sobre outras atividades como sou dev, teach lead e arquiteto de software
I’ve had experience as a developer, tech lead, and architect, and I really enjoy all three roles.

- As a developer:
  I like being hands-on — coding in Java and Kotlin,
  solving problems, and
  making services faster and more reliable.
  Besides development, I also take care of the delivery side — adjusting pipelines in Jenkins, improving CI/CD steps,
  managing deployments, and configuring Kubernetes.
  I spend a good amount of time looking at logs, traces, dashboards, and overall observability to keep the systems healthy and reliable.

- As a tech lead, I enjoy helping the team, unblocking people, and making sure we’re aligned on good practices and clean design.

- as an architect, I focus on the bigger picture —
  building scalable, resilient solutions and making decisions that keep the system healthy over time.

What I like the most is being flexible. If the team needs me coding, I code. If they need guidance, I jump in and support.
If they need someone thinking about architecture and trade-offs, I’m comfortable doing that too.
I like working in a collaborative environment, helping people grow, and making sure we deliver something solid together.

---

## Pagseguro
Currently, I work as a Senior Software Engineer at PagSeguro, for the bank industry. it belongs to the financial area
since 2009
my technical stack is revolving around the java and kotlin
IN THE BACKEND side
Besides development and coding, I also participate in important technical decisions, review my teammates’ code, and contribute to system architecture.
We have around ten applications written in Kotlin and java, and my main role is to implement solutions based on business needs.
We hold business meetings, refinement sessions, and technical discussions to define the best approaches for implementation.

Lately, I’ve been working a lot on infrastructure-related tasks.
Recently, I’ve been involved in adapting PagSeguro’s CI pipelines, as we’re migrating from AWS to PagSeguro’s private cloud.
All deployments are done in Kubernetes (K8s).

So, to summarize, I currently work as a Senior Software Engineer handling business-driven demands, 
participating in development refinements with my teammates, and also managing infrastructure tasks — such as Kubernetes deployments, 
services, and ingress manifests — basically everything related to running our applications in K8s.

My daily routine at PagBank basically involves attending daily meetings, participating in technical refinement sessions for new features, 
deploying applications to staging and production environments, and investigating production issues whenever they occur.

I work in the account security domain.
My team is responsible for password matching and password recovery processes.
In addition to business and infrastructure tasks, I also investigate production issues through application monitoring and log analysis.

---

#### Em que situacoes falou em ingles para trabalho?


#### Relevant Projects
    Every project comes with its own challenges, particularities, and unique aspects.
    I can say I have some preferences, such as working with the latest versions of Java and Kotlin.
    I also prefer using the most up-to-date versions of the Spring Boot framework.
    I enjoy working with distributed systems because an application should be available, scalable, maintainable, performant, and resilient.

--- 

#### Challenges Faced
    So, for me the really challenging part is migrating a monolith to microservices while keeping the data consistent. 
    You know, in a monolith you usually rely on ACID transactions — everything is atomic, consistent, isolated, and durable by default. 
    But once you split things into different services, you don’t have those guarantees automatically anymore

---

#### Why Do You Want to Work Here?
    i decided that could a great opportunity professional to work in 

---

#### Thanking the Interviewer
    “Thank you for your time and the opportunity to discuss my background and experience. 
    
---    

#### How Do You See Yourself in 5 Years?
    I don’t worry much about that. 
    I just try to keep up with new tech and software architecture trends. 
    But one of my goals is definitely to work with people from different countries. to improve my communication skills

---

#### Strengths and Weaknesses
> “My main strength is problem-solving — I stay calm under pressure, analyze issues carefully, and focus on finding effective
> solutions.  
> I’m also very detail-oriented and committed to code quality.
>
> As for weaknesses, I sometimes take too much responsibility because I want everything to go perfectly.  
> I’ve been working on delegating more and trusting others to take ownership as well.”
---
#### Technical Challenge Example
> “One technical challenge I faced was dealing with **event ordering issues in a Kafka-based system**.  
> Messages were arriving out of order, which caused data inconsistencies.  
> To solve it, I introduced a unique reference ID for each message and implemented logic to ensure the correct correlation between input
> and output events.  
> This approach improved consistency and allowed the system to handle multiple parallel requests safely.”
---

#### problemas ao entender
“Sorry, could you please repeat that?
My English is a bit rusty — I haven’t practiced as much lately.
But I’m following you”
--- 

 
---

[START]

#### [TAG Scrum & Agile]
**Q:** How familiar are you with Agile methodologies, such as Scrum?  
**A:** I’ve been working in Agile environments for several years.
    My current team follows Scrum — we have daily stand-ups, sprint planning, reviews, and retrospectives.
    I like Agile because it helps teams stay focused, adapt quickly, and continuously deliver value.
 
Grooming sessions are basically meetings where the team reviews and refines the backlog. 
We clarify the business rules, break big stories into smaller ones, discuss edge cases, check dependencies, 
and make sure everything is clear before development starts.
    “We covered all the Kafka requirements during the grooming session.”
    “Let’s schedule a grooming session to refine the new Spring flow.”
    “During grooming we found missing acceptance criteria.”
    “The story looked simple, but once we started grooming we identified some technical challenges.”

#### [TAG Backend & Architecture] HIGH LEVEL
# Arquitetura de Software (nível macro, decisões estruturais)

when we talk about software architecture, we can divide it into three main areas:
### 1 - Distribution Styles, 
### 2 - Internal Organization Styles 
### 3 - Integration Styles
### 4 - Modelos de execução/implantação (onde/como rodam)

### 1 - Distribution Styles (how I divide the system into applications/services)
Monolith (or Modular Monolith)     mónolif
Pros and cons: simple to develop, test, and deploy; difficult to scale and maintain as it grows.

SOA (Service-Oriented Architecture): larger services sharing contracts; usually more tightly coupled than microservices.
Pros and cons: simplifies integration with legacy systems; can lead to bottlenecks and complexity with an ESB.

Microservices: small, independent services aligned with bounded contexts (DDD).
Note: bounded contexts are parts of the domain that have their own language and model, 
and can be implemented as separate microservices.
Pros and cons: improves scalability and maintainability; more complex to develop, test, and deploy.

Serverless: functions or containers managed by a cloud provider, paying only for usage.
Pros and cons: reduces infrastructure overhead; may have execution limits and vendor lock-in.

> ### 2 - Internal Organization Styles (how I structure each application, whether monolith or microservice)
Layered Architecture: presentation → domain → infrastructure/data.
Clean Architecture structures software into concentric layers, ensuring that business rules remain independent of frameworks, 
    databases, and the user interface.
Hexagonal Architecture — also known as Ports and Adapters — 
    takes a more pragmatic approach, emphasizing clear separation between contracts (ports) and their implementations (adapters).
Both architectures share the same core principle: keeping business logic at the heart of the system, while pushing technical details to the outer layers.

### 3 - Integration Styles (how parts communicate)
Synchronous via API:
REST, gRPC, GraphQL (API-Driven).
→ gRPC is a remote communication framework developed by Google that uses HTTP/2 for transport and Protobuf for data serialization.
→ Protobuf (Protocol Buffers) is an efficient and compact data serialization format used to define the structure of messages exchanged between services.

Asynchronous via Messaging / Event-Driven:
Kafka, RabbitMQ, SNS/SQS (pub/sub, event-carried state transfer, CQRS + Event Sourcing as optional patterns).

### 4 - Execution / Deployment Models
Containers & Orquestração: Docker + Kubernetes (microservices ou monólitos containerizados). 

#### [TAG Backend & Architecture] LOW LEVEL
It’s a set of engineering practices that support the architecture by keeping components cohesive, decoupled, and easy to evolve
aqui entra: solid etc

#### [TAG Design & Development Practices]
## Applying development techniques
code quality ia a set of practices that need to work together in harmony.
 
This includes: 
- clean code principles, 
- SOLID, 
- design patterns, 
- test-driven development when appropriate, 
- continuous integration, 
- refactoring, 
- and documentation.
These techniques minimize technical debt, reduce coupling, and help the architecture remain consistent and scalable.

@clean code principles
Meaningful Names
Small, Focused Functions
Single Responsibility Principle (SRP)
Avoid Duplication (Don’t Repeat Yourself) e KISS (Keep It Simple, Stupid) - evite duplicação e complexidade desnecessária
Clear Error Handling (good: throw new CustomerNotFoundException(id); bad:return null;)

@SOLID
S -> Single Responsibility Principle (SRP) [Each class must have a single responsibility]
O -> Open/Closed Principle (OCP) [Classes must be open for extension, but closed for modification]
L -> Liskov Substitution Principle (LSP) [Subtypes must be able to replace their base types without breaking the program]
I -> Interface Segregation Principle (ISP) [Interfaces must be small and specific]
D -> Dependency Inversion Principle (DIP) [Rely on abstractions, not implementations] 

@YAGNI (You Aren’t Gonna Need It) - não implemente algo que não é necessário agora
I also value peer code reviews, static analysis tools like SonarQube, and a solid base of unit tests to maintain a consistent and high-quality codebase.

## Applying engineering techniques
I apply Domain-Driven Design (DDD) to keep business logic organized and modular.
I use TDD when it makes sense, because it helps produce more reliable code with less rework.
In some cases, I use BDD to ensure the system reflects the expected behavior from the user or business perspective.

## In the code workflow and versioning 
Before any merge, we always perform a code review.
We use semantic commits to keep the Git history clean and easy to trace.
And we follow good versioning and workflow practices using Git and GitHub (or GitLab, depending on the project).

@Design patterns
“The three main categories are creational, structural, and behavioral. 
For example, Singleton, Factory Method, and Builder are creational patterns that focus on object creation…”
1**Creational Patterns**
Singleton
Ensures there is only one instance of a class and provides a global point of access to it.
Example: an application-wide ConfigurationManager.

Factory Method
Defines an interface for creating objects, but lets subclasses decide which concrete class to instantiate.
Example: creating different types of PaymentProcessor depending on the payment method.

Builder
Separates the construction of a complex object from its representation, allowing you to build the object step by step.
Example: building an Order object with many optional fields.

**Structural Patterns**
Adapter
Converts the interface of a class into another interface that clients expect.
Example: adapting an external API to match the internal model of your application.

Decorator
Adds extra behavior to an object dynamically, without changing the original class.
Example: adding logging, metrics, or caching around a Service.

Facade
Provides a simple interface to a complex subsystem or set of classes.
Example: a PaymentFacade that orchestrates fraud check, charging, and notification.

**Behavioral Patterns**
Strategy
Defines a family of algorithms and makes them interchangeable at runtime.
Example: different strategies to calculate shipping cost or discounts.

Observer
Defines a one-to-many dependency, where multiple objects are notified automatically when another object’s state changes.
Example: publishing events to listeners when an order is approved.

Chain of Responsibility
Lets you pass a request along a chain of handlers, where each handler decides whether to process the request or pass it to the next one.
Example: a validation pipeline for a request or business rules.
If you want, next I can turn this into a spoken answer like:

---

#### [TAG Security & Communication] 
> We use OAuth2 and JWT tokens for authentication and authorization.
<br> Encryption protects sensitive data in transit and at rest.
<br> gRPC and Protobuf improve performance for inter-service communication.
<br> Every request is logged for tracing and metrics.
<br> Logging, metrics, and tracing are the pillars of observability.
<br> We use Grafana and Prometheus for dashboards and alerting.
<br> OpenTelemetry standardizes our monitoring data.
<br> Splunk and Jaeger help analyze logs and distributed traces.
<br> Circuit breakers prevent cascading failures in distributed systems.
<br> We rely on load testing to assess system performance.

#### [TAG SPRING]
“Spring Boot accelerates backend development in Java. 
It lets us write less code, deal with fewer configuration files, and quickly spin up a new application. 
And thanks to the starters, everything becomes much simpler — dependencies, auto-configurations, and common setups basically work out of the box.”

🔵 Spring Core
“It’s like a box of LEGO pieces: everything is there, but you have to assemble the structure yourself.”
It provides the essentials: IoC, Dependency Injection, ApplicationContext, AOP, and the foundation for Spring MVC and the entire Spring ecosystem. 

🟢 Spring Boot 
It’s like pre-assembled LEGO: most of the heavy lifting is already done. 
It reduces boilerplate and loads automatic configurations based on the dependencies you add. 

🟣 Spring Starters
“It’s like getting pre-assembled LEGO modules: most of the heavy lifting is already done for you.”
It reduces boilerplate, handles configuration automatically, and boots your application using auto-configuration and 
opinionated defaults based on the dependencies you add.


1. Inversion of Control (IoC)
It is the principle where Spring itself controls the lifecycle of objects.
Instead of manually creating instances using new, Spring creates, manages, and provides these objects for you.

2. Dependency Injection (DI)
This is the mechanism Spring uses to apply IoC.
DI automatically injects dependencies into classes (via @Autowired, constructors, etc.).
This reduces coupling and makes the code cleaner, more modular, and easier to test.

3. Spring Container
This is the core of the Spring framework.
The Container is responsible for:
creating objects (beans)
managing their lifecycle
resolving dependencies
applying configurations
Nothing works without the Spring Container.

4. Spring MVC
This is the Spring module used to build REST APIs and web applications following the Model–View–Controller pattern.
It provides:
routing (@Controller, @RestController)
HTTP request handling
JSON serialization
validation mechanisms

5. Spring Data Access (ORM)
This module simplifies data access.
It includes Spring Data JPA, integration with Hibernate, and other ORM technologies.
It greatly reduces boilerplate and automatically generates repository implementations.

6. Simplified Configuration
Spring offers multiple ways to configure an application in a simple and intuitive manner:
annotations (@Component, @Configuration, etc.)
YAML/Properties files
Spring Boot autoconfiguration
This removes the need for the large XML configuration files used in older versions.

7. Real-Time Capabilities
Spring provides support for reactive and real-time applications through:
Spring WebFlux
Streams
Backpressure
Reactive programming
This enables systems to handle thousands of simultaneous connections while consuming minimal resources.

💬 Professional Summary of My Experience with Spring <br>
I work with the full Spring ecosystem. <br>
In Spring Core, I use modules such as spring-core, spring-context, spring-aop, and spring-webmvc, 
which provide IoC, DI, and the foundation of the MVC model. <br>
With Spring Boot, I rely on starters like Web, Data JPA, Security, and Actuator to simplify configuration. <br>
I understand that starters are dependency bundles that automatically configure Spring Core modules. <br>
I also work with Spring Cloud to build microservices with distributed configuration, service discovery, 
resilience, and scalable communication. <br>

📦 Main Spring Stacks I Work With

🌐 Web / REST <br>
spring-boot-starter-web (Spring MVC) <br>
spring-boot-starter-webflux (Reactive) <br>
spring-boot-starter-validation (Jakarta Validation) <br>
jackson-databind (JSON) <br>

🛢️ Persistence & Data <br>
spring-boot-starter-data-jpa (Hibernate) <br>
spring-boot-starter-data-mongodb <br>
spring-boot-starter-data-redis (cache / pub-sub) <br>
spring-boot-starter-jdbc <br>
flyway-core / liquibase-core (migrations) <br>

🔐 Security <br>
spring-boot-starter-security <br>
spring-security-oauth2-client / resource-server

📡 Messaging <br>
spring-kafka <br>
spring-retry, resilience4j-* <br>
spring-amqp (RabbitMQ) <br>

☁️ Integration / Cloud <br>
spring-cloud-openfeign (typed HTTP clients) <br>
spring-cloud-starter-config <br>
eureka-client / consul-discovery <br>
spring-cloud-starter-gateway (API Gateway / BFF)

📊 Observability <br>
spring-boot-starter-actuator <br>
micrometer-registry-* <br>
opentelemetry-exporter-otlp (or auto-instrumentation)

📄 Documentation <br>
springdoc-openapi-starter-webmvc-ui (Swagger UI)

⏱️ Jobs, Batch & Scheduling <br>
spring-boot-starter-batch <br>
@EnableScheduling with Spring Boot

🧪 Testing <br>
spring-boot-starter-test <br>
mockito-core <br>
wiremock-jre8 <br>
testcontainers

🛠️ Quality & Utilities <br>
mapstruct (mapping) <br>
lombok (boilerplate reduction) <br>
hibernate-validator
> 
---
## [TAG JAVA] 
> Build & Dependency Management (Maven, Gradle) 
**Q:** Which build tools do you use?  
**A:** I’ve used both Maven and Gradle. At PagSeguro, most Kotlin projects use Gradle because it’s faster and easier to configure. For older Java projects, I still maintain Maven builds. I like keeping dependencies well-managed and versioned.

> Programming Languages (Java, Kotlin) 
**Q:** Which language do you prefer, Java or Kotlin?  
**A:** I’m comfortable with both, but Kotlin is my favorite for backend development — it’s concise, expressive, and reduces boilerplate code. Still, I appreciate Java’s stability and ecosystem. I switch between them easily depending on the project.

versoes de kotlin que ja trabalhei?

versoes de spring que ja trabalhei?

---
#### [TAG TESTING] Understanding Testing in Backend Development
When we talk about testing, we can actually be referring to several different types of tests within backend development.

We might be talking about unit tests, where we test individual components or functions in isolation. These tests make sure that each small part of the system works as expected.
In Java, for example, we often use frameworks like JUnit and Mockito to create and execute unit tests. JUnit provides the structure for writing the tests, while Mockito helps us mock dependencies, simulating external behavior without needing to connect to real services or databases.

We can also be referring to integration tests. Unlike unit tests, these validate how different parts of the system work together — for example, how a service interacts with a database, or how two microservices communicate through an API. Integration testing ensures that the system behaves correctly as a whole.

Another important type is stress testing (or load testing). These tests check how the system behaves under heavy load — for instance, when thousands of users try to access the same resource at the same time. Stress tests are essential to verify scalability, performance, and resilience, ensuring the system can handle real-world traffic without failures.

We can also talk about mocked tests or simulated tests, often implemented with tools like WireMock. This approach is useful when we want to test interactions with external systems or APIs that are not available or are expensive to call in real time. WireMock lets us create fake endpoints that return predefined responses, allowing consistent and repeatable testing scenarios.

In summary, testing in backend development is not just about checking if the code works — it’s about ensuring reliability, maintainability, and confidence in the software.
A good testing strategy usually combines multiple levels of testing — unit, integration, system, and performance — to cover the system from the smallest function to the most complex real-world scenario.
--- 
>
#### [TAG CI/CD] jenkis etc
> about
<br> **Q:** How do you handle CI/CD in your team?  
<br> **A:** We use Jenkins for our CI/CD pipelines. Every commit triggers automatic builds, tests, and deployments.
<br> We follow a multistage pipeline approach — from QA to production — ensuring every change passes all validations before going live.
<br> CI and CD are ways to deliver code automatically.
<br> there are some tools available.
<br> Right now, I work with Jenkins. I’ve also used Jenkins in other companies before.
<br> But there are other options, like Bitbucket, GitHub Actions, and Azure Pipelines. all of them are good options. 
 
> Continuous Integration (CI) ensures that code changes are automatically tested.
<br> Continuous Deployment (CD) automates the release of new features.
<br> DevOps bridges the gap between development and operations.
<br> Observability helps us understand the system’s behavior in production.
<br> Scalability means the system can handle increasing traffic.
<br> Resilience ensures recovery from failures.
<br> Load balancing distributes traffic evenly among servers.
<br> Fault tolerance allows the system to keep working even if one part fails.
<br> Infrastructure as Code (IaC) lets us manage servers using versioned scripts.
<br> We use a service mesh to handle communication between microservices.
>
## [TAG CLOUD]  
> Cloud Computing (AWS, GCP, Azure)
**Q:** What’s your experience with cloud environments?  
**A:** I mainly work with AWS, using services like S3, SQS, and ECR for our deployments. But we also operate in a private cloud called PagCloud, which makes us a multicloud environment. I like this setup because it gives flexibility and resilience.
>
## [TAG KUBERNETES]  
> Containerization & Orchestration (Docker, Kubernetes) 
**Q:** Do you have experience with Docker or Kubernetes?  
**A:** Yes, I use Docker for building and packaging our applications, and we deploy everything on Kubernetes. I usually define deployments, services, and ingress configurations in YAML. I’ve also worked with blue-green and rollout deployment strategies.
>

[END]
--------------------------------------------------------------------------

## [TAG INVILLIA] 
1. If you had to choose between RabbitMQ and Kafka for a new system, what criteria would you consider?<br>
Which scenarios favor each technology and why? <br>
Also explain the main differences between queues and topics in messaging systems.<br>

When I need to choose between RabbitMQ and Kafka, I first: <br>
- look at the type of communication the system needs 
- and the message volume. 
- I also consider whether the team needs to reprocess events, what the expected latency is, 
and how the consumers are supposed to work.

**RabbitMQ** is great when the system follows a more “do this now” style — tasks and commands. 
- It delivers fast, supports message-level ACKs, and offers flexible routing. 
- It works really well when each message needs to go to a single consumer, and the overall volume isn’t extreme.

**Kafka** shines in high-volume scenarios, especially when the system is event-driven and needs to store messages for longer. 
- It allows multiple consumers to read the same event, keeps ordering within partitions, and makes reprocessing very easy. 
- That’s usually my choice for more complex asynchronous integrations or event-driven observability.

The main difference between a queue and a topic is simple:
- A queue sends each message to one consumer — it’s work distribution.
- A topic lets multiple consumers read the same message — it’s event broadcasting.

---
> 
> 2. Como você utilizaria os serviços AWS (SNS, SQS, S3) para criar uma arquitetura escalável e tolerante a falhas?
> 
> When I build a scalable and fault-tolerant architecture using SNS, SQS, and S3, 
> I usually think of the whole thing as a loose, async pipeline.
> 
> SNS is my event distributor. It lets me notify multiple services at the same time, 
> which already boosts scalability a lot. 
> It’s great when different parts of the system need to react to the same event.
> 
> SQS works as the reliable buffer in the middle. 
> It makes sure no messages get lost, even if a consumer goes down. It also helps handle traffic spikes, 
> because you can scale consumers horizontally as the queue grows.
> 
> S3 is the durable storage for files, logs, or bigger payloads. 
> In many cases, I prefer sending only a “reference” through SNS/SQS and keeping the heavy content in S3. 
> That reduces traffic, speeds things up, and makes consumption easier.
> 
> Overall, I’d use SNS → SQS for a resilient fan-out pattern, and S3 as the central storage for static or large data. 
> This combo gives you a very decoupled architecture, easy to scale, and still works even if one component has issues.
> 
> ---
> 
3. What metrics do you consider essential to monitor in a microservices environment?<br>
   How would you implement observability?<br>
   What tools have you worked with before?

To monitor microservices, I track four essential categories of metrics:
- Infrastructure metrics: CPU, memory, GC activity, thread usage, and container limits.
- Application metrics: p95/p99 latency, error rates, throughput, dependency latency (database, Kafka, REST), 
  and connection-pool behavior.
- Messaging metrics: Kafka consumer lag, queue size, production/consumption rate, DLQ volume, and retries.
- Business metrics: processed orders/events, conversion rates, rule rejections, and end-to-end processing time.

These metrics allow me to monitor not only whether the service is “running,” but whether the business flow is actually healthy.

For observability, I implement the full triad:
- Structured logs with traceId, spanId, correlationId, and consistent JSON formatting.
- Metrics using Micrometer exporting to Prometheus, visualized in Grafana (or equivalent).
- Distributed tracing with OpenTelemetry to follow the entire lifecycle of a request across services.

I’ve worked with ELK, Splunk, New Relic, Datadog, CloudWatch, and Pagmon, as well as Kafka and RabbitMQ 
dashboards for analyzing lag, offsets, and consumer behavior.

This combination gives me the ability to detect bottlenecks, understand business impact, and react quickly during incidents.
 
4. In a distributed system where two microservices communicate via Kafka, how would you structure that communication?

When we implement asynchronous communication to solve a problem, we can easily introduce new problems if we're not careful. <br>
So before designing anything with Kafka, I first think about the risks I want to avoid.<br>
I need to predict some risks I want to avoid<br>
And what would be the main problems I want to prevent when two microservices communicate through Kafka?

Message loss or duplication
- A producer may send the event, but the consumer might not process it — or process it twice.

Event ordering
- Some scenarios must keep the order per entity, like all events for the same customerId or orderId.

Idempotency and reprocessing
- If I need to reprocess a topic or Kafka redelivers the same message, the consumer can’t break the system state.

Contract coupling
- If the payload schema changes, I can’t afford to break every consumer.<br>
That’s why event versioning is important.

Backpressure / speed mismatch
- Producers can publish much faster than consumers can handle.

Error handling
- What do I do with messages that always fail? I need a proper retry strategy and a DLQ.

Observability
- I need to answer: What happened to this event? Did it fail? Who consumed it? Where did it stop?

Security and isolation
- Controlling who can publish and consume each topic.

If I ignore these points, the architecture might work fine in the happy path, but it will become 
a real source of pain in production.

Second: How I would structure the communication between the two microservices using Kafka

To minimize these risks, I’d structure the solution like this:
- Define clear domain events and contracts<br>
- No generic payloads. I’d use explicit events like CustomerCreatedEvent, OrderApprovedEvent, etc.<br>
And I’d use JSON or Avro with a well-defined, versioned schema.
- Topic modeling and keying strategy<br>
I’d create domain-oriented topics such as: customer-events or orders-events.<br>
And I’d use the entity ID (customerId, orderId) as the message key to maintain partition ordering.

- Add important metadata to each event
Things like: eventId (UUID), eventType, correlationId, sourceService, timestamp<br>
This helps with tracking, debugging, and idempotency.

Resilient producer<br>
Service A publishes to the topic with:
- Proper acks
- Retry with backoff
- And for critical cases, I’d use the Outbox pattern so the event is only published after the local transaction succeeds.

Idempotent consumer
- Service B consumes in a consumer group, allowing horizontal scaling.
- Processing must be idempotent: Use eventId or a referenceId and Keep a record of processed events 
to avoid duplicating effects

Structured retry and DLQ
- If processing fails due to a temporary issue:
- Send it to a retry topic with backoff (e.g., orders-events.retry)
- If it fails permanently (bad payload, rule violation):
- Move it to a DLQ (e.g., orders-events.dlq) for manual or specific processing.

Observability
Track metrics like:
- Consumer lag
- Error rate
- Consumption/production rate
- And log with correlationId and eventId, ideally using distributed tracing to connect HTTP requests → Kafka events → consumers.

Security and governance
- Use Kafka ACLs to define who can publish/consume.
- Follow a clear naming convention for topics to simplify governance.
---

5. Explique como você projetaria um banco de dados para um sistema de alta escala. Quando optaria por SQL vs NoSQL?

When I design a database for a high-scale system, I don’t start with “SQL vs NoSQL.” I start with the requirements.

First, I look at the data model and the domain — how the entities relate, whether the structure is complex or 
more aggregate-based.

Then I consider the access patterns — is the system read-heavy or write-heavy, do we query mostly by ID, 
or do we need filters, reports, and joins?

I also check the non-functional requirements — data volume, expected latency, availability, and the level of 
consistency the business needs.

For high scale, I focus on a few pillars:<br>
- a data model aligned to the use cases,
- well-planned indexing and partitioning,
- and replication plus caching (like Redis) to offload the database during traffic spikes.

The idea is that scalability comes from the model + access patterns + infrastructure — not just from picking SQL or NoSQL.

When would I choose SQL?<br> 
- SQL is my choice when I need strong consistency, ACID transactions, and the domain has rich relationships 
and complex rules — things like financial flows, orders, limits, or anything that depends heavily on integrity and joins.

In short: when the business needs highly consistent, well-related data, SQL is usually the right fit.

When would I choose NoSQL? <br>
- I’d pick NoSQL when I’m dealing with massive data volume and need easier horizontal scaling.
- It fits well when the model is aggregate/document-oriented, when I need flexible schema evolution, 
and when the system can tolerate eventual consistency in exchange for low latency and high availability.

In short: when the focus is large scale, flexible schema, and simple access patterns, NoSQL is a strong choice.

---
>
> 6. Imagine que você está liderando uma equipe DevOps em um projeto crítico com 
> múltiplos desenvolvedores trabalhando simultaneamente. 
> Como você utilizaria Git-Flow para gerenciar releases, hotfixes e branches de desenvolvimento, 
> garantindo integração contínua e minimizando conflitos? 
> Quais práticas avançadas você recomendaria para otimizar esse fluxo?

> 7. Which features introduced in Java 16 or later have you already used, such as records, 
> sealed classes, or improvements to Pattern Matching? <br>
> Explain how these features work and in which scenarios you consider them advantageous.
> 
> I started back in the Java 7 days, working with JSF, managed beans, and the typical monolithic architecture 
> approach of that time. As Java evolved, I evolved with it.
> - Java 8 was a big turning point for me — especially with streams, lambdas, and the functional style 
> that changed the way we write business logic.
> - In Java 9, the module system pushed me to think more about boundaries and encapsulation inside large applications.
> - With Java 11, the LTS, most of my production work started to modernize — better performance, 
> the new HTTP client, and cleaner APIs.
> - Moving to Java 17 was another major jump, with records, sealed classes, pattern matching and overall stability. 
> It really changed how we design DTOs, domains, and safer hierarchies.
> - And today, working with Java 21, I’m taking advantage of virtual threads from Project Loom, 
> which has been a huge improvement for concurrency in backend systems.
>
---

8. Imagine que precisamos criar um ecommerce com alta demanda. 
Esporadicamente vamos realizar campanhas televisivas que gerarão acessos elevados em determinados momentos. 
A busca de nosso ecommerce também será bastante requisitada, sendo que muitos usuários pesquisam pelo 
mesmo produto várias vezes ao dia.
Como você estruturaria este projeto visando resolver os problemas relatados? 
Lembre-se que precisamos garantir escalabilidade, resiliência e rapidez.

- For a high-demand ecommerce with traffic spikes caused by TV campaigns, I would focus on CDN, 
caching, stateless services, and distributed processing.

- First, I’d place a CDN in front of all static content and use an API Gateway with rate limiting 
and horizontal scalability through Kubernetes.

- The architecture would be microservices-based, so I can scale the components that 
actually suffer pressure — mainly catalog and search.

- For search, I’d use Elasticsearch / OpenSearch and put Redis in front to cache repeated queries, 
since many users search for the same products multiple times a day.

- For data, I’d keep the catalog in its own database (SQL or NoSQL) and orders in a relational database 
with read replicas to spread the load.
Heavy or external operations (payment, antifraud, emails) would be decoupled using messaging (Kafka, RabbitMQ, SQS) 
to avoid bottlenecks during peak traffic.

- To ensure resilience, I’d apply timeouts, retries, circuit breakers, DLQs, and 
graceful degradation — prioritizing search and checkout over secondary features during TV-campaign peaks.

- Finally, I’d make everything observable with metrics (latency, errors, throughput, lag), structured logs, 
and distributed tracing to quickly identify any bottleneck.

9. How would you implement a resilient microservices architecture using Java? <br>
   Describe the standards you would use to ensure high availability.    

Every system fails. It’s something inevitable!<br>
I design microservices to fail gracefully. <br>
Using Java with Resilience4j!<br>
- I apply circuit breakers, retries, bulkheads, timeouts and fallbacks for each outbound call. 
- I keep services stateless, idempotent, and event-driven. 
- Data uses multi-AZ replicas and the Outbox pattern for consistency. 
- Kubernetes ensures health checks, autoscaling, and safe deployments through blue/green or canary rollout. 
- Observability is built in with metrics, logs, and distributed tracing. 

- The combination of these patterns delivers a highly available and fault-tolerant architecture.

---

10. Em um sistema de microserviços, como você lidaria com transações distribuídas que envolvem múltiplos serviços 
e bases de dados?
In microservices, I avoid classic distributed transactions like 2PC (which creates a single point of failure) 
because they don’t scale and create strong coupling between services.<br>
Instead, I rely on local transactions inside each service and coordinate the overall flow using events 
and compensations, following the Saga pattern.

I usually apply Sagas in two ways:

- Choreography: each service performs its local transaction and publishes an event; the next services react to that event. If something fails, an error event triggers the compensating actions.

- Orchestration: a central orchestrator calls each service in sequence and triggers compensations when needed.

To make this reliable, I ensure:
- Idempotency, so a service can process the same event multiple times without breaking the state.
- The Outbox Pattern, to avoid losing events between the database and the message broker.
- Retries and DLQs, to handle temporary and permanent failures.
- Observability, using correlationId to trace the entire “transaction” across services.

This way, I maintain consistency, low coupling, and resilience across the system—without relying 
on heavy distributed transactions.
---

11. How would you approach implementing a feature that requires high performance and needs to process large volumes 
of data in real time?

A solution needs to be available, scalable, performant, and resilient.

- performance: So the first step is understanding what “real-time high performance” actually means in that context: <br>
the acceptable latency, the data volume per second, the expected SLAs, and the tolerable error rate.

- async: After that, I would design an event-driven architecture to avoid the system getting stuck on slow 
or synchronous operations. <br>
I’d use something like Kafka to ingest and partition the data, allowing multiple consumers to process 
everything in parallel and scale horizontally as the load increases.

- code: In the code itself, I’d focus on fast, asynchronous processing: avoiding blocking operations, 
using batching when it makes sense, and relying on caching (like Redis) for frequently accessed data. <br>
The idea is to keep the critical path as light as possible — without unnecessary remote calls 
that slow down the response.

- observability: To ensure real performance, I’d add observability from the start: latency metrics, throughput, queue size, 
CPU and memory usage, and error rate. With these metrics, I’d run load and stress tests to tune thread counts, 
batch sizes, partitioning strategy, and the number of instances.

- scalable: Finally, I’d make sure the solution can scale horizontally in an elastic environment like Kubernetes, 
and I’d implement backpressure, retry mechanisms, and a DLQ, so the system keeps running smoothly 
even during unexpected spikes.

12. Na sua experiência com Java, quais os trade-offs entre utilizar um ORM como Hibernate/JPA e JDBC puro? 
Cite quais cenários você recomendaria cada abordagem, considerando aspectos como performance, produtividade e manutenibilidade.

13. Descreva como você configuraria um aplicativo Spring Boot para um ambiente de produção de alta disponibilidade.
Cite quais recursos específicos do Spring Boot (como profiles, externalized configuration, actuators) você utilizaria e
como implementaria métricas personalizadas.

14. Descreva sua experiência na identificação e resolução de problemas em sistemas concorrentes, 
como deadlocks, race conditions e contenção de recursos.

15. Como você implementaria feature flags em uma aplicação Java para permitir lançamentos graduais?<br>
A feature flag solves the problem of releasing a feature without having to bet 100% on it from day one.<br>
With feature flags, I can roll out the feature gradually, test it with smaller user groups, compare behavior, <br>
and if something goes wrong, I can turn it off within seconds — without any redeploy.
There are multiple ways to implement this, depending on the context and the requirements.

16. Quais estratégias você utiliza para garantir a qualidade do código? 
Como você implementaria uma pipeline de CI/CD com Jenkins que inclua testes e análise de Sonar?
Eu costumo pensar em qualidade de código em três níveis: como eu escrevo, como o time valida e como o pipeline protege a base de código.

17. Descreva uma situação em que você precisou refatorar um código legado para melhorar sua manutenibilidade.

18. Que estratégias você usa para mentorar desenvolvedores mais junior?
    He is thorough when reviewing pull requests



19. Você foi designado para criar uma API RESTful para gerenciamento de usuários em um sistema.<br>
      A API deve permitir operações de criação, leitura, atualização e exclusão de usuários.<br>
      Quais boas práticas você adotaria para garantir que essa API siga os princípios RESTful?<br>
      Como você estruturaria os endpoints e utilizaria os métodos HTTP adequadamente?<br>
      Cite também como lidaria com versionamento, autenticação, autorização, códigos de status HTTP e tratamento de erros.

## 20. Como você estrutura seus testes unitários em projetos Java? Quais boas práticas você segue para garantir que os testes sejam confiáveis, legíveis e de fácil manutenção? Pode citar ferramentas que costuma utilizar e como você lida com mocks e dependências externas?
**Estrutura:** Given-When-Then, 1 assert principal por teste, nomes claros.
**Boas práticas:** isolamento de dependências, evitar mocks desnecessários, manter testes rápidos.
**Ferramentas:** JUnit 5, Mockito, Testcontainers, WireMock.
**Dependências externas:** mocks/stubs ou containers temporários para evitar acoplamento a serviços reais.

---
 
> 100 Most Useful English Verbs for IT Professionals
1–20: Core Daily Workflow

Build – compile or assemble
We build the project using Maven.
Deploy – send to an environment
We deploy to QA every morning.
Release – publish a new version
We will release 1.2.0 today.
Run – execute
Run the tests before committing.
Test – verify something
Test the endpoint locally.
Fix – correct a problem
I fixed the null pointer issue.
Debug – analyze errors
Let’s debug the failing service.
Improve – make better
We need to improve performance.
Review – check code or docs
Can you review my PR?
Merge – combine branches
We merge to main only after approval.
Commit – send code to Git
Commit with a clear message.
Push – upload to remote
Push your branch when ready.
Pull – download changes
Pull the latest updates before developing.
Refactor – reorganize code
We should refactor this service.
Document – write documentation
Please document the API behavior.
Conf igure – set parameters
Conf igure the Kafka consumer correctly.

Optimize – make more efficient
We optimized the SQL queries.

Validate – check correctness
Validate the input before saving.
>
<br> 
✅ Neutral/Professional:
"Once the code is written, we should test the API."Map – convert from one structure to another
We map the DTO to the domain object.
✅ More formal:
"After implementing the code, it's important to validate the API."Authenticate – verify identity
The user is authenticated through Cognito.
✅ Casual/Team discussion:
"When we're done coding, let's test the API to make sure everything works."21–40: Backend & Architecture
<br>Authorize – give access
<br>Only admins are authorized.

Consume – read from Kafka/SQS
This service consumes the event.

Produce – send to Kafka/SQS
We produce a message after saving.

Handle – manage an event/error
The controller handles exceptions.

Persist – save permanently
We persist the data in Postgres.

Query – ask the database
We query the customers table.

Cache – store temporarily
We cache responses in Redis.

Expose – make available
The API exposes four endpoints.

Inject – provide dependency
Spring injects the repository automatically.

Implement – create logic for an interface
We implemented the port adapter.

Extend – inherit
The class extends the base entity.

Handle – process an event/error
The service handles all retries.

Throw – raise an exception
Throw an error if the result is empty.

Return – send a response
The endpoint returns a JSON object.

Log – record information
We log all authentication attempts.

Encrypt – secure data
Encrypt the password before saving.

Deploy – put into production
We deploy through GitHub Actions.

Scale – increase capacity
We scaled the service to three replicas.

Monitor – observe behavior
Monitor latency in Grafana.

Fail – stop working
The request fails when the token expires.

41–60: Cloud, DevOps & Infrastructure

Provision – create a resource
Terraform provisions the cluster.

Trigger – start an action
A push to develop triggers the pipeline.

Rollback – return to previous version
We rolled back due to errors.

Authenticate – verify identity
Lambda authenticates the request.

Authorize – check permissions
APIGW authorizes the user.

Deploy – send to cloud
ECS deploys the new task definition.

Retry – try again
Kafka retries three times.

Scale – adjust resources
K8s scales according to CPU usage.

Containerize – package into Docker
We containerized the application.

Route – forward traffic
The ingress routes the request to service A.

Expose – open a port
The deployment exposes port 8080.

Manage – control resources
We manage secrets with Vault.

Rotate – replace periodically
We rotate the credentials weekly.

Observe – visualize metrics
Observe memory usage closely.

Store – keep data
S3 stores all uploaded files.

Sync – keep aligned
The DB syncs with the legacy system.

Failover – switch to backup
RDS failed over automatically.

Backup – save for recovery
We back up the table daily.

Recover – restore after failure
The service recovered after restart.

Alert – notify
Prometheus alerts when latency increases.

61–80: Collaboration & Meetings

Discuss – talk about
Let’s discuss this in the refinement.

Align – reach agreement
We need to align with the PO.

Schedule – plan a time
Schedule a meeting with the team.

Share – provide information
Share the logs, please.

Present – show something
I’ll present the architecture proposal.

Confirm – validate information
Can you confirm the requirements?

Request – ask formally
We requested a new SQS queue.

Report – communicate status
I reported the issue to SRE.

Deliver – complete a task
We deliver the feature this sprint.

Assess – evaluate
We assessed the design trade-offs.

Estimate – guess effort
We estimated eight story points.

Prioritize – define order
Let’s prioritize bugs first.

Plan – organize
We plan the next iteration tomorrow.

Track – follow progress
Track the task in Jira.

Lead – guide a team
Carlos leads the backend chapter.

Assist – help
I assisted the QA team with tests.

Guide – mentor
I guided the junior devs.

Explain – make clear
Let me explain the sequence diagram.

Negotiate – find middle ground
We negotiated the API contract.

Collaborate – work together
We collaborate across squads.

81–100: Thinking, Problem Solving & Quality

Analyze – understand deeply
We analyzed the logs.

Investigate – search for root cause
SRE is investigating the incident.

Identify – find a problem
We identified a memory leak.

Evaluate – judge a solution
Evaluate if this approach is safe.

Predict – estimate future behavior
We predict high load on Black Friday.

Design – architect something
We designed a hexagonal structure.

Architect – plan high-level structure
He architected the entire platform.

Prototype – create initial version
We prototyped the feature.

Test – verify correctness
We test all edge cases.

Measure – quantify
Measure the response time.

Compare – analyze differences
Compare JSON before and after mapping.

Estimate – calculate effort
Estimate the complexity honestly.

Detect – find problems
We detect anomalies with Prometheus.

Prevent – avoid issues
We prevent downtime with autoscaling.

Document – explain in writing
Document the API request flow.

Standardize – unify approach
We standardized the logging pattern.

Automate – remove manual steps
We automated deployments with CI/CD.

Monitor – observe behavior
Monitor Apdex after the fix.

Warn – notify users
The system warns when the token expires.

Adapt – adjust to context
We adapted the strategy for PCI.

------------------------
verbos mais usados

implement  
develop  
code  
refactor  
test  
deploy  
debug  
build  
design  
integrate  
document  
validate  
execute  
return  
fetch  
handle  
parse  
persist  
map  
convert  
expose  
consume  
register  
configure  
synchronize  
decouple  
encapsulate  
inject  
scale  
monitor  
analyze  
identify  
compare  
evaluate  
decide  
calculate  
determine  
estimate  
optimize  
review  
discuss  
align  
share  
update  
mention  
suggest  
clarify  
explain  
point out  
agree  
support  
help  
collaborate  
participate  
join  
contribute  
assign  
delegate  
attend  
coordinate  
plan  
prioritize  
estimate  
deliver  
define  
create  
schedule  
track  
complete  
review  
provision  
automate  
containerize  
orchestrate  
scale  
tune  
monitor  
log  
restart  
describe  
explain  
summarize  
highlight  
share  
demonstrate  
mention  
justify  
recall  
emphasize  
catch  
throw  
fail  
retry  
warn  
log  
alert  
crash  
fix  
recover
 
------------------------------------
falsos cognatos 
⭐ Eventually (no fim das contas / finalmente)
Eventually, we fixed the bug in production.
Eventually, the legacy service will be replaced.
After hours of debugging, we eventually found the root cause.

⭐ Actually (na verdade)
Actually, the issue wasn’t in our API — it was in the provider.
Actually, we don’t need a refactor; just a config change.
I thought it was a database problem, but actually it was a caching issue.

⭐ Atualmente (in English = "currently", "nowadays")
Atualmente, estamos usando Java 21 no projeto.
Atualmente, o serviço roda no cluster de QA.
Atualmente, temos três squads trabalhando na mesma feature.

⭐ Eventualmente (in English = "occasionally" / "at some point")
Eventualmente, vamos precisar migrar esse serviço para Kubernetes.
Eventualmente, algum request vai falhar — precisamos tratar os erros.
Eventualmente, teremos que revisar a arquitetura desse módulo.

🔥 Resumo para memorizar
Eventually = finalmente / no fim das contas.
Actually = na verdade.
Atualmente = currently / nowadays.
Eventualmente = occasionally / at some point.
------------------------------------

Lista de Verbos — Falsos Cognatos em Inglês
⭐ 1. Pretend
TI:
Don’t pretend the system is stable; the metrics show otherwise.
We can pretend the API is down to test our fallback.
Java Backend:
3. In the unit test, we pretend the repository returns an empty list.
4. Don’t pretend the JVM memory leak will fix itself.

⭐ 2. Intend
TI:
We intend to migrate everything to Kubernetes next quarter.
I intend to refactor this module before the next release.
Java Backend:
3. I intend to remove the synchronous call inside this loop.
4. The team intends to rewrite this service using Spring Boot 3.

⭐ 3. Support
TI:
We support multiple authentication methods in this platform.
The tool doesn’t support multi-region deployments yet.
Java Backend:
3. Our microservice now supports async processing with CompletableFuture.
4. The API supports pagination through query parameters.

⭐ 4. Discuss
TI:
We need to discuss the security implications of this feature.
Let’s discuss how this change affects the architecture.
Java Backend:
3. We should discuss whether to use Feign or WebClient.
4. Let’s discuss a better structure for the DTOs.

⭐ 5. Realize
TI:
I didn’t realize the pipeline was failing since yesterday.
We realized the alert wasn’t configured correctly.
Java Backend:
3. I realized the mapper was dropping fields silently.
4. We realized the JPA entity was not matching the database schema.

⭐ 6. Attend
TI:
I can’t attend the meeting; I’m reviewing a production incident.
She attended the architecture workshop yesterday.
Java Backend:
3. I attended the Spring Boot 3 migration training.
4. He attended the review session for the new API contract.

⭐ 7. Assist
TI:
I’ll assist you with the CI configuration.
She assisted the team during the outage.
Java Backend:
3. I assisted my peer with debugging the Kafka consumer.
4. He assisted in rewriting the authentication filter.

⭐ 8. Compromise
TI:
We may need to compromise on the delivery timeline.
The teams compromised on a shared approach to logging.
Java Backend:
3. We compromised by using a shared DTO instead of rewriting everything.
4. They compromised on using Redis rather than an in-memory cache.

⭐ 9. Resume
TI:
Let’s resume after the deploy is complete.
We’ll resume the discussion tomorrow.
Java Backend:
3. We can resume testing after fixing the failing controller.
4. Let’s resume coding once the integration tests pass.

⭐ 10. Notice
TI:
Did you notice the CPU spike in the dashboard?
I noticed the logs were duplicated.
Java Backend:
3. I noticed the service wasn’t releasing database connections.
4. She noticed the Kafka offsets weren’t moving forward.

⭐ 11. Ignore
TI:
Don’t ignore these alerts; they’re critical.
The system should ignore invalid requests.
Java Backend:
3. We can’t ignore null fields in this DTO.
4. The validator shouldn’t ignore empty strings.

⭐ 12. Injure
(Not used literally in TI, but still usable figurativamente.)
TI:
That outage really “injured” our SLA for the month.
A bad release can injure the team’s reputation.
Java Backend:
3. Poor error handling injured performance in production.
4. That huge SQL query injured the service’s response time.

⭐ 13. Introduce
TI:
We plan to introduce a new logging standard.
The new release introduces breaking changes.
Java Backend:
3. The PR introduces a new controller for payments.
4. The update introduces a retry mechanism for the API call.

⭐ 14. Insert
TI:
The system won’t let us insert this record.
You need admin rights to insert data manually.
Java Backend:
3. JPA will insert the entity automatically on save.
4. The service inserts metadata before publishing to Kafka.

⭐ 15. Push
TI:
Push the changes to GitHub when you’re done.
We need to push a new version to the registry.
Java Backend:
3. The pipeline pushes the Docker image after the tests pass.
4. The service pushes notifications to the message broker.

⭐ 16. Pull
TI:
Pull the latest version before building.
The system will pull configurations dynamically.
Java Backend:
3. The API pulls data from three different services.
4. The consumer pulls messages from the topic every second.

⭐ 17. Prevent
prevent = impedir que algo aconteça
avoid = evitar / tentar não fazer

TI:
We need to prevent this issue from happening again.
The firewall prevents external access.
Java Backend:
3. Validation prevents invalid payloads from reaching the service.
4. Retry logic prevents temporary failures from breaking the flow.

⭐ 18. Provide
TI:
The platform provides real-time monitoring.
They provide full documentation for the API.
Java Backend:
3. The adapter provides the implementation for the port.
4. This class provides utility methods for mapping responses.

⭐ 19. Design
TI:
We need to design a more scalable solution.
The team will design the integration flow.
Java Backend:
3. He designed the domain model following hexagonal principles.
4. We designed a new API contract for the mobile team.

⭐ 20. Suggest
TI:
I suggest using feature flags for this rollout.
They suggested revisiting the architecture.
Java Backend:
3. I suggest adding tests for the mapper layer.
4. She suggested using WebClient instead of RestTemplate.

⭐ 21. Execute
TI:
The pipeline will execute all checks automatically.
The script executes the deployment steps.
Java Backend:
3. The service executes a scheduled task every hour.
4. JPA executes the query lazily.

⭐ 22. Fabricate
TI:
We can fabricate test data for staging.
The tool fabricates logs for simulation.
Java Backend:
3. The test fabricates a fake HTTP response.
4. We fabricated a mock event for the Kafka topic.

⭐ 23. Convict
(Figurativo, mais raro, mas incluído.)
TI:
The audit logs can convict a failing component.
Monitoring can convict the root cause quickly.
Java Backend:
3. The trace IDs can convict which microservice failed first.
4. A failing unit test can convict the broken module.

⭐ 24. Record
TI:
The system records all user actions.
We record metrics during load tests.
Java Backend:
3. The interceptor records execution time.
4. The listener records every message processed.

⭐ 25. Advertise
TI:
The platform will advertise this new feature next week.
We don’t advertise beta tools internally.
Java Backend:
3. The service advertises its endpoints through Swagger.
4. Eureka advertises available microservices.

⭐ 26. Abuse
TI:
Don’t abuse this API; it has strict rate limits.
Users sometimes abuse the free tier.
Java Backend:
3. The code abuses reflection and becomes hard to maintain.
4. Don’t abuse static methods; they hurt testability.

⭐ 27. Apply
TI:
Apply the configuration changes and restart.
You need to apply for access to this environment.
Java Backend:
3. The validator applies the business rules.
4. The filter applies the authentication checks.

⭐ 28. Comprehend
TI:
It’s hard to comprehend why this bug only happens in QA.
The system behavior is difficult to comprehend without logs.
Java Backend:
3. He couldn’t comprehend why the mapper was failing silently.
4. It’s hard to comprehend the flow without reading the service class.

⭐ 29. Conserve
TI:
We should conserve resources in this cluster.
The design conserves bandwidth in poor networks.
Java Backend:
3. The cache helps conserve database connections.
4. The rate limiter conserves CPU under heavy load.

⭐ 30. Provide (já listado, mas mantendo a lista original à risca; se quiser troco por outro)
(Se quiser posso substituir por outro verbo falso cognato real, como "deceive", "remark", etc.)
TI:
They provide full monitoring capabilities.
We provide access only through VPN.
Java Backend:
3. The controller provides two GET endpoints.
4. This adapter provides integration with the external API.

---------------------------------------------------------
⭐ Expressões profissionais para evitar filler words
🔹 Em vez de “uh… / um…”
Use pausas estratégicas, mas quando precisar falar algo:
Let me think.
Just a moment.
Give me a second.

🔹 Em vez de “you know…”
Use:
As you can see…
As you know from earlier…
As we discussed…

🔹 Em vez de “like…” (quando usado como vício)
Use:
For example…
Such as…
In this case…

🔹 Em vez de “so…” no começo de frase
Use:
Well… (mais natural)
Here’s the point…
To summarize…
The thing is…

🔹 Em vez de “I mean…”
Use:
What I’m trying to say is…
Let me clarify…
In other words…

🔹 Em vez de “basically…”
Use:
Essentially…
In simple terms…
The main idea is…

🔹 Em vez de “right?” (para confirmar tudo o tempo inteiro)
Use:
Does that make sense?
Are we aligned?
Is that clear so far?

🔹 Em vez de “okay… so…”
Use:
Moving on…
Next point…
Let’s continue…

🔹 Em vez de “uhh yeah…” para ganhar tempo
Use:
Let me check.
Let me think for a moment.
Good question — here’s the answer.


🔥 1. Para ganhar tempo antes de responder
(em vez de: uh / um / ah / uhhh yeah…)
Let me think for a second.
Just a moment, I’m checking.
Good question — let me see.
One second, I’m pulling the context.

🔥 2. Para organizar sua fala em reuniões técnicas
(em vez de: so… / okay so…)
Here’s the situation…
Here’s what we found…
Let’s walk through this.
Moving on to the next point…
From a backend perspective…

🔥 3. Para explicar melhor uma decisão técnica
(em vez de: I mean…)
What I’m trying to say is…
Let me clarify the reasoning behind this.
In other words…
To put it simply…

🔥 4. Para citar exemplos de forma profissional
(em vez de: like… like…)
For example…
Such as…
In this case…
One good example is…

🔥 5. Para evitar “you know…”
(melhora a postura em reuniões)
As you can see from the logs…
As we discussed earlier…
As the metrics show…
From what we observed…

🔥 6. Para alinhar expectativas sem parecer inseguro
(em vez de: right?)
Does that make sense?
Are we aligned on this?
Is everyone okay with this approach?
Should we validate this together?

🔥 7. Para encerrar uma explicação
(em vez do famoso “basically…”)
Essentially…
The key point is…
Long story short…
The bottom line is…

🔥 8. Para falar sobre problemas técnicos
(e evitar hesitação)
Here’s what’s causing the issue…
Here’s the root cause…
This is where the service breaks…
This part is failing due to…

🔥 9. Para pedir algo ao time
(fortalece liderança)
Can someone double-check this?
Let’s validate this scenario.
We should review the logs together.
Please confirm this on your side.

🔥 10. Para iniciar uma opinião técnica sem parecer agressivo
(evita “I think… I think…” repetitivo)
From my perspective…
Looking at the architecture…
Based on the logs…
Considering our constraints…
From a backend standpoint…


---------------------------------------------------------
praticando HAVE

⭐ 1. HAVE = ter (posse / quantidade)
No dia a dia de TI
I have a meeting in five minutes.
We have a production incident.
Do you have access to this dashboard?
We have a blocker on this task.
No contexto de backend Java
We have a NullPointerException in the logs.
I have two endpoints to finish today.
Do we have a timeout on the external API?
We have a dependency issue in Maven.

⭐ 2. HAVE = experienciar / passar por algo
No dia a dia de TI
We had a slow response time earlier.
I had trouble connecting to VPN today.
We’re having issues with the pipeline.
I had a problem with my permissions.
Backend Java
We had a failure in the Kafka consumer.
The service had a memory spike.
I’m having trouble with this JPA mapping.
We had an inconsistent response in QA.

⭐ 3. HAVE TO = ter que (obrigação)
TI geral
I have to check the logs.
We have to update the documentation.
Do we have to sync with the mobile team?
We have to fix this before deployment.
Java backend
I have to refactor this class.
We have to validate the DTO properly.
I have to rewrite this mapper.
We have to increase the timeout.

⭐ 4. HAVE BEEN + ING = ação contínua (tem estado / tem feito)
(muito usado em daily meetings)
TI geral
I’ve been working on the integration tests.
We’ve been investigating the latency issue.
I’ve been reviewing the architecture proposal.
We’ve been debugging the incident since morning.
Java backend
I’ve been fixing the Spring configuration.
We’ve been improving the error handling.
I’ve been testing the Kafka flow.
We’ve been optimizing the database queries.

⭐ 5. HAVE + PARTICÍPIO = já fez / já aconteceu
TI geral
I’ve already checked the logs.
Have you reviewed the PR?
We’ve finished the deployment.
We’ve confirmed the root cause.
Java backend
I’ve tested the endpoint.
Have you run the unit tests?
We’ve implemented the retry logic.
I’ve documented the API contract.

-------------------------------
phrasal verbs

1. set up – configurar / montar
to set up a server, to set up a project
We need to set up a new environment for QA.
(A gente precisa configurar um novo ambiente para QA.)
Can you set up the Spring Boot project with Docker from the beginning?
(Você pode montar o projeto Spring Boot com Docker desde o início?)

2. spin up – subir (rápido) um recurso/serviço
Muito usado pra containers, VMs, pods, etc.
We can spin up a new pod in the cluster to handle the extra load.
(Podemos subir um novo pod no cluster pra aguentar a carga extra.)
They spin up a test database before running the integration tests.
(Eles sobem um banco de teste antes de rodar os testes de integração.)

3. scale up / scale down – escalar pra cima / pra baixo
If traffic increases, we’ll scale up the number of instances.
(Se o tráfego aumentar, vamos escalar o número de instâncias.)
At night we usually scale down the services to save costs.
(À noite geralmente reduzimos a escala dos serviços pra economizar.)

4. roll out – colocar em produção / liberar
We’re going to roll out the new version tonight.
(Vamos liberar a nova versão hoje à noite.)
The feature was rolled out to 10% of the users first.
(A feature foi liberada primeiro para 10% dos usuários.)

5. roll back – reverter deploy / versão
We had to roll back the deployment because of a critical bug.
(Tivemos que reverter o deploy por causa de um bug crítico.)
If the health checks fail, the pipeline automatically rolls back.
(Se os health checks falham, o pipeline reverte automaticamente.)

6. bring up / bring down – subir / derrubar serviço
The service is down, we’re trying to bring it back up.
(O serviço está fora, estamos tentando subir de novo.)
We need to bring down the instance to apply the patch.
(Precisamos derrubar a instância pra aplicar o patch.)

7. shut down – desligar / encerrar
We’ll shut down the old legacy service next quarter.
(Vamos desligar o serviço legado no próximo trimestre.)
The app shuts down if it can’t connect to the database.
(O app encerra se não conseguir conectar no banco.)

8. log in / log out – entrar / sair (autenticação)
Users can’t log in after the last deployment.
(Os usuários não conseguem fazer login depois do último deploy.)
The token expires and the user is logged out automatically.
(O token expira e o usuário é deslogado automaticamente.)

9. sign up – cadastrar-se / criar conta
We added a new flow for users to sign up with Google.
(Adicionamos um novo fluxo pra usuários se cadastrarem com o Google.)
The conversion rate on the sign-up page improved after the redesign.
(A taxa de conversão na página de cadastro melhorou depois do redesign.)

10. back up – fazer backup
We back up the database every night.
(Fazemos backup do banco toda noite.)
Before changing the schema, please back up the data.
(Antes de mudar o schema, faz um backup dos dados.)

11. figure out – entender / descobrir / destrinchar
Muito usado pra debug e análise.
We need to figure out why the API is timing out.
(Precisamos entender por que a API está dando timeout.)
I’m still trying to figure out what’s causing this memory leak.
(Ainda estou tentando descobrir o que está causando esse memory leak.)

12. find out – descobrir (obter informação)
Let’s find out which service is causing the high CPU usage.
(Vamos descobrir qual serviço está causando o alto uso de CPU.)
I’ll find out who changed this configuration in Kubernetes.
(Vou descobrir quem mudou essa configuração no Kubernetes.)

13. track down – rastrear / localizar a origem
We need to track down where this null value comes from.
(Precisamos rastrear de onde vem esse valor null.)
The logs helped us track down the failing dependency.
(Os logs ajudaram a localizar a dependência que estava falhando.)

14. clean up – limpar / organizar código, dados, logs
We should clean up unused feature flags in the config.
(Devíamos limpar os feature flags não usados na config.)
I’ll clean up the controller and move this logic to a service.
(Vou dar uma limpada no controller e mover essa lógica pra um service.)

15. break down – decompor / explicar parte por parte
Let me break down the flow: first the request hits the gateway, then the BFF, then the core service.
(Deixa eu decompor o fluxo: primeiro a requisição passa no gateway, depois no BFF, depois no serviço core.)
We broke down the monolith into three microservices.
(Nós quebramos o monólito em três microsserviços.)

16. hand over – repassar / passar adiante
I’ll hand over this task to the DevOps team.
(Vou repassar essa tarefa pro time de DevOps.)
Can you hand over the documentation to the new developer?
(Você pode passar a documentação pro novo desenvolvedor?)

17. follow up – acompanhar / cobrar depois
I’ll follow up on this incident after we get more logs.
(Vou acompanhar esse incidente depois que tivermos mais logs.)
Can you follow up with the other squad about the API contract?
(Você pode dar um follow up com a outra squad sobre o contrato da API?)

18. work around – contornar (um problema)
We added a feature flag to work around the bug in the legacy service.
(Adicionamos um feature flag pra contornar o bug no serviço legado.)
For now, we’ll work around the limitation of this API.
(Por enquanto, vamos contornar a limitação dessa API.)


----------------------------
🔵 Com KEEP (manter, continuar, persistir)
>keep up – manter o ritmo / continuar
>“We need to keep up with the new compliance requirements.”
>“Good job keeping up with the alerts yesterday.”
>keep track of – acompanhar / rastrear
>“Can you keep track of the Kafka offsets in the consumer group?”
>“I’m keeping track of all retries in the logs.”
>keep an eye on – ficar de olho
>“Let’s keep an eye on the CPU usage after the deploy.”
>keep going – continuar trabalhando / seguir
>“The pipeline failed, but we can keep going locally.”
>keep something in mind – ter em mente
>“Keep in mind that this endpoint is synchronous.”
>keep at it – persistir
>“Keep at it, the root cause will show up in the logs.”

🟣 Com SET (configurar, definir)
set up – configurar / preparar / montar
“I’ll set up the new SQS queues.”
set out – definir objetivos
“We set out to reduce latency in this sprint.”
set off – disparar / iniciar
“This change can set off multiple retries in the service.”
set aside – reservar tempo
“Let’s set aside 30 minutes to review the architecture.”

🟢 Com GET (obter, receber, entender)
get back to – retornar / responder depois
“I’ll get back to you after checking the logs.”
get rid of – remover / eliminar
“We need to get rid of this deprecated endpoint.”
get into – entrar no assunto / se aprofundar
“Let’s not get into performance tuning yet.”
get around – contornar problema
“We can get around this by caching the response.”
get through – finalizar / conseguir passar
“The request can’t get through the gateway.”
get ahead of – antecipar problemas
“We need to get ahead of this incident before peak time.”
get stuck – travar / ficar bloqueado
“I got stuck debugging the token validation.”

🔥 Outros phrasal verbs extremamente comuns em TI
🟨 Ação técnica
look into – investigar
“We’ll look into the timeout on the login endpoint.”
figure out – descobrir / entender
“Let’s figure out why WebClient isn’t retrying.”
track down – rastrear
“We tracked down the root cause to a misconfigured Redis key.”
bring up (serviço) – subir
“The pod didn’t bring up correctly after the deploy.”
bring down – derrubar / desligar serviço
“We need to bring down the instance before patching.”
roll out – liberar versão
“The new flow will be rolled out gradually.”
roll back – reverter
“We rolled back due to high error rate.”
clean up – limpar / remover lixo
“We should clean up unused feature flags.”

🟩 Comunicação entre squads
follow up – acompanhar / cobrar
“I’ll follow up with the BFF team about the contract.”
point out – destacar
“Just pointing out: this API is not idempotent.”
check in – sincronizar / atualizar status
“Let’s check in after lunch to finalize the review.”
hand over – repassar
“I’ll hand over the logs to SRE.”
talk through – explicar passo a passo
“Let me talk you through the authentication flow.”

----------------------------
⭐ 1–10: Estruturais
1. even
Squad: The issue happens even after the hotfix.
Java: The endpoint is slow even with caching enabled.

2. still
Squad: The bug is still open on Jira.
Java: The service still returns 500.

3. yet
Squad: The PO hasn’t confirmed the requirement yet.
Java: The consumer hasn’t started processing messages yet.

4. though
Squad: It looks stable now, though the logs are strange.
Java: The query works, though it’s not optimized.

5. although
Squad: Although it’s late, we need this alignment.
Java: Although the API is valid, the mapper fails.

6. actually
Squad: Actually, we don’t need another meeting.
Java: Actually, the bug was in the DTO, not the controller.

7. basically
Squad: Basically, we need better communication.
Java: Basically, the service fetches, maps, and returns.

8. literally
Squad: We literally had three incidents today.
Java: The JVM literally hit 100% CPU.

9. already
Squad: I already updated the ticket.
Java: The service already consumed the message.

10. instead
Squad: Let’s try this approach instead.
Java: Use WebClient instead of RestTemplate.

⭐ 11–20: Comunicação & alinhamento
11. anyway
Squad: Anyway, let’s move to the next topic.
Java: Anyway, the retry logic still needs improvement.

12. exactly
Squad: Exactly! That’s the point I was making.
Java: Exactly where the timeout happens is in this method.

13. probably
Squad: He’s probably in another call.
Java: The failure is probably in the database call.

14. honestly
Squad: Honestly, we don't need this extra ceremony.
Java: Honestly, this code needs a full refactor.

15. obviously
Squad: Obviously, we need more test coverage.
Java: Obviously, JPA can’t handle this structure.

16. apparently
Squad: Apparently, the deploy didn’t run.
Java: Apparently, the header isn’t being sent.

17. definitely
Squad: We definitely need to fix this today.
Java: This logic definitely needs validation.

18. eventually
Squad: Eventually, we’ll migrate to a new platform.
Java: Eventually, this service will be rewritten.

19. currently
Squad: Currently, we have three open incidents.
Java: The service is currently failing on startup.

20. recently
Squad: Recently, we’ve had many access issues.
Java: The logs recently started showing this warning.

⭐ 21–30: Reuniões / fluxo
21. however
Squad: We delivered the feature; however, QA found issues.
Java: The call works; however, the mapping is wrong.

22. therefore
Squad: Therefore, we need more people on this task.
Java: The service failed; therefore, the fallback triggered.

23. meanwhile
Squad: Meanwhile, the mobile team is testing.
Java: Meanwhile, the scheduler keeps sending events.

24. otherwise
Squad: We must sync this today, otherwise it’ll block the sprint.
Java: Add validation, otherwise the API will break.

25. moreover
Squad: Moreover, this change affects other squads.
Java: Moreover, this method is used by three services.

26. besides
Squad: Besides that, there’s nothing new.
Java: Besides this error, everything else works.

27. regarding
Squad: Regarding the incident, we need a timeline.
Java: Regarding this class, let’s add some logs.

28. related
Squad: It’s related to the last deploy.
Java: The issue is related to the thread pool.

29. considering
Squad: Considering the deadline, we need focus.
Java: Considering the payload size, we need compression.

30. depending
Squad: Depending on the PO, we can move forward.
Java: Depending on the header, the API returns another format.

⭐ 31–40: Ações técnicas
31. handle
Squad: We need to handle this in today’s refinement.
Java: The service must handle null values.

32. fetch
Squad: We fetch data from two providers.
Java: The repository fetches all active records.

33. trigger
Squad: This deploy will trigger a regression test.
Java: The scheduler triggers the batch job.

34. expose
Squad: We expose only public endpoints.
Java: This controller exposes two GET APIs.

35. consume
Squad: The BI team will consume the data.
Java: The listener consumes messages from Kafka.

36. provide
Squad: This dashboard provides visibility.
Java: The adapter provides the implementation for the port.

37. ensure
Squad: We need to ensure alignment with mobile.
Java: Ensure the service returns a valid DTO.

38. avoid
Squad: Let’s avoid last-minute changes.
Java: Avoid calling this API synchronously.

39. improve
Squad: We must improve our communication.
Java: Let’s improve the error handling.

40. increase
Squad: Can we increase the priority of this task?
Java: Increase the timeout for this external API.

⭐ 41–50: Problemas e incidentes
41. failure
Squad: We had a failure in production.
Java: The failure occurred during the database call.

42. issue
Squad: This issue affects two squads.
Java: The issue is in the mapping layer.

43. outage
Squad: The outage impacted several teams.
Java: The service crashed during the outage.

44. fallback
Squad: The fallback didn’t trigger correctly.
Java: The fallback returns cached data.

45. retry
Squad: We need a retry strategy.
Java: The client retries three times before failing.

46. timeout
Squad: We’re seeing timeout spikes.
Java: The request hits a timeout on the provider.

47. request
Squad: The request volume increased today.
Java: The request contains an invalid header.

48. response
Squad: The response time is too high.
Java: The response body is missing fields.

49. payload
Squad: The payload changed without notice.
Java: The payload doesn’t match the DTO.

50. environment
Squad: Which environment are you testing in?
Java: This config only works in the QA environment.

---


praticando termos de tecnologia em inglês
## Glossary of Common Tech Terms in English
> Backend Development
<br> Software Architecture
<br> Microservices
<br> Monolithic Architecture
<br> RESTful APIs
<br> Asynchronous Communication
<br> Event-Driven Architecture
<br> Cloud Computing
<br> Containerization
<br> Orchestration
<br> Continuous Integration (CI)
<br> Continuous Deployment (CD)
<br> DevOps
<br> Observability
<br> Scalability
<br> Resilience
<br> Load Balancing
<br> Fault Tolerance
<br> Domain-Driven Design (DDD)
<br> Test-Driven Development (TDD)
<br> Behavior-Driven Development (BDD)
<br> Version Control
<br> Dependency Management
<br> Code Review
<br> Agile Methodologies
<br> Scrum
<br> Kanban
<br> Software Development Life Cycle (SDLC)
<br> Infrastructure as Code (IaC)
<br> Service Mesh
<br> API Gateway
<br> Message Broker
<br> Data Serialization
<br> Authentication and Authorization
<br> Encryption
<br> Performance Optimization
<br> Refactoring
<br> Legacy Systems
<br> Technical Debt
<br> Codebase
<br> Build Automation
<br> Unit Testing
<br> Integration Testing
<br> Load Testing
<br> Mocking
<br> Logging
<br> Tracing
<br> Metrics
<br> Circuit Breaker
<br> Retry Mechanism
<br> Bulkhead Pattern
<br> Idempotency
<br> Ubiquitous Language
<br> Bounded Context
<br> Aggregate
<br> Factory Pattern
<br> Singleton Pattern
<br> Builder Pattern
<br> Adapter Pattern
<br> Facade Pattern
<br> Strategy Pattern
<br> Chain of Responsibility Pattern
<br> Protobuf (Protocol Buffers)
<br> gRPC
<br> OAuth2
<br> JWT (JSON Web Token)
<br> Kubernetes (K8s)
<br> Docker
<br> Jenkins
<br> Maven
<br> Gradle
<br> Spring Boot
<br> Spring Cloud
<br> Hibernate
<br> Kafka
<br> RabbitMQ
<br> PostgreSQL
<br> Oracle Database
<br> MongoDB
<br> DynamoDB
<br> Prometheus
<br> Grafana
<br> OpenTelemetry
<br> Splunk
<br> Jaeger
<br> AWS (Amazon Web Services)
<br> S3 (Simple Storage Service)
<br> SQS (Simple Queue Service)
<br> ECR (Elastic Container Registry)
<br> FaaS (Function as a Service)
<br> BaaS (Backend as a Service)
<br> CI/CD Pipelines
<br> Blue-Green Deployment
<br> Rollout Deployment
<br> Semantic Commit Messages
<br> Codebase
<br> system reliable

frases comuns e afirmativar em entrevistas técnicas de desenvolvedor backend com enfase em java em ingles
## Common Phrases for Backend Developer Interviews (Java Focus)
> I have extensive experience in backend development using Java and Kotlin.
<br> I am proficient in building RESTful APIs with Spring Boot.
<br> I have worked on microservices architecture and understand its benefits and challenges.
<br> I am familiar with asynchronous communication using Kafka and RabbitMQ.
<br> I have experience with cloud platforms, particularly AWS.
<br> I am skilled in containerization with Docker and orchestration using Kubernetes.
<br> I follow best practices in software architecture, including DDD and Clean Architecture.
<br> I am comfortable with CI/CD pipelines and have used Jenkins for automation.
<br> I prioritize code quality and maintainability through code reviews and testing.
<br> I have a strong understanding of relational databases like PostgreSQL and Oracle.
<br> I am experienced in using Hibernate and JPA for data persistence.
<br> I am familiar with observability tools such as Prometheus and Grafana.
<br> I have implemented security measures using OAuth2 and JWT.
<br> I am a strong advocate for TDD and have applied it in my projects.
<br> I am adaptable and open to learning new technologies and methodologies.
<br> I am a proactive team player and enjoy collaborating with cross-functional teams.
<br> I am committed to continuous improvement and staying updated with industry trends.
<br> I am excited about the opportunity to contribute to your team and projects.
<br> Thank you for considering my application; I look forward to the possibility of working together.

frases que posso afirmar em entrevistas técnicas de desenvolvedor backend com ênfase em java em inglês
## Affirmative Phrases for Backend Developer Interviews (Java Focus)
    I am confident in my ability to design and implement scalable backend systems.
    I have a proven track record of delivering high-quality software on time.
    I am skilled at troubleshooting and resolving complex technical issues.
    I am experienced in optimizing application performance and scalability.
    I have a deep understanding of Java and its ecosystem.
    I am proficient in using Spring Boot and Spring Cloud for building microservices.
    I am knowledgeable about software design patterns and best practices.
    I am comfortable working in Agile environments and following Scrum methodologies.
    I am dedicated to writing clean, maintainable, and well-documented code.
    I am experienced in mentoring junior developers and fostering a collaborative team environment.
    I am committed to continuous learning and professional development.
    I am passionate about technology and enjoy solving challenging problems.
    I am excited about the opportunity to contribute my skills and experience to your organization.
    I am eager to take on new challenges and grow as a backend developer.
    I am confident that my skills and experience align well with the requirements of this role.

---
## Phrases to Use When You Face Difficulties in English During an Interview
    "Sorry, could you please repeat that?"
    "My English is a bit rusty — I haven’t practiced as much lately."
    "But I’m following you."
    "Could you please clarify that point?"
    "Let me make sure I understand correctly."
    "I’m not sure I caught that. Could you explain it again?"
    "I apologize for any mistakes in my English; I’m working on improving it."
    "Thank you for your patience as I express myself in English."
    "Could you please speak a bit slower? I want to make sure I understand everything."
    "I appreciate your understanding as I navigate this conversation in English."

----------------------------------

## technicle interview

- 4 principals de POO

- hash code and equals

- garbage collection

- collections em java na profundidade

- design patterns

- spring

- injection ande dependenci injection (citando via construtor e anotations)

- spring profiles

- tests

- docker e virtual machine

- vertical and horizontal scale

- cloulds

- agile (grooming sessions)





