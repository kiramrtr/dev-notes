# Streams

## Collectors

Collectors in Java are a part of the `java.util.stream` package and are typically used with streams to perform various operations such as grouping, summarizing, and partitioning data.

1. **Collecting to a List:**

```java
List<String> list = stream.collect(Collectors.toList());
```

2. **Collecting to a Set:**

```java
Set<String> set = stream.collect(Collectors.toSet());
```

3. **Joining Strings:**

```java
String result = stream.collect(Collectors.joining(", "));
```

4. **Summarizing Integers:**

```java
IntSummaryStatistics summary = stream.collect(Collectors.summarizingInt(Integer::intValue));
```

5. **Grouping by a Classifier:**

```java
Map<Integer, List<String>> groupedByLength = stream.collect(Collectors.groupingBy(String::length));
```

6. **Partitioning by a Predicate:**

```java
Map<Boolean, List<String>> partitioned = stream.collect(Collectors.partitioningBy(s -> s.length() > 3));
```

7. **Counting Elements:**

```java
long count = stream.collect(Collectors.counting());
```

8. **Mapping and Collecting:**

```java
List<Integer> lengths = stream.collect(Collectors.mapping(String::length, Collectors.toList()));
```

9. **Reducing to a Single Value:**

```java
Optional<String> concatenated = stream.collect(Collectors.reducing((s1, s2) -> s1 + s2));
```

Collectors provide a powerful way to perform complex collection operations succinctly and efficiently in Java.

## Reduce

**`Optional<T> reduce(BinaryOperator<T> accumulator)`**

```java
List<Integer> spendings = List.of(14, 22, 10, 18, 16, 15, 20);

int total = spendings
            .stream()
            .reduce((partialSum, next) partialSum + next)
            .orElse(0);
```

## Collect

```java
<R> R collect(
    Supplier<R> supplier,
    BiConsumer<R, ? super T> accumulator,
    BiConsumer<R, R> combiner
);
```

```java
ArrayList<String> strings = stream.collect(
    () -> new ArrayList<>(),
    (collection, element) -> collection.add(element.toString()),
    (collection1, collection2) -> collection1.addAll(collection2)
);
```

Pulling the mapping operation from accumulator function:

```java
ArrayList<String> strings =
    stream
    .map(Object::toString)
    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
```

## Processing methods

```java
String top3EmpNames =
  employees()
    .stream()
    .filter(Employee::isActive)
    .limit(3)
    .collect(Collectors.joining(", "));
```

## map() vs flatMap()

## Collectors

```java
collect(Collectors.toList());

collect(Collectors.toSet());

collect(Collectors.toMap(e -> e.name, e -> e));

collect(Collectors.joining(", "));
```

Group By department

```java
Map<Department, List<Employee>> deptWiseEmployees =
    employees
        .stream()
        .collect(Collectors.groupingBy(e -> e.getDepartment()));
```

Department wise count of employees

```java
Map<Department, Long> deptWiseEmpCount =
    employees
        .stream()
        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
```

## Reduction, concurrency and ordering

```java
Map<Buyer, List<Transaction>> salesByBuyer =
    txns
    .parallelStream();
    .collect(Collectors.groupingBy(Transaction::getBuyer));
```

## Parallel Streams

> Beneficial only when have a significant size of data like 10K+ else, the overhead might be more and doesn't give any improvement in speed. Benchmarking is the way to go.
