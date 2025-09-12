link do gpt

https://chatgpt.com/g/g-p-67b7a57f1a508191895a25d03c5cdfb6-backend/c/689a3eeb-fa70-8331-b363-e48d4bb9b962

## Semana 1 — Fundamentos de criação & estruturas fáceis

1. Singleton – controlar 1 instância
   Desafio: BarrilConfig (único) guarda flags da vila.

de bonus, estudei o Monostate (instâncias múltiplas, estado único).
Sobe o Monostate:
guru da vila: https://refactoring.guru/pt-br/design-patterns/monostate


2. Factory Method – delegar criação
   Desafio: Cantina.factoryPedido("sanduiche"|"agua").

3. Builder – montar objeto complexo
   Desafio: CasaDoSeuMadrugaBuilder (cômodos opcionais).

4. Prototype – clonar barato
   Desafio: copiar “carta de cobrança” mudando valor e data.

5. Proxy (adiantado) – controle de acesso/cache
   Desafio: AluguelProxy verifica fiador antes de entregar chave.

6. Adapter – compatibilizar interfaces
   Desafio: adaptar Triangulo à “Régua da Professora Girafales”.

7. Facade – porta de entrada simples
   Desafio: FestaFacade orquestra música+comida+convites.

## Semana 2 — Estruturais & comportamentais clássicos

8. Decorator – somar comportamento
   Desafio: Churros + coberturas (açúcar, doce de leite…).

9. Composite – parte/todo
   Desafio: Brinquedo e CaixaDeBrinquedos (combo).

10. Strategy (adiantado) – trocar algoritmo
    Desafio: EstrategiaEconomia (pagar|enrolar|sumir 😅).

11. Template Method – esqueleto com ganchos
    Desafio: AulaTemplate (intro, conteúdo, prova).

12. Observer – pub/sub
    Desafio: Campainha notifica Chaves, Quico, Chiquinha.

13. Iterator – percorrer coleção
    Desafio: iterar “moradores” com filtro de inadimplentes.

14. Null Object – evitar null
    Desafio: InquilinoNulo não quebra fluxo se ninguém atende.

## Semana 3 — Padrões “de conversa” e DDD na veia

15. Command – ações como objetos
    Desafio: fila de Varrer, Lavar, Cozinhar.

16. State – comportamento por estado
    Desafio: HumorDoSeuMadruga (calmo|irritado|fugindo).

17. Chain of Responsibility – encadeamento
    Desafio: atendimento do pátio: Chaves → Seu Madruga → Sr. Barriga.
    https://chatgpt.com/g/g-p-67b7a57f1a508191895a25d03c5cdfb6-backend/c/689b6cd8-dea4-832f-aac9-922306d354d0

18. Mediator – centralizar comunicação
    Desafio: MediadorDaFesta coordena banda, luz e comida.

19. Memento – desfazer/refazer
    Desafio: snapshots da “arrumação do pátio”.

20. Visitor – operação sobre estrutura estável
    Desafio: visitante calcula custo de manutenção de cada casa.

21. Specification (DDD) – regras combináveis
    Desafio: EmDiaEComContratoSpec.and(SemMultaSpec).

## Semana 4 — Persistência, otimização, concorrência e resiliência

22. Repository + Unit of Work (DDD)
    Desafio: MoradorRepository com UoW atômica.

23. Flyweight – compartilhar estado intrínseco
    Desafio: milhares de “telhas” com textura compartilhada.

24. Bridge – separar abstração x implementação
    Desafio: Instrumento × Estilo (seresta|marimba do Quico).

25. Object Pool – reuso de recursos caros
    Desafio: pool de “vassouras” da limpeza.

26. Producer–Consumer – filas (BlockingQueue)
    Desafio: pedidos de churros produzidos/consumidos.

27. Executors/CompletableFuture – paralelismo fácil
    Desafio: preparar decoração, música e comida em paralelo e allOf().

28. Circuit Breaker + Retry (Resilience4j) – tolerância a falhas
    Desafio: fornecedor de churros instável (retry com jitter + disjuntor).

29. CQRS (extra) – leitura x escrita separadas
    Desafio: comandos para reservas do pátio e consultas para relatórios.

30. Interpreter (extra) – mini-DSL
    Desafio: linguagem “recados do pátio”: TOQUE; ESPERE 5; FUJA.