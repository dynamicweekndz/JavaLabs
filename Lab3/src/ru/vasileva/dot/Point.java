package ru.vasileva.dot;

public class Point implements Cloneable {
    private double x;
    private double y;

    // Конструктор для создания точки с координатами X и Y
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Геттеры для координат
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Метод для возвращения текстового представления точки
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }

    // Переопределяем метод clone() для создания копии точки
    @Override
    public Point clone() {
        try {
            // Создаем новый объект, который является копией текущего
            return (Point) super.clone();
        } catch (CloneNotSupportedException e) {
            // Этот блок не должен срабатывать, так как класс реализует интерфейс Cloneable
            e.printStackTrace();
            return null;
        }
    }
}
