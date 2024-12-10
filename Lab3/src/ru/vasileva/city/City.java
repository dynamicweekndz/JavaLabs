package ru.vasileva.city;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class City {
    private final String name;  // Название города
    private final Map<City, Integer> paths;  // Путей к другим городам

    // Конструктор для создания города только с названием
    public City(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название города не может быть пустым или null.");
        }
        this.name = name;
        this.paths = new HashMap<>();
    }

    // Конструктор для создания города с названием и путями
    public City(String name, Map<City, Integer> paths) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название города не может быть пустым или null.");
        }
        this.name = name;
        this.paths = paths != null ? new HashMap<>(paths) : new HashMap<>();
    }

    public String getName() {
        return name;
    }

    // Метод для добавления или обновления пути к другому городу
    public void addOrUpdatePath(City city, int cost) {
        if (city == null) {
            throw new IllegalArgumentException("Целевой город не может быть null.");
        }
        if (cost < 0) {
            throw new IllegalArgumentException("Стоимость пути не может быть отрицательной.");
        }
        paths.put(city, cost); // Если путь существует, обновляем его
    }

    // Метод для удаления пути к другому городу
    public void removePath(City city) {
        if (city == null) {
            throw new IllegalArgumentException("Целевой город не может быть null.");
        }
        if (!paths.containsKey(city)) {
            throw new IllegalArgumentException("Путь к указанному городу отсутствует.");
        }
        paths.remove(city);
    }

    // Метод для получения всех путей (возвращает неизменяемую карту)
    public Map<City, Integer> getPaths() {
        return Collections.unmodifiableMap(paths);
    }

    // Метод toString для вывода информации о городе
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" -> ");
        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            sb.append(entry.getKey().getName()).append(":").append(entry.getValue()).append(", ");
        }
        if (!paths.isEmpty()) {
            sb.setLength(sb.length() - 2); // Удалить последнюю запятую и пробел
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
