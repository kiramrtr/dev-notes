# Kafka

> https://developers.redhat.com/learn/apache-kafka

Apache Kafka is a distributed data streaming platform enabling applications to publish, subscribe to, store, and process message streams in real-time.

In aPublish/Subscribe (pub/sub) system, sender publishes messages to a central point, and subscribers receive messages of interest from this central point.

Advantages over traditional pub/sub systems:

- Fault tolerance message store
- Real-time stream processing
- Guarantees messages are never overridden
- High throughput

Broker is the central point in a publish/subscribe system.

- A typical Kafka cluster contains multiple brokers
- Topics are hosted on the brokers
- Each topic is split into one or more partitions

## Topic

- A _topic_ is a collection of messages, such as 'Orders Placed', grouped for consumer processing
- Each topic is persisted to disk, replicated across brokers for fault-tolerance
- Each topic consists of one or more partitions
- Messages in the topic are stored for specific duration (default of 1 week)

## Partition

- A partition contains subset of messages written to a topic
- New messages are appended to the partition guaranteeing message order at partition level
- Multiple partitions enables improved performance in case of heavy load, data sharing and replication
- Topic partitions are distributed across brokers, maximizing parallelism in production and consumption
- A topic is sum of all events of all its partitions
- Partition can be configured to be replicated across brokers, and one of the broker is designated as the _partition leader_
- All messages are produced and consumed via the leader, and the partition replicas stay in sync with the leader
- If the leader becomes unavailable, one of the replica is promoted as leader

![Partition replication](https://developers.redhat.com/sites/default/files/styles/article_floated/public/RHOSAK%20LP1%20Fig4.png?itok=zGET7b7K)

## Message

- A _message_ or record is key(optional)/value pair with data for consumer
- Messages are stored within topics
- The message is persisted and durable during its configured lifespan
- The position of each message within a topic is its _offset_
- Messages are generally consumed in the order they were added
- If key exists, the hash is used for determining which partition it goes in
- Each message contains metadata timestamp attribute set by producer or broker on insertion, and an optional set of key-value pair headers
- Message can be up to 1MB in size by default, can be configured with large size. But, for efficiency few kilobytes is recommended

## Producer

- Producer publishes message to topics
- Messages with the same key are stored in the same partition

## Consumer

- Consumers subscribe to topic for receiving published messages
- A consumer can read data from any offset within a topic partition
- Each consumer belong to a _consumer group_, a list of consumer instances
- With multiple consumers in a group, each consumer received messages from only a subset of partitions
- If more consumers are there than number of partitions for a topic, additional consumers stay idle.

## Queue vs Topic

| Queue                                                                                                 | Topic                                                                                   |
| ----------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------- |
| Point-to-Point                                                                                        | Publish-Subscribe                                                                       |
| Producer --> Queue --> Consumer                                                                       | Publisher --> Topic --> Subscriber                                                      |
| Each message in the _Queue_ is delivered to and processed by one consumer                             | Each message published to at _Topic_ can be received by all interested subscribers      |
| Once a message is consumed, it is removed from the _Queue_                                            | The message remains in the _Topic_ until all subscribers have received it or it expires |
| Ideal when a message must be processed only once and by a single consumer <br> e.g., Sending an email | Suitable for multiple consumers <br> e.g., Fan-out notifications to various channels    |
