# Optional

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

## Creating `Optional` objects

| Type                     | How                         |
| ------------------------ | --------------------------- |
| Empty Optional           | `Optional.empty()`          |
| From non-null value      | `Optional.of(bike)`         |
| From _may be_ null value | `Optional.ofNullable(bike)` |

## Using `map` on `Optional`

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

## Chaining `Optional` objects with `flatMap`
