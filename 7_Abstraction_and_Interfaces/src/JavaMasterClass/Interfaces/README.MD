# Interfaces

An interface is similar to an abstract class although it **isn't** a class at all.

It's a special type that's more like a **contract** between the class and the client code.

By declaring you're using an interface, your class must implement all the abstract methods on the interface.

A class agrees to this because it wants to be known by that type, by the outside world or client code.

An interface lets classes that might have little else in common be recognized as a special reference type.

An interface is usually named according to the set of behaviors it describes. Many interfaces will end in 'able', like Comparable, Iterable, etc.
This means that something is capable or can perform a given set of behaviors.

A class can only extend **a single class**. 

But a class can implement many interfaces, providing flexibility and modularity.

You cannot use `protected` methods in interfaces

Interfaces can have concrete methods too.

An interface never gets instantiated.

**But an interface can extend other interfaces** However, an interface cannot implement another interface!

A class implementing an interface that extends another interface must implement the methods required by both interfaces

## Records and Enums can implement interfaces


## On the `final` keyword
Any attribute defined in the interface is automatically public and final. It cannot be redefined.

A final method means it cannot be overriden by a subclass.

A final field means an object's field cannot be reassigned or given a different value after initialization.

A final static field is a class field that can't be reassigned or given a different value after the class' intialization.

A final class can't be overriden, no class can use it in the extends clause.

A final variable in a block of code means that once it's assigned a value - any remaining code in the block can't change it

A final method parameter means we can't assign a different value to that parameter in the method code block.

## Before JDK8 enhancements
Adding abstract methods to interfaces broke everything because all the classes that implement it won't compile.

The interface extension method is identified by the modifier `default` and is a concrete method. You can add statements into a code block.