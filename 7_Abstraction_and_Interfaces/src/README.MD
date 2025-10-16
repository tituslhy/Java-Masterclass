# ☕ Java Notes — Abstract Classes, Interfaces & Beyond

> “An abstract class says *‘You can’t touch this.’*  
> An interface says *‘You must promise to touch this — but do it your own way.’*”

---

## 🧱 Abstract Classes

**An abstract class provides a common definition that multiple subclasses can share.**

Think of it as a *half-built house*:  
you get the foundation, maybe some walls, but you still have to finish the rest yourself.

### 💡 Key Facts

- 🏗️ You **can’t instantiate** an abstract class. (No `new` for you.)
- 🧬 It can have **both abstract and concrete methods** (i.e., methods with and without bodies).
- 🧩 You can declare **non-static, non-final fields** — real instance variables that subclasses can use.
- 🔒 Concrete methods can use **any access modifier** (`public`, `protected`, `private`, etc.).
- 🚪 Abstract methods can use **all except `private`**.
- 🧭 Abstract classes **can extend only one class**, but **can implement multiple interfaces**.
- 🪜 If a subclass doesn’t implement all abstract methods, it must itself be declared `abstract`.

### 🧰 When to Use

Use an **abstract class** when:
- You want to **share common code** among *closely related classes*.
- You want to define **default state or fields**.
- You want to enforce a common *structure* but still allow some *freedom*.

> 🧠 Analogy:  
> Abstract classes are like *starter templates*.  
> Interfaces are *rules you must follow*.

---

## 🔌 Interfaces

**An interface decouples the “what” from the “how”.**

It defines a *contract* — a promise that any class implementing it will provide certain behaviors.  
Different classes can implement the same interface in completely different ways.

### 🧩 Key Points

- You can’t instantiate interfaces (they’re pure abstraction, baby).
- Interfaces define *capabilities* (“I can fly”, “I can swim”), not structure.
- All methods **without bodies** are **public and abstract by default**.
- Interfaces **can extend** other interfaces (inherit contracts).
- Since Java 8, you can have **default** and **static** methods too!

---

### 🚀 Modern Interface Features

| Feature | Description | Notes |
|----------|--------------|-------|
| `default` methods | Provide a default implementation to prevent breaking old code | Can be overridden by implementing classes |
| `static` methods | Belong to the interface, not the instance | Call using `InterfaceName.method()` |
| `private` methods | Help default methods share common logic | Can be static or non-static, only callable *within* the interface |

---

### ✈️ Example — FlightEnabled Interface

```java
interface FlightEnabled {

    // Any attribute defined in the interface is automatically public, static, and final
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    // Methods are automatically public and abstract
    void takeOff();
    void land();
    void fly();

    // Default method (Java 8+)
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = stage.getNextStage();
        System.out.println("Transitioning from " + stage + " to " + nextStage);
        return nextStage;
    }

    // Static method (Java 8+)
    static void log(String message) {
        System.out.println("LOG: " + message);
    }

    // Private non-static method (Java 9+)
    private void debug(String msg) {
        System.out.println("[DEBUG] " + msg);
    }
}
```

### 🪄 When to Use an Interface

Use an interface when:
- You expect unrelated classes to share the same capability.
e.g., Bird, Airplane, and Superman can all Fly.
- You want to define behavior, not implementation.
- You want to reduce coupling between components.
- You’re designing APIs, frameworks, or plugins.

### 🛰️ Interfaces That Extend Other Interfaces

Interfaces can extend other interfaces too!

Example:
```java
interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();

    private static void log(String description) {
        var today = new java.util.Date();
        System.out.println(today + ": " + description);
    }

    private void logStage(FlightStages stage, String description) {
        description = stage + ": " + description;
        log(description);
    }

    @Override
    default FlightStages transition(FlightStages stage) {
        FlightStages nextStage = FlightEnabled.super.transition(stage);
        logStage(stage, "Beginning transition to " + nextStage);
        return nextStage;
    }
}
```

🧩 Note:
You can call a default method from a parent interface using `InterfaceName.super.methodName()` —  but only from an overriding default or instance method!

### 🪶 Enums Implementing Interfaces

Enums can implement interfaces too — perfect for tracking or state transitions.

Example:
```java
enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {
        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }

    public FlightStages getNextStage() {
        FlightStages[] allStages = values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}

interface Trackable {
    void track();
}
```
This pattern lets enums behave like active components in your system —
not just passive labels.

## 🪪 Records Implementing Interfaces

Records can implement interfaces too!

Example:
```java
record DragonFly(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() { }

    @Override
    public void land() { }

    @Override
    public void fly() { }
}
```
Records automatically give you:
- Immutable fields
- Auto-generated equals(), hashCode(), and toString()
- Compact syntax

🧠 Analogy:
Records are like data classes in Python — lightweight and honest about being containers for data.

## Summary Table
| **Feature**         | **Abstract Class**                  | **Interface**                                 |
|----------------------|------------------------------------|-----------------------------------------------|
| **Inheritance**      | Can extend **one class**           | Can extend **multiple interfaces**            |
| **Fields**           | Can have **instance fields**       | Only **public static final** constants        |
| **Methods**          | Can have **concrete + abstract**   | Can have **abstract, default, static, private** |
| **Access Modifiers** | Any modifier                       | Mostly **public**, but **private** allowed since Java 9 |
| **Use Case**         | **Closely related** objects         | **Unrelated** objects with common behavior    |
| **Analogy**          | **Template**                       | **Contract**                                  |