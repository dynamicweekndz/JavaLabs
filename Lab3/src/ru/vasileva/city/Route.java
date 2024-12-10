package ru.vasileva.city;

import java.util.*;
import ru.vasileva.city.City;

public class Route {
    private City startCity;
    private City endCity;

    // Конструктор с проверкой
    public Route(City startCity, City endCity) {
        if (startCity == null || endCity == null) {
            throw new IllegalArgumentException("Начальный и конечный города не могут быть null.");
        }
        this.startCity = startCity;
        this.endCity = endCity;
    }

    // Методы установки начального и конечного города
    public void setStartCity(City startCity) {
        if (startCity == null) {
            throw new IllegalArgumentException("Начальный город не может быть null.");
        }
        this.startCity = startCity;
    }

    public void setEndCity(City endCity) {
        if (endCity == null) {
            throw new IllegalArgumentException("Конечный город не может быть null.");
        }
        this.endCity = endCity;
    }

    // Получение маршрута (алгоритм BFS для поиска кратчайшего пути)
    public List<City> calculateRoute() {
        if (startCity.equals(endCity)) {
            return List.of(startCity); // Если начальный и конечный города совпадают
        }

        Queue<List<City>> queue = new LinkedList<>();
        Set<City> visited = new HashSet<>();
        queue.add(List.of(startCity));

        while (!queue.isEmpty()) {
            List<City> path = queue.poll();
            City lastCity = path.get(path.size() - 1);

            if (lastCity.equals(endCity)) {
                return path; // Если достигли конечного города
            }

            if (!visited.contains(lastCity)) {
                visited.add(lastCity);
                for (Map.Entry<City, Integer> neighbor : lastCity.getPaths().entrySet()) {
                    List<City> newPath = new ArrayList<>(path);
                    newPath.add(neighbor.getKey());
                    queue.add(newPath);
                }
            }
        }

        return Collections.emptyList(); // Если путь не найден
    }

    // Преобразование маршрута в строку
    @Override
    public String toString() {
        List<City> route = calculateRoute();
        if (route.isEmpty()) {
            return "Маршрут не найден";
        }

        StringBuilder sb = new StringBuilder();
        for (City city : route) {
            sb.append(city.getName()).append(" -> ");
        }
        sb.setLength(sb.length() - 4); // Убираем последнюю стрелку
        return sb.toString();
    }
}
