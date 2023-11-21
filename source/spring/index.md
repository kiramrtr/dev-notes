# Spring

```{toctree}
spring-security
```

## Draft

Common annotations

| Annotation               | Description                                                                                           |
| ------------------------ | ----------------------------------------------------------------------------------------------------- |
| `@SpringBootApplication` | Composition annotation of `@SpringBootConfiguration`, `@EnableAutoConfiguration` and `@ComponentScan` |
| `@Configuration`         | Indicates that class declares one or more `@Bean` methods and may be processed by Spring Container    |
| `@EnableWebSecurity`     |                                                                                                       |
| `@Service`               |                                                                                                       |
| `@Repository`            |                                                                                                       |
| `@Bean`                  |                                                                                                       |

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