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

enum FlightStages implements Trackable { GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION; }