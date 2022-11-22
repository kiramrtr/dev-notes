# Java

## Modern Java

### Functional Interfaces

- _Functional Interfaces_ provide target types for lambda expressions and method references.
- Each functional interface has a single abstract method (SAM), called the _functional method_ for that functional interface.
- Lambda expression's parameter and return type are matched or adapted to _functional method_.

Functional interfaces can provide a target type in multiple contexts

1. Assignment context: `Predicate<String> p = String::isEmpty;`
2. Method invocation context: `stream.filter(e -> e.getSize() > 10)...`
3. Cast context: `stream.map((ToIntFunction) e-> e.getSize())...`

Basic function shapes

- `Function` (unary function from `T` to `R`)
- `Consumer` (unary function from `T` to `void`)
- `Predicate` (unary function from `T` to `boolean`)
- `Supplier` (nullary function to `R`)

### Optional

```
java.lang.Object
    java.util.Optional<T>
```

- Is a container object which may or may not contain a non-null value.
- Is a value-based class; use of identity-sensitive operations may have unpredictable results and should be avoided.
- Primarily intended for use as a method return type where there is a clear need to represent "no result".

```java
class Person {
    Optional<Bike> bike;
}

class Bike {
    Optional<Insurance> insurance;
}

class Insurance {
    LocalDate validTill;
}
```

#### Creating `Optional` objects

| Type                     | How                         |
| ------------------------ | --------------------------- |
| Empty Optional           | `Optional.empty()`          |
| From non-null value      | `Optional.of(bike)`         |
| From _may be_ null value | `Optional.ofNullable(bike)` |

#### Using `map` on `Optional`

````{tab} Before
```java
LocalDate validTill = null;
if (insurance != null) {
    validTill = insurance.getValidTill();
}
```
````

````{tab} After
```java
Optional<Insurance> insurance = Optional.ofNullable(insurance);
Optional<LocalDate> validTille = insurance.map(Insurance::getValidTill);
```
````

#### Chaining `Optional` objects with `flatMap`

### Misc Topics

#### Glossary

| Term                 | Meaning |
| -------------------- | ------- |
| _reference equality_ | `==`    |

#### Value-based Classes

https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/doc-files/ValueBased.html
