## Polymporphism simply means "many forms".
Java allows us to write code that can call a method, but the actual method that gets executed can be quite different for different objects at runtime.

This means that the behavior that occurs during execution depends on the runtime type of the object, which might differ from its declared type in code.

For polymorphism to work, the declared type must have a relationship with the runtime type via inheritance. A subclass can override a method from its superclass, enabling polymorphic behavior.