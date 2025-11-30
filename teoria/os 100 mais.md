🔥 100 Adjetivos essenciais da área de TI

Accurate – preciso áquiurét
• Our reconciliation service needs accurate timestamps to avoid processing the same Kafka message twice.
• The fraud engine only reacts when the customer provides accurate personal data.
Active – ativo
• The health-check endpoint returns the number of active threads in the worker pool.
• Only active sessions are kept in Redis; expired ones are removed automatically.
Advanced – avançado
• We enabled advanced retry logic using Spring Retry to handle intermittent timeouts.
• The team is adopting advanced monitoring with OTel to trace distributed flows.
Agile – ágil
• An agile backend needs small, independent modules that deploy without friction.
• We follow an agile approach to refactor features incrementally in production.
Automated – automatizado
• The deployment pipeline is fully automated using Jenkins and GitHub Actions.
• Automated tests run on every PR to prevent regressions in the core domain.
Available – disponível
• The cache must remain available even when the database is under heavy load.
• We replicate the service in two zones to stay available during upgrades.
Basic – básico
• The basic flow only validates the payload before sending it to Kafka.
• Our basic authentication layer will be replaced with OAuth2.
Blocked – bloqueado
• The thread pool got blocked due to a slow external API.
• Requests were blocked while waiting for the lock on the shared resource.
Broken – quebrado / com falha
• The batch job is broken because the mapper generated a null pointer.
• We detected a broken dependency after bumping Spring Boot to 3.x.
Cached – armazenado em cache
• The product details are cached in Redis to reduce database load.
• We cached the JWT public keys to avoid constant calls to the authorization server.
Centralized – centralizado
• All authentication logic is centralized in the identity service.
• We store feature flags in a centralized configuration provider.
Clean – limpo (código)
• The new module has a clean architecture, separating domain and infrastructure.
• We keep controllers thin to maintain clean and readable flows.
Complex – complexo
• The compensation logic for cancelled orders is complex and event-driven.
• A complex serialization issue occurs when nested objects are mutated during mapping.
Compliant – em conformidade
• Our logs must be compliant with PCI-DSS standards.
• The API is now compliant with the new schema defined in OpenAPI 3.
Concurrent – concorrente
• We use a concurrent queue to handle high-throughput message processing.
• Concurrent writes caused race conditions in the legacy module.
Configurable – configurável
• The retry strategy is configurable through the application YAML.
• Kafka consumers are fully configurable per environment.
Connected – conectado
• The service stays connected to MongoDB through a pooled connection.
• The instance isn’t connected to Redis due to missing network rules.
Consistent – consistente
• We ensure consistent writes using transactions in Postgres.
• Consistent logs help us debug distributed flows across microservices.
Critical – crítico
• This is a critical path: any delay affects the checkout experience.
• Kafka offsets are critical for ensuring idempotency.
Current – atual
• The current version of the service requires Java 21.
• Our current design uses a decoupled event-driven workflow.
Custom – personalizado
• We implemented a custom deserializer to handle the partner’s JSON format.
• The pipeline uses a custom Jenkins stage to validate OpenAPI contracts.
Decoupled – desacoplado
• The notification flow is decoupled using Kafka to avoid synchronous waits.
• We keep business rules decoupled from controllers with the hexagonal approach.
Deprecated – obsoleto
• The old endpoint is deprecated and will be removed next quarter.
• Spring marked that annotation as deprecated in Java 21.
Distributed – distribuído
• In a distributed system, clock drift can break event ordering.
• We rely on distributed locks to avoid double-processing orders.
Dynamic – dinâmico
• The rule engine loads dynamic conditions from a configuration file.
• Our dynamic scaling responds to CPU and latency signals.
Effective – eficaz
• Caching was the most effective solution to reduce database load.
• The retry policy is effective against transient network failures.
Efficient – eficiente
• The Kotlin coroutine model is more efficient for IO-bound tasks.
• We optimized queries to make the billing service more efficient.
Elastic – elástico
• EKS provides an elastic infrastructure to support peak traffic.
• Elastic queues handle bursts without losing messages.
Encrypted – criptografado
• All secrets remain encrypted at rest using KMS.
• The payload is encrypted before being published to Kafka.
Expected – esperado
• The consumer processed the expected number of messages.
• The API returned the expected HTTP status code.
External – externo
• The external payment provider started timing out yesterday.
• We validate the response schema from the external API.
Failed – falho
• The batch retried all failed transactions overnight.
• A failed dependency caused the service to stop during startup.
Flexible – flexível
• The architecture is flexible enough to swap RabbitMQ for Kafka.
• Our flexible design supports both synchronous and asynchronous flows.
Functional – funcional
• The new endpoint is functional but needs optimization.
• We use functional programming patterns with Kotlin flows.
Gradual – gradual
• We applied a gradual rollout using feature flags.
• Migration to the new schema will be gradual to avoid downtime.
Heavy – pesado (processamento)
• The report generator is too heavy to run on the same thread pool.
• Image processing is heavy, so we moved it to a background worker.
High-level – alto nível
• We present a high-level design before diving into details.
• Kotlin offers high-level abstractions over concurrency.
Idle – ocioso
• The service scales down when nodes are idle.
• Idle connections were causing memory leaks in the legacy pool.
Immutable – imutável
• Domain events are immutable to guarantee consistency.
• We keep immutable DTOs to avoid side effects in mapping.
Important – importante
• Idempotency keys are important for preventing duplicates.
• Monitoring latency is important in high-throughput systems.
Independent – independente
• Each microservice is independent and owns its own database.
• The feature flag service works independent of the main request flow.
Indexed – indexado
• The customer_id column is indexed to speed up lookups.
• MongoDB collections were indexed to optimize query patterns.
Informative – informativo
• We improved logs to be more informative during debugging.
• The health endpoint returns informative details about each component.
Initial – inicial
• The initial load of catalog data happens at startup.
• We ran an initial migration to normalize the order table.
Inline – em linha
• We removed the inline SQL and moved it to a repository class.
• Inline mappers caused duplication, so we refactored them into components.
Internal – interno
• The internal API is not exposed through the gateway.
• We encrypt all internal service-to-service communication.
Invalid – inválido
• The request returned 400 due to an invalid field in the payload.
• Kafka listeners skip invalid messages and push them to the DLQ.
Involved – envolvido
• Multiple services are involved in the checkout flow.
• Kafka, Redis, and Postgres are involved during the customer login process.
JSON-based – baseado em JSON
• We standardized our JSON-based events using a shared schema registry.
• The JSON-based request is validated with Jackson annotations.
Legacy – legado
• The legacy module still uses JDBC templates and manual transactions.
• We wrapped the legacy SOAP client behind a modern adapter.
Lightweight – leve
• Micronaut is more lightweight than Spring for serverless workloads.
• Our lightweight DTOs speed up serialization under high load.
Limited – limitado
• The API has limited throughput due to external provider constraints.
• We use rate limiting because the legacy system has limited capacity.
Local – local
• We run MongoDB in a local container for integration tests.
• Local caching reduced latency for hot endpoints.
Logical – lógico
• The mapper applies logical transformations to build the domain model.
• We group business rules in a logical structure inside the domain layer.
Low-level – baixo nível
• We used low-level Kafka APIs for a custom partitioning strategy.
• Low-level byte manipulation was needed to decode the protocol.
Manual – manual
• A manual retry was needed because the partner API returned malformed data.
• We removed manual configuration and moved everything to YAML.
Mandatory – obrigatório
• The customer_id field is mandatory for all POST requests.
• Authentication is mandatory for accessing the orders endpoint.
Modular – modular
• Our modular monolith lets us scale components independently.
• Kotlin modules keep domain logic isolated and clean.
Modern – moderno
• We are migrating the legacy module to a modern reactive architecture.
• The service uses modern Java 21 features like virtual threads.
Mutable – mutável
• Mutable state caused concurrency issues in the billing service.
• We replaced mutable collections with Kotlin’s immutable List.
Native – nativo
• We use native AWS SDK integrations to reduce overhead in the payment flow.
• Quarkus compiled the service to a native binary, improving cold starts.
Networked – ligado à rede
• All networked components must pass through the company’s zero-trust gateway.
• Networked storage introduced extra latency in the reporting module.
Non-blocking – não bloqueante
• WebFlux provides a non-blocking execution model ideal for high concurrency.
• We migrated the file upload endpoint to a non-blocking approach.
Obvious – óbvio
• It’s obvious that the slow query is coming from missing indexes.
• The NPE was obvious once we checked the mapper logic.
On-demand – sob demanda
• The service generates reports on-demand using S3 triggers.
• We scale worker pods on-demand based on queue length.
Optimized – otimizado
• The new SQL statement is optimized for large datasets.
• We optimized the serialization process to reduce latency by 20%.
Optional – opcional
• The filter parameter is optional; we return all records if it’s absent.
• In Kotlin, Optional values are replaced with nullable types.
Parallel – paralelo
• The batch process runs in parallel using Java streams.
• Parallel consumers increased throughput during nightly jobs.
Partial – parcial
• We applied a partial rollback after a failed transaction.
• The response includes partial data when the partner API times out.
Persistent – persistente
• The service writes persistent audit logs to Postgres.
• Persistent volumes store user-uploaded files across deployments.
Portable – portável
• Containerized services are portable across environments.
• Kotlin Multiplatform makes business rules portable to other runtimes.
Predictable – previsível
• Circuit breakers make failures more predictable and controlled.
• Predictable latency is essential in streaming architectures.
Primary – primário
• The primary key is a UUID generated on the backend.
• Our primary goal is to reduce cold starts during peak hours.
Private – privado
• The private endpoint is only accessible from internal networks.
• Sensitive fields stay private inside the domain model.
Public – público
• The public API follows strict versioning rules.
• We published a public contract in the API Gateway.
Random – aleatório
• We generate random salts for password hashing.
• The load balancer distributes traffic using a random strategy.
Reactive – reativo
• The login flow is reactive using Mono and Flux.
• Reactive event streams simplify backpressure handling.
Readable – legível
• We refactored the code to make the validator more readable.
• Readable logs reduce debugging time in distributed flows.
Real-time – em tempo real
• Real-time metrics are exported using OpenTelemetry.
• The fraud system analyzes transactions in real-time.
Redundant – redundante
• We store redundant events in S3 for replay purposes.
• Redundant replicas ensure the cluster survives node failures.
Reliable – confiável
• We moved to Kafka because it provides reliable event delivery under high load.
• The new retry mechanism made the billing service more reliable.
Remote – remoto
• The service reads remote configuration from AWS Parameter Store.
• We replaced the remote SOAP client with a modern REST adapter.
Replicated – replicado
• Postgres uses replicated nodes to handle read-heavy operations.
• We replicated the cache to avoid a single point of failure.
Required – obrigatório / exigido
• The token header is required for all protected endpoints.
• A referenceId is required for every published event.
Responsive – responsivo
• Our reactive model keeps the API responsive during peak traffic.
• The dashboard becomes more responsive after caching metrics.
Robust – robusto
• The hexagonal architecture made the system more robust.
• A robust error-handling layer prevents cascading failures.
Scalable – escalável
• The microservice is scalable through horizontal autoscaling.
• Redis helps the platform remain scalable during Black Friday.
Scheduled – agendado
• A scheduled job cleans old tokens every six hours.
• We use a scheduled task to sync data with Salesforce nightly.
Secure – seguro
• All communication between pods is secure using mTLS.
• The login flow is secure thanks to OAuth2 and short-lived tokens.
Shared – compartilhado
• We keep shared DTOs in a contract module used by all microservices.
• The cluster runs on shared compute resources across teams.
Synchronous – síncrono
• The payment confirmation is a synchronous REST call.
• We avoid synchronous flows whenever external partners are slow.
Asynchronous – assíncrono
• Order notifications are asynchronous via Kafka.
• We turned the PDF generation into an asynchronous background task.
Temporary – temporário
• Temporary files are stored in /tmp before being uploaded to S3.
• We created a temporary fix until the partner releases the new API.
Thread-safe – seguro para threads
• The singleton mapper is thread-safe because it has no mutable state.
• ConcurrentHashMap is thread-safe and performs well under load.
Time-consuming – demorado
• The report generation is time-consuming, so we offloaded it to workers.
• Schema validation became time-consuming after adding nested relations.
Unavailable – indisponível
• The partner API became unavailable during the maintenance window.
• Our fallback responds immediately when the service is unavailable.
Unexpected – inesperado
• We logged an unexpected data format coming from the provider.
• The consumer crashed due to an unexpected null value.
Valid – válido
• Only valid events are forwarded to the processing engine.
• We check if the JWT is still valid before retrieving customer data.
Verbose – verboso (log)
• The legacy module logs are too verbose and flood Splunk.
• Verbose stack traces were disabled in production mode.
Virtual – virtual
• Java 21’s virtual threads reduced blocking issues in our API.
• We run integration tests inside virtual Docker networks.

letś find out more from our individuals
* Let’s find out more from our individuals who handled the Kafka migration; they know the tricky parts.
* Before we redesign the flow, let’s find out more from our individuals that maintain the legacy SOAP service.
* Let’s find out more from our individuals involved in the deployment failure yesterday.

i m a huge fan of scrum
* I’m a huge fan of Scrum because it keeps the backend team aligned during fast iterations.
* I’m a huge fan of Scrum; it works really well with microservice development.
* I’m a huge fan of Scrum, especially when we mix it with technical refinements for architecture

recovery
* The recovery service validates the customer’s identity using JWT and Redis.
* We’re improving the password recovery flow to reduce latency.
* Recovery is handled through a scheduled job that processes DLQ messages.

fetch
* The BFF fetches customer data from two Java microservices before building the response.
* The consumer fetches offsets from Kafka using a custom strategy.
* We fetch configuration from AWS Parameter Store during startup.

well jump over  to
* We’ll jump over to the Kafka metrics next, after finishing the API review.
* We’ll jump over to the Kubernetes manifests once the pipeline is fixed.
* We’ll jump over to the error-handling rules in a few minutes.

on boarding
* Our onboarding process includes setting up access to Jenkins, Splunk, and the Kubernetes clusters.
* The new dev finished onboarding and already deployed his first Java service.
* We’re improving onboarding by automating project scaffolding.

mostly i focus on java solutions
* Mostly I focus on Java solutions for async flows and large-scale processing.
* Mostly I focus on Java solutions, but sometimes I contribute to Kotlin features too.
* Mostly I focus on Java solutions with Spring Boot, Kafka, and AWS.

played role of key developer placed role not only in a funcional teams but also in non-funcional requeirement teams
* I played the role of key developer during the migration to Kafka Streams.
* I played the role of key developer when we redesigned the authentication flow.
* I played the role of key developer in the multi-tenant architecture implementation.

“functional and non-functional requirement teams”
* I’ve played roles not only in functional teams but also in non-functional requirement teams working on observability.
* I contributed to both functional and non-functional requirement teams for performance tuning.
* I worked with functional and non-functional requirement teams to define SLOs and resiliency patterns.

further
* We need further validation before releasing this feature to production.
* Further analysis showed that the issue came from the thread pool saturation.
* Further improvements will focus on reducing startup time.

letś kick off the interview over to you both
* Let’s kick off the interview — over to you both to introduce yourselves.
* Let’s kick off the interview; you both can start with your experience in distributed systems.
* Let’s kick off the interview over to you both, feel free to ask anything about my background.

nonetheless
* The payload was malformed; nonetheless, the service handled it gracefully.
* We had delays in QA; nonetheless, the deployment window remains open.
* The API is stable; nonetheless, we are monitoring for memory leaks.

according
* According to the logs, the error occurred right after the retry attempt.
* According to the metrics, the consumer is falling behind under heavy load.
* According to our SLOs, latency is still within acceptable limits.

responsible for multi-tenance implementarion
* I was responsible for multi-tenancy implementation using schema-per-tenant.
* I’m currently responsible for multi-tenancy across our Java microservices.
* I was responsible for multi-tenancy validation during CI/CD deployments.

content
* The service fetches content metadata from an external provider.
* We cache content updates in Redis to reduce load on the CMS.
* The BFF aggregates content and product information into a single response.

we work with some third-party content platform
* We work with a third-party content platform that provides all the product descriptions.
* The third-party content platform started returning 500 errors today.
* We integrated the third-party content platform using a resilient retry strategy.

expensive solution
* Running Elasticsearch at full capacity became an expensive solution.
* The partner’s API is an expensive solution due to high latency and quota limits.
* Storing everything in S3 Glacier was an expensive solution for fast retrieval.

bunch of those
* We have a bunch of those events hitting the DLQ every hour.
* There are a bunch of those legacy endpoints still running on Java 8.
* We fixed a bunch of those NPEs during the refactoring.

warm-up questions
* Before talking about Kafka partitions, let’s start with some warm-up questions.
* These warm-up questions help us understand your experience with Java concurrency.
* I usually ask warm-up questions about REST design before going deeper.

is a job over
* Is the job over after deployment? Not really — we still monitor the rollout.
* Is the job over? Only when the metrics show stable performance.
* Is the job over? Not yet, we’re validating the integration with Salesforce.

cleaned up
* We cleaned up the legacy code in the mapper before adding the new business rules.
* The pipeline was failing, but we cleaned up some unused steps and now it works fine.
* I cleaned up the database scripts to remove deprecated columns.

besides
* Besides fixing the bug, I improved the logging to help future debugging.
* Besides Kafka, we also support SQS for asynchronous events.
* Besides Java, I contribute to Kotlin modules when needed.

Behind the scenes, Java resolves itself
* Behind the scenes, Java resolves itself by managing classloading and dependency injection.
* Behind the scenes, Java resolves itself with automatic garbage collection.
* Behind the scenes, Java resolves itself using reflection to handle annotations.

threshold
* The HPA scaled up the pods after the CPU crossed the threshold.
* We defined a latency threshold of 300ms for the payment API.
* When the error threshold is reached, the circuit breaker opens.

heap
* The service crashed because the heap memory was exhausted during batch processing.
* We increased the heap size to handle larger JSON payloads.
* A heap dump revealed a huge map that was never being cleared.

ramdom
* We added a random delay to avoid thundering herd issues.
* The load balancer distributes traffic using a random strategy.
* The ID generator uses a random salt for hashing.

stuff
* Most of the heavy stuff happens inside the order processing service.
* We cleaned out old stuff from the repository to reduce noise.
* The mapper was doing too much stuff, so we split it into smaller components.

huge
* We saw a huge spike in Kafka lag last night.
* There’s a huge difference in performance after enabling caching.
* A huge batch of events arrived at once and triggered autoscaling.

he is approaching another
* He is approaching another migration task, this time related to the checkout flow.
* He is approaching another bug related to concurrency and shared state.
* He is approaching another improvement in the retry mechanism.

bring up
* Let me bring up the logs so we can check the root cause.
* We need to bring up the topic of rate limiting during grooming.
* I want to bring up a concern about the cache invalidation strategy.

highlight
* I’d like to highlight that the consumer is still behind under heavy load.
* Let me highlight a risk in the current design: no idempotency.
* We highlight these endpoints as critical during Black Friday.

shines
* Kotlin really shines when handling coroutines in high-throughput systems.
* Kafka Streams shines in scenarios where real-time aggregation is required.
* The new caching layer shines during peak traffic.

provide
* The adapter must provide a consistent contract to the domain layer.
* Prometheus will provide metrics about memory and CPU usage.
* The BFF will provide consolidated data to the mobile app.

outside
* All outside requests must pass through the API Gateway.
* We’re receiving outside traffic from a partner system that wasn’t expected.
* Access to Redis from outside the VPC is blocked.

“rearline” (interpreting as “backline” / “backend support”)
* The rearline team helped us troubleshoot the message loss in Kafka.
* Rearline support identified a misconfigured ACL in the cluster.
* Rearline engineers escalated an issue related to database replication.

achieve it
* We need to reduce latency to 200ms, and caching will help us achieve it.
* We’re aiming for zero downtime, and blue-green deployment helps us achieve it.
* If we want idempotency, a referenceId is the way to achieve it.

certainly
* This fix will certainly reduce the number of retries in production.
* Switching to Redis will certainly improve response times.
* We will certainly need metrics before scaling this service.

occur
* Most failures occur during the first request after deployment.
* The bug seems to occur only under high concurrency.
* Memory leaks usually occur when mutable objects escape their scope.

nowadays
* Nowadays most Java teams rely on CI/CD fully integrated with Kubernetes.
* Nowadays we monitor everything with OpenTelemetry.
* Nowadays event-driven architectures are becoming the norm.

can swap
* We can swap RabbitMQ for Kafka with minimal impact thanks to our adapter layer.
* The service can swap its cache provider from Redis to DynamoDB if needed.
* We can swap out the ORM without affecting the domain model.

edge cases
* We added extra validation to cover edge cases in the credit simulation API.
* Most bugs happen in edge cases we didn’t consider during mapping.
* The consumer fails only on edge cases where the payload is partially null.

topic
* This topic receives around 20k events per minute during peak hours.
* We created a separate topic for dead-letter messages.
* Each topic follows a naming convention aligned with our domain

itś completely up to up
* You can use WebFlux or MVC — it’s completely up to you and the service requirements.
* Whether we deploy today or tomorrow is completely up to me; I own the pipeline.
* We can use either Redis or DynamoDB; it’s completely up to you during design
 
uppercase
* The API rejects the request because the status must be uppercase.
* We convert all headers to lowercase before processing.
* The mapper failed because the field names were mixed between uppercase and lowercase.

even
* Even with caching, the service still hit high latency yesterday.
* Even under load, the consumer stayed stable thanks to backpressure.
* Even a small bug in the mapper can break the entire workflow.

amount
* We validate the amount field before sending the purchase event.
* The amount is calculated using a dedicated domain rule.
* We store the amount in cents to avoid floating-point issues.

configure
* We need to configure the connection pool according to the load profile.
* I’ll configure the retry policy in the application YAML.
* You can configure the Kafka listener to use manual acknowledgment.

“concern” / “preoccupation”
* My main concern is the lack of idempotency in this flow.
* A big concern here is the amount of data we load into memory.
* There’s a preoccupation about how the external API handles failures.
 
Look into
* I’ll look into the logs to understand why the pod crashed.
* We need to look into the mapper; it’s returning null fields.
* I’ll look into the Grafana dashboard to see the CPU spike.

Work on
* Today I’ll work on the async retry mechanism.
* We need to work on the integration with the Salesforce API.
* I’m working on improving the payload validation layer.

it was time to get over / get away my shyness
* had to get over my shyness to start presenting architecture proposals.
* At standups, I got away from my shyness and started communicating better.
* Preparing interviews helped me get over my shyness when speaking English.

That’s why I got in / got back
The team needed help with Kafka, that’s why I got in to support the migration.
The incident escalated, that’s why I got back online during the night.
They needed Java expertise, that’s why I got in on the project.

Every week I carried out / looked up new stories and afterward I had a great time telling them
Every week I carried out new stories about Kafka consumers and dead letters.
Every week I looked up new stories related to performance tuning.
Every week I carried out integration stories with external APIs.

as well
We need to update the YAML files as well.
The mapper needs adjustments, and the service layer as well.
I fixed the Kafka config as well during the deployment.

We get up / get along really well, and I don’t feel shy at all around them
The backend team gets along really well, especially during refactoring sessions.
We get along really well with the SRE team; deployments run smoothly.
The Java and mobile teams get along really well for API design.

silver bullet
Caching is good, but it’s not a silver bullet for performance problems.
Kotlin coroutines help, but they’re not a silver bullet for concurrency.
Kafka is powerful, but it’s not a silver bullet for all async flows.

increase
We need to increase the consumer thread count to avoid lag.
Autoscaling will increase the replicas during high traffic.
Caching increased the throughput by 30%.

stuff
The controller still does too much stuff; we need to refactor it.
Let’s remove unused stuff from the YAML configurations.
The CI pipeline had a bunch of old stuff that slowed it down.

grooming sessions
During grooming sessions, we define acceptance criteria more clearly.
We identified several tech debts in the last grooming session.
Grooming sessions help us estimate backend tasks more accurately.

Then he covered the topic of Spring knowledge
Then he covered the topic of Spring knowledge, especially dependency injection.
Then he covered the topic of Spring knowledge during the architecture interview.
Then he covered the topic of Spring knowledge, focusing on WebFlux vs MVC.

With that in mind
throwble shotting
its very cute
I could start by talking about....
assesment
reduce coupling
let's keep rooling
despite that
we might be talking about a few things
tightly
stackholders
concern
let me put this way
ensurance
aproaches
He is thorough when reviewing pull requests.
sometimes I get annoyed
otherwise
I am eager to take on new challenges and grow as a backend developer.       
tight coupling
besides
pivotal
purpose
certanlyk  
he reinforced
to police
guarantee
in fact
international position
acknologe
throughput
back pressure
according to your needs
Depending on his needs, he requests a piece of information.
expensive and cheap
benchmarks
upcoming
even under load