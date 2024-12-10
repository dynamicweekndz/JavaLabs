package comparable;

// Интерфейс для сравнимых объектов
public interface ComparableType<T> {
    int compareTo(T obj); // Метод сравнения, возвращает целое число
}
