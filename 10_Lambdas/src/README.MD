# Lambda expressions

A lambda expression consists of a parameter list, usually but not always declared in parenthesis; the arrow and either an expression or code block after the arrow.

Lambda expressions are usually simple expressions:
```java
(parameters1, parameter2, ...) -> expression;
```

The expression should return a value if the associated interface's method returns a value:
```java
(Person o1, Person o2) -> o1.lastName().compareTo(o2.lastName());
```

For Lambdas, Java infers the method by taking the clue from the reference type in the context of the lambda expression usage.

Like above, the method passing the lambda expression above helps Java to infer that it's the Comparator method.

There's only the one lambda expression Java cares about, and that's the abstract method. Java requires types to support lambda expressions to be something called a functional interface.

A functional interface is an interface that has **only one** abstract method - regardless of inheritance.

## Important
Java proves a library of functional interfaces in the `java.util.function` package

The 4 main types (and their simplest methods):
- Consumer: `void accept (T t)` executes code without returning data
- Function: `R apply (T t)` returns a result of an operation or function
- Predicate: `boolean test (T t)` tests if a condition is true or false
- Supplier: `T get()` returns an instance of something