# OOP & Immutability

## Core Pillars
- **Encapsulation**: Bundling fields and behavior together with restricted visibility (`private` fields + controlled accessors).
- **Inheritance**: Reusing behavior via `extends` while favoring composition over deep inheritance trees.
- **Polymorphism**: Compile-time method overloading and runtime method overriding via dynamic dispatch.
- **Abstraction**: Defining contracts through `interface` and `abstract` classes.

## Designing an Immutable Class
1. Declare the class as `final` so subclasses cannot override methods.
2. Make all fields `private final`.
3. Do not expose setter methods.
4. Perform **defensive copies** for mutable fields (like `Date`, `List`, or arrays) in both the constructor and getters.
