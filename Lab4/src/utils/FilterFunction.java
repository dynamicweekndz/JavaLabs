package utils;

@FunctionalInterface
public interface FilterFunction<T> {
    boolean test(T input);
}
