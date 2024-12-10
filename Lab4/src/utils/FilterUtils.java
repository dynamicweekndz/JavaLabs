package utils;

import java.util.ArrayList;
import java.util.List;

public class FilterUtils {
    /**
     * Фильтрует список на основе переданной функции.
     *
     * @param list список значений типа T
     * @param filter объект, реализующий метод test
     * @param <T> тип элементов списка
     * @return новый список, содержащий только элементы, прошедшие проверку
     */
    public static <T> List<T> filterList(List<T> list, FilterFunction<T> filter) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
