# EnumSet and EnumMap

You can use any List, Set or Map with an enum constant.

## EnumSet

The `EnumSet` and `EnumMap` each have special implementations to optimize performance for Sets with enum types.

All elements in an `EnumSet` must come from a single enum type. The `EnumSet` is abstract and
comes with many factory methods to create instances.

`EnumSet`s are represented internally as **bit vectors** - a series of ones and zeros. 

A "one" indicates that the enum constant is in the Set. A "zero" indicates that the enum constant is not in the set.

Using bit vector allows all Set operations to be computed using bit math so it's very fast.

## EnumMap
The `EnumMap` is a specialized map implementation for use with enum type keys. The class is **not** abstract and so it can be created directly.

The keys must **all come from the same enum type** and they're ordered naturally by the ordinal value of 
the enum constants.