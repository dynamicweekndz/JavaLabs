package utils;

import java.util.ArrayList;
import java.util.List;

public class ApplyUtils {
    /**
     * Применяет переданную функцию к каждому элементу списка.
     *
     * @param list список значений типа T
     * @param function объект, реализующий метод apply
     * @param <T> тип входных элементов списка
     * @param <P> тип выходных элементов нового списка
     * @return новый список значений типа P
     */
    public static <T, P> List<P> applyToList(List<T> list, ApplyFunction<T, P> function) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(function.apply(item));
        }
        return result;
    }
}
