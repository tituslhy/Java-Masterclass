# 🧠 Java Notes — Interfaces, Enums & the `final` Keyword

> “An interface isn’t a class — it’s a *contract* that says:  
> ‘If you implement me, you must keep your promises.’”

---

## 🔹 Interfaces 101

An **interface** is similar to an abstract class, although it **is not** a class at all.  
It’s a special type that defines a *contract* between the class and its client code.

By declaring that your class **implements** an interface, your class must provide
implementations for all the abstract methods in that interface.

A class agrees to this because it wants to be known by that *type* — the interface —  
by the outside world or client code.

---

### 🧩 Key Points

- A class can only **extend one class**, but it can **implement multiple interfaces**.  
  → This gives flexibility and modularity.

- Interfaces are often named after the behaviors they describe.  
  For example:
    - `Comparable` → something that can be compared
    - `Iterable` → something that can be iterated over
    - `Runnable` → something that can be run

  In short: if it ends with `-able`, it’s probably an interface.

- You **cannot** use `protected` methods in interfaces.

- Interfaces **can** contain **concrete methods** using the `default` keyword.  
  This was introduced in **JDK 8** to avoid breaking existing implementations when new methods are added.

---

### 🧠 Interface Behavior Summary

| Feature | Description |
|----------|-------------|
| Instantiation | ❌ Cannot instantiate an interface |
| Attributes | Always `public static final` |
| Methods (pre-Java 8) | Always `public abstract` |
| Methods (Java 8+) | Can have `default` or `static` concrete methods |
| Extends | ✅ Interfaces can extend other interfaces |
| Implements | ❌ Interfaces cannot implement other interfaces |

---

## 🧾 Records and Enums with Interfaces

Both **records** and **enums** can implement interfaces!

Example:
```java
record DragonFly(String name, String type) implements FlightEnabled { ... }

enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;
}
```

## Before Java 8
Adding a new abstract method to an existing interface would break every class that implemented it.

To fix that, Java 8 introduced default methods. This lets you add optional methods to interfaces without forcing subclasses to implement them.

🧭 Example: `FlightEnabled` & `OrbitEarth`
```java
interface FlightEnabled {
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES=  0.621371;

    void takeOff();
    void land();
    void fly();

    default FlightStages transition(FlightStages stage){
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }
}

interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

    // 🛰️ Private static helper method (JDK 9+)
    private static void log(String description){
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    // 🛠️ Private non-static helper method
    private void logStage(FlightStages stage, String description){
        description = stage + ": " + description;
        log(description);
    }

    // 🚀 Overriding a default method from the parent interface
    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition to " + nextStage);
        return nextStage;
    }
}
```

## 🧱 Static Methods in Interfaces

🟢 Public Static Methods
- Introduced in Java 8
- Used for utility-like functionality within the interface.
- Must be called using the interface name as the qualifier.
- Do not require an instance.

Example:
```java
interface Utils {
    static void sayHello() {
        System.out.println("Hello from Utils!");
    }
}

// Calling it:
Utils.sayHello();
```
You can’t call it through an instance or implementing class — it’s interface-only.

## 🔒 Private Static Methods
- Introduced in Java 9
- Used to reduce code duplication inside interfaces.
- Can be called only by other static, default, or private methods within the same interface.

```java
interface OrbitEarth {
    private static void log(String description) {
        System.out.println("LOG: " + description);
    }

    private void logStage(String stage, String desc) {
        log(stage + ": " + desc);
    }
}
```

## 🟠 Private Non-Static Methods
- Also introduced in Java 9.
- Similar purpose: help default methods reuse logic.
- Can only be called from other methods within the same interface (not from implementing classes).

Example:
```java
interface Example {
    default void greet() {
        log("greet() called");
    }

    private void log(String msg) {
        System.out.println("LOG: " + msg);
    }
}
```
These help you write cleaner, DRY interfaces — without forcing everything to be public.

## 💥 Calling super from an Interface

If you override a default method from an interface and want to still call the original interface version,
you can’t just write super.method(), because interfaces don’t have a superclass hierarchy.

You must use this syntax:
```java
InterfaceName.super.method();
```

Example:
```java
@Override
public FlightStages transition(FlightStages stage) {
    System.out.println(getClass().getSimpleName() + " transitioning");
    return FlightEnabled.super.transition(stage); // 👈 Calls interface default
}
```

This tells Java:

`“Hey, call the default version of transition() that’s defined in FlightEnabled.”`

You’re basically overriding it but still borrowing part of the original behavior.

### 🧩 Example in Action — Satellite
```java
class Satellite implements OrbitEarth {
    FlightStages stage = FlightStages.GROUNDED;

    @Override
    public void achieveOrbit() {
        transition("Orbit achieved");
    }

    @Override
    public void takeOff() {
        transition("Taking off");
    }

    @Override
    public void land() {
        transition("Landing");
    }

    @Override
    public void fly() {
        achieveOrbit();
        transition("Data collection while orbiting");
    }

    // Overloaded version of transition()
    public void transition(String description){
        System.out.println(description);
        stage = transition(stage);
        stage.track();
    }
}
```

This setup demonstrates:
- `OrbitEarth` reuses `FlightEnabled.super.transition()`
- `Satellite` adds its own overloaded `transition(String)` method
- `Private` interface helpers (`log`, `logStage`) quietly support the flow behind the scenes