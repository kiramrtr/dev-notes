# Functional Interfaces

- _Functional Interfaces_ provide target types for lambda expressions and method references.
- Each functional interface has a single abstract method (SAM), called the _functional method_ for that functional interface.
- Lambda expression's parameter and return type are matched or adapted to _functional method_.

Functional interfaces can provide a target type in multiple contexts

1. Assignment context: `Predicate<String> p = String::isEmpty;`
2. Method invocation context: `stream.filter(e -> e.getSize() > 10)...`
3. Cast context: `stream.map((ToIntFunction) e-> e.getSize())...`

## Basic function shapes

- `Function` (unary function from `T` to `R`) `R apply(T t)`
- `Consumer` (unary function from `T` to `void`) `accept(T t)`
- `Predicate` (unary function from `T` to `boolean`) `boolean test(T t)`
- `Supplier` (nullary function to `R`) `T get()`

### `Consumer<T>`

### `Supplier<T>`

### `Predicate<T>`

### `Function<T, R>`

## Lambda Expression

Lambdas provide a clear and concise way to represent one method interface using an expression. They are used primarily to define inline implementation of a _Functional Interface_.

### Closure

A lambda expression can capture variables from the context where it is defined and user the variable within the body. This technique is known as closure and can be used only if a captured variable is `final` or **effectively final**, i.e., _a variable or parameter whose value is never changed after it is initialized and if a reference is not changed it is effectively final even if the object reference is changed_.

NOTE: This is also applicable to anonymous classes.

```{code-block} java
---
emphasize-lines: 4
---
final int a = 10; // final

int b = 20;
b++; // As a result, b is not effectively final.

int c = a + b; // effectively final as it is never changed after initialization.

Function<Integer, Integer> fun = n -> n + a + b + c;
```

https://stackoverflow.com/questions/20938095/difference-between-final-and-effectively-final

## Method Reference

A **method reference** is a function that refers to a particular method via its name using the special `::` syntax.

```java
objectOrClass::methodName
```

````{tab} Using Lambda
```java
BiFunction<Double, Double, Double> powFun = (a, b) -> Math.pow(a, b);
```
````

````{tab} Using Method Reference
```java
BiFunction<Double, Double, Double> powFun = Math::pow;
```
````

There are four types of method references in general:

- reference to a static method `ClassName::staticMethodName`
- reference to a constructor `ClassName::new`
- reference to an instance method of an object `objectName::instanceMethodName`
- reference to an instance of an object of a particular type `ClassName::instanceMethodName`

**Static method**

```java
Function<String, Integer> parseInt = Integer::parseInt;

int n1 = parseInt.apply("143");
```

**Constructor**

```{code-block} java
---
emphasize-lines: 9, 11, 12
---
class User {
    String userId;

    public User(String userId) {
        this.userId = userId;
    }
}

Function<String, User> userFun = User::new;

// same using lambda
Function<String, User> userFun = userId -> new User(userId);

User user = userFun.apply("john.doe");
```

**Instance method of an object**

```{code-block} java
---
emphasize-lines: 3, 5, 6
---
List<String> tokens = List.of("1", "name", "desc");

Function<Integer, String> posFun = tokens::get;

// lambda equivalent
Function<Integer, String> posFun = index -> tokens.get(index);

posFun.apply(1); // $3 ==> "name"
```

See how `tokens` variable is captured from the context.

**Instance method of an object of a particular type**
This is another way of referring non-static methods

```{code-block} java
---
emphasize-lines: 1, 3
---
Function<Long, Double> converter = Long::doubleValue;

// or lambda
Function<Long, Double> converter = val -> val.doubleValue();

converter.apply(516L);
```
