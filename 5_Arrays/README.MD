## Array

An array is a data structure storing a sequence of values - **all of the same type**

You can have arrays for any primitive type or any class.

Elements in an array are indexed, starting at 0.

The more common way is to declare it with type + square brackets + array name:
```
int[] integerArray = new int[10]; 
```
This specifies an array of 10 integers. Note that an array is **NOT** resizeable. Once created, the size is fixed.

To initialize a new array with default values:
```
int [] firstFivePositives = new int[]{1,2,3,4,5};
```

The alternataive way is to define an array like this:
```
String courseList [];
```