package Lesson.FunctionalInterfaces;

//This is a functional interface
@FunctionalInterface
public interface Operation<T> {
    T operate(T value1, T value2);
}
