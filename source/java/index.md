# Java

## Functional Interfaces

- _Functional Interfaces_ provide target types for lambda expressions and method references.
- Each functional interface has a single abstract method SAM, called the _functional method_ for that functional interface.
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
