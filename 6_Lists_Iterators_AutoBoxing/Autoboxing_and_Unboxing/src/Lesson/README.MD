# On autoboxing
Classes like LinkedLists cannot support primitives. So you can't do LinkedList<int>

The way to do this is to write a wrapper: 
Each wrapper has a static overloaded factory method `valueOf` which takes a primitive as an argument and returns an instance of the wrapper class.

For example:
```
Integer boxedInt = Integer.valueOf(15);
```

Here, `Integer` is the wrapper class. 

Autoboxing is when Java automatically boxes a primitive. Allowing Java to autobox is the best because Java will definitely do this in an optimized manner.

As an example:
```Integer boxedInteger = 15;```

Each wrapper class supports a method to return the primitive value it contains - this is called autoboxing.

To unbox automatically (referred to as unboxing):
```int unboxedInt = boxedInteger;```

This is the preferred way to unbox a wrapper instance.