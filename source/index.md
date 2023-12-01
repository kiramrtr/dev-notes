---
hide-toc: true
---

# Kira's dev notes

Just yet another developer notes which I have made for my reference and re-collection.

```{toctree}
:maxdepth: 2

agile
database/index
design-patterns/index
dev-tools/index
devops/index
docker/index
dsa/index
java/index
js/index
kafka
kubernetes/index
microservices/index
redis
spring/index
```

## Credits

[TODO]

- Composition pattern
- Straggler Problem
- Tumbling Windows - Apache Flink
- Stream Processing

https://www.elastic.co/guide/en/elasticsearch/reference/current/indices-split-index.html#how-split-works
https://stackoverflow.com/questions/46236029/why-does-elasticsearch-still-use-simple-routing-value-using-modulo/67766224#67766224
https://www.elastic.co/guide/en/elasticsearch/reference/current/indices-split-index.html#incremental-resharding

Rate Limiter

Why?:

- Prevent DDoS
- Implement service limits like free user can make 100 calls per day
- Prevent abuse or brute-force attacks e.g., login

## PS IMP

- Microservices Patterns:
  - Saga
  - Transactions (please research on these)
  - CQRS
  - API Composer
  - Service Discovery
  - Circuit Breaker
- Caching (in MS or Application level)
- Exposure on Hystrix, Eureka – Good to have
- Swagger for API Documentation
- How to roll back the Transactions in case of exceptions, How to cancel?
- CQRS in API and DB
- OAuth 2.0
- JWT
- API Gateway:
  - Any enterprise API gateways like Kong, APIGee, Mulesoft, AWS API gateway, Zuul etc, Policies, roles and responsibilities, reverse proxy, rate limiting, filters etc.
- Deep understanding of SOLID design principles – Must have
- Design Patterns:
  - Singleton
  - Factory
  - Builder
  - Template
  - Strategy
  - Adaptor
  - Decorator
- Generics Upper and Lower Bounds, Wild Card, Type Eraser
- Collections:
  - HashSet
  - LinkedHashSet
  - TreeSet
  - Hashmap
  - HashTable
  - LinkedHashMap
  - TreeMap,
  - ArrayList, Vector, LinkedList
- When should we use linked blocking queue and when array blocking queue
- Implementation of blocking queue
- Executor Framework, Deadlock, Fork & Join, Synchronization, Latch and barrier, `ReentrantLock`
- How do you take Heap dump in Java?
- What’s the difference heap dump and Thread Dump?
- Blocking Queue functionality (Array and Linked)
- Concurrent Hashmap internal working, Difference between Concurrent Hashmap and hashmap
- `CompletableFuture`
- Thread pool and its implementation. How to write a custom thread pool? Different types of Threadpool – Fixed, Cached, - Single, Scheduler, Work Stealing
- Object level vs class level locking
- `wait()`, `notify()` and `notifyAll()` with use cases
- Difference between `Callable` and `Runnable` Interfaces
- Difference between `yield()` and `join()`
- Semaphores
- Profiler
- JVM Configuration
- GC Algos (Mark & Sweep, Series & parallel GC, Full and partial GC) should be aware how to do memory profiling
- Java 8
  - Lambda Expressions
  - Streams (Parallel, Serial, lazy), Streams
  - Predicate
  - Function Interface and its various flavours
  - CompletableFuture
  - Optional in Java 8
- Able to write queries using different types of aggregate functions, Group By, Having Clause
- Good understanding of indexes – Clustered and Non Clustered, Concept of sharding in databases
- NoSQL experience is a huge advantage.
- Event based programming
- Distributed Tracing
- Scaling
- REST API: Versioning, Pagination, Mocking
- Production Support/Production Deployment & Bug Fixing (Canary/Blue Green deployment)
- How have you been involved? Production deployment checklist that was followed and operational steps taken?
- Log Monitoring Tools:
- ELK Stack, Splunk, Grafana
