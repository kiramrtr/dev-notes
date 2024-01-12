# Spring

```{toctree}
jpa
spring-security
```

## TODO

- [@Bean vs @Component](https://hyperskill.org/learn/step/14771)
- [ApplicationContext](https://hyperskill.org/learn/step/22062)
- [Scopes of beans](https://hyperskill.org/learn/step/19487)
- [Exception handling in Spring Boot](https://hyperskill.org/learn/step/8780)

## Bean lifecycle

- Use annotations `@PostConstruct`, `@PreDestroy`, `@Bean`
- Implement `InitializingBean` `DisposableBean`

## @Bean vs @Component

The `@Bean` and `@Component` annotation's can be used to create beans that can be injected into each other.

- The `@Bean` annotation is a method-level annotation, whereas `@Component` is a class-level annotation.
- The `@Component` annotation doesn't need to be used with the `@Configuration` annotation, whereas the `@Bean` generic annotation has to be used within a class annotated with @Configuration.
- If you want to create a single bean for a class from an external library, you cannot just add the `@Component` annotation because you cannot edit the class. However, you can declare a method annotated with @Bean and return an object of this class from this method.
- There are several specializations of the `@Component` annotation, whereas `@Bean` doesn't have any specialized stereotype annotations.

Spring developers typically prefer Spring `@Component` annotation whenever possible. The `@Bean` annotation is mainly used for producing beans of unmodifiable classes or creating configs.

## Specializations of components in Spring

As mentioned above, there are several specializations of components depending on their role in Spring applications:

- `@Component` indicates a generic Spring component.
- `@Service` indicates a business logic component but doesn't provide any additional functions.
- `@Controller` / `@RestController` indicates a component that can work in REST web services.
- `@Repository` indicates a component that interacts with an external data storage (e.g., a database).

## Transaction propagations

| Type            |
| --------------- |
| `REQUIRED`      |
| `REQUIRES_NEW`  |
| `NESTED`        |
| `MANDATORY`     |
| `NEVER`         |
| `NOT_SUPPORTED` |
| `SUPPORTS`      |

## Solution Architecture Document

## Draft

Common annotations

| Annotation                 | Description                                                                                                                                                                                |
| -------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| `@EnableAutoConfiguration` | Enable auto-configuration of Spring Application Context, attempts to guess and configure the beans that you are likely to need based on the classpath and the beans you've already set up. |
| `@SpringBootApplication`   | Composition annotation of `@SpringBootConfiguration`, `@EnableAutoConfiguration` and `@ComponentScan`                                                                                      |
| `@Configuration`           | Indicates that class declares one or more `@Bean` methods and may be processed by Spring Container                                                                                         |
| `@EnableWebSecurity`       |                                                                                                                                                                                            |
| `@Service`                 |                                                                                                                                                                                            |
| `@Repository`              |                                                                                                                                                                                            |
| `@Bean`                    |                                                                                                                                                                                            |

## Design Patterns Used in Spring Framework

- Factory
- Inversion of Control
- Proxy

## Spring Cloud

- Distributed/versioned configuration
- Service registration and discovery
- Routing
- Service-to-service calls
- Load balancing
- Circuit Breakers
- Global locks
- Leadership election and cluster state
- Distributed messaging
