# Non-Static Inner Classes

Inner classes are non-static classes, declared on an enclosing class at the member level.

Inner classes can have any of the four valid access modifiers.

An inner class has access to instance members, including private members of the enclosing class.

Instantiating an inner class from external code is a bit tricky though.

To create an instance of an inner class, first have an instance of the Enclosing Class. 
Then call `.new` followed by the inner class' name and the parenthesis, taking any constructor arguments.

```java
EnclosingClass.InnerClass innerClass = new EnclosingClass().new InnerClass();
```

In most cases, inner classes are not instantiated outside the outer classes.