package city;

import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> paths;

    // Конструктор для создания города только с названием
    public City(String name) {
        this.name = name;
        this.paths = new HashMap<>();
    }

    // Конструктор для создания города с названием и путями
    public City(String name, Map<City, Integer> paths) {
        this.name = name;
        this.paths = paths != null ? new HashMap<>(paths) : new HashMap<>();
    }

    // Метод для добавления пути к другому городу
    public void addPath(City city, int cost) {
        paths.put(city, cost);
    }

    // Метод toString для вывода информации о городе
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" -> ");
        for (Map.Entry<City, Integer> entry : paths.entrySet()) {
            sb.append(entry.getKey().name).append(":").append(entry.getValue()).append(", ");
        }
        if (!paths.isEmpty()) {
            sb.setLength(sb.length() - 2); // Удалить последнюю запятую и пробел
        }
        return sb.toString();
    }
}
