# JavaScript

## Basics

### Data Types

**Primitive**:

- Number
- String
- Boolean

**Composite**:

- Object
- Function
- Array

**Trivial**

- Null
- Undefined

**Hoisting**

The process whereby the interpreter appears to move the declaration of _functions_, _variables_, classes or imports to the top of their scope, prior to execution of the code.

### `this`

- `this` refers to the object that is executing the current function.
- If the function that is being referenced is a regular one, `this` references the global object.
- If the function is a method of an object, `this` refers to the object itself.

### `let`, `var`, `const`

| Type    | Scope        | Hoisting                                                                     | Reassignment                                                                       |
| ------- | ------------ | ---------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `var`   | **function** | hoisted, but not initialized                                                 | Can be reassigned and redeclared                                                   |
| `let`   | **block**    | hoisted, but accessing them before declaration results in a `ReferenceError` | Can be reassigned but cannot be redeclared in same scope                           |
| `const` | **block**    | --do--                                                                       | Cannot be reassigned or redeclared. Must be initialized at the time of declaration |

### Closure

### Misc

- `===` checks for both the value and the type.
- Local Storage vs Session Storage
