package utils;

@FunctionalInterface
public interface ApplyFunction<T, P> {
    P apply(T input);
}
