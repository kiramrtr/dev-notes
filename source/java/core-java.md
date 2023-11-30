# Core Java

## [hashCode() and equals()](https://hyperskill.org/learn/step/3586)

### Overriding equals()

1. If the other object is `null` or is of different type, **the objects are not equal**.
2. If `this` and other object have the same reference, **the objects are equal**.
3. If all the **selected fields** are equal, **the objects are equal**, otherwise, **the objects are not equal**

```java
class Person {

  private String firstName;
  private String lastName;
  private int age;

  // constructor, getters and setters

  @Override
  public boolean equals(Object other) {
    /* Check this and other refer to the same object */
    if (this == other) {
      return true;
    }

    /* Check other is Person and not null */
    if (!(other instanceof Person)) {
      return false;
    }

    Person person = (Person) other;

    /* Compare all required fields */
    return (
      age == person.age &&
      Objects.equals(firstName, person.firstName) &&
      Objects.equals(lastName, person.lastName)
    );
  }
}
```

Using `java.util.Objects.equals(obj1, obj2)` can avoid `NullPointerException`

### Overriding hashCode()

If `hashCode()` is not overridden, the class cannot be used correctly in collection that applies hashing mechanism (`HashMap`, `HashSet`, `HashTable`).

Since Java 7, we have an `java.util.Objects.hash(Object... objects)` utility method for hashing e.g., `Objects.hash(firstName, lastName, age)`

- If two objects are equal, they MUST have same hash code.
- If two objects have same hash code, they do NOT have to be equal too.

## [Comparable](https://hyperskill.org/learn/step/14456)

> A sequence of data has the **natural ordering**, if for each 2 elements `a` and `b`, where `a` is located to the left of `b`, the condition `a.compareTo(b) <= 0` is true.

- `Comparable` provides `compareTo()` method which allows comparing an object with other objects of the same type.
- `compareTo` should be consistent with the `equals` method.

**Implementing the compareTo method**

Return:

- A positive integer (e.g., 1), if the current object is greater
- A negative integer (e.g., -1), if the current object is less
- Zero, if they are equal

Example of how the `compareTo` method is implemented in `Integer` class.

```java
@Override
public int compareTo(Integer anotherInteger) {
  return compare(this.value, anotherInteger.value);
}

public static int compare(int x, int y) {
  return (x < y) ? -1 : ((x == y) ? 0 : 1);
}
```

## [Comparator](https://hyperskill.org/learn/step/12966)

`Comparator<T>` is a generic interface that has a single abstract method (SAM) `compare` and few non-abstract methods, which can define rules for comparing Java objects.

`compare` method should return:

- 0 if both arguments are equal
- positive number if first argument is greater than second one
- negative number if first argument is less than second one

```java
class PersonAgeComparator implements Comparator<Person> {

  @Override
  public int compare(Person person1, Person person2) {
    if (person1.getAge() < person2.getAge()) {
      return -1;
    } else if (person1.getAge() == person2.getAge()) {
      return 0;
    } else {
      return 1;
    }
  }
}
```

Since `Comparator` has only a single abstract method (SAM) and therefore is a functional interface, `Comparator` instance can be created using lambda expression.

```java
Comparator<Person> personAgeComparator = (p1, p2) ->
  Integer.compare(p1.getAge(), p2.getAge());
```

**Utility methods**

[ ] TODO: add examples

- `Comparator.naturalOrder` returns a `Comparator` of the type that compares `Comparable` objects in the natural order. You will get compilation error if `Comparable` interface is not implemented.
- `Comparator.reverseOrder` compares `Comparable` objects in reverse natural order.
- `reversed` when called on `Comparator` return a new `Comparator` which is reverse of the given `Comparator`
- `Comparator.comparing`
- `thenComparing`

```{note}
`reversed()` method will reverse the whole chain of preceding comparators. Scope can be limited using parenthesis.
```

## Comparator vs Comparable

- `Comparable` defines the natural order of a class implementing it, perfect where objects have natural order e.g., primitive types, ComplexNumber etc...
- `Comparator` allows for customizing the ordering process.
- `Comparator` can also be useful when we don't have access to source code of class for implementing `Comparable`.
- With `Comparator` multiple can be joined to create a complex one or extract `Comparable` sort keys.

## Immutable

An object is considered _immutable_ if its state cannot change after it is constructed.

**Weak immutability** is when some fields of an object are immutable and others are mutable. **Strong immutability** is when all fields of an object are immutable

**A strategy for defining immutable objects**

1. Avoid "setter" methods that change field values or referenced objects.
2. Make all fields `final` and `private` to prevent external modification.
3. Prevent method overriding in subclasses by declaring the class as `final` or using `private` constructors with factory methods for instance creation.
4. For fields referencing mutable objects:
   - a. Do not provide methods that alter these mutable objects.
   - b. Avoid sharing or storing external mutable object references. Instead, use copies of these objects for internal storage and method returns

> https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
