package utils;

import box.Box;
import java.util.List;

public class BoxUtils {
    /**
     * Метод для нахождения максимального значения среди набора коробок.
     * @param boxes список коробок с числами
     * @return максимальное значение в формате double
     */
    public static double findMax(List<Box<? extends Number>> boxes) {
        double max = Double.NEGATIVE_INFINITY; // Инициализация минимально возможным значением
        for (Box<? extends Number> box : boxes) {
            if (box.isFull()) { // Проверяем, не пустая ли коробка
                double value = box.get().doubleValue(); // Преобразуем число в double
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }
}
