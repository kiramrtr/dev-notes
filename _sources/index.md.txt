---
hide-toc: true
---

# Kira's dev notes

Just yet another developer notes which I have made for my reference and re-collection.

```{toctree}
:maxdepth: 2

dev-tools/index
java/index
js/index
docker/index
kubernetes/index
dsa/index
microservices/index
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
