# Local Classes

Local classes are inner classes declared directly in a code block, usually a method body.

**Therefore they have no access modifiers!** These classes are only accessible in the method while it's executing.

Like an inner class, they have access to all fields and methods on the enclosing class.

They can also access local variables and method arguments that are final or effectively final.

When you create an instance of a local class, referenced variables used in the class, from the enclosing code are 'captured'.

This means a copy is made of them and stored with the instance.

This is done because the instance is stored in a different memory area.

**So if a local class uses local variables or method arguments from the enclosing code, these must be final or effectively final (the value never changes after assigned).**