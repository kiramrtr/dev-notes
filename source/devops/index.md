# DevOps

```{toctree}
jenkins
```

## Canary Deployment

A _canary deployment_ is a progressive rollout of an application that splits traffic between an already-deployed version and a new version, rolling it out to a subset of users before rolling out fully.

![Canary Deployment](./canary-deployment.svg)

##

A _blue/green_ deployment

![Blue/Green Deployment](./blue-green-deployment.svg)

Benefits:

- Zero downtime
- Instant rollback
- Environment separation

Considerations:

- Cost and operational overhead
- Backward compatibility: Shared resources like database
- Cutover
