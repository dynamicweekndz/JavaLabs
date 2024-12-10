package ru.vasileva.main;

import java.util.Scanner;
import ru.vasileva.city.City;
import ru.vasileva.city.Route;
import ru.vasileva.fractions.Fraction;
import ru.vasileva.dot.Point;  // Импортируем класс Point из пакета ru.vasileva.dot
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- Задача 1.10 ---
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        // Добавление путей
        A.addOrUpdatePath(B, 5);
        A.addOrUpdatePath(F, 1);
        A.addOrUpdatePath(D, 6);

        B.addOrUpdatePath(C, 3);
        F.addOrUpdatePath(B, 1);
        F.addOrUpdatePath(E, 2);
        E.addOrUpdatePath(D, 2);
        C.addOrUpdatePath(D, 4);

        // Вывод
        System.out.println("Города и их пути:");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);

        // Создание маршрутов
        Route route = new Route(F, D);
        System.out.println("Маршрут из F в D: " + route);
        Route route2 = new Route(A, C);
        System.out.println("Маршрут из A в C: " + route2);

        // --- Дроби ---
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction f3 = new Fraction(5, 6);
        Fraction sum = f1.add(f2).add(f3);
        System.out.println("Сумма дробей: " + sum);

        // Сумма чисел
        double total1 = sum(2, 3, 2.3, 5);
        double total2 = sum(3.6, 49, 3, 3, 12, 1);
        System.out.println("Сумма чисел: " + total1);
        System.out.println("Сумма чисел: " + total2);

        // --- Возведение в степень ---
        if (args.length == 2) {
            String xStr = args[0];
            String yStr = args[1];
            double result = power(xStr, yStr);
            System.out.println("Результат возведения " + xStr + " в степень " + yStr + " = " + result);
        } else {
            System.out.println("Ошибка: необходимо передать два аргумента для возведения в степень.");
        }

        // --- Создание и вывод точек ---
        Point p1 = new Point(1.5, 2.5);
        Point p2 = new Point(3.0, 4.0);
        Point p3 = new Point(5.5, 6.5);

        // Вывод точек
        System.out.println("Точка 1: " + p1);  // {1.5;2.5}
        System.out.println("Точка 2: " + p2);  // {3.0;4.0}
        System.out.println("Точка 3: " + p3);  // {5.5;6.5}

        // Клонирование точки
        Point clonedPoint = p1.clone();
        System.out.println("Клонированная точка: " + clonedPoint);  // {1.5;2.5}
    }

    // Метод для вычисления суммы чисел
    public static double sum(Number... numbers) {
        double total = 0;
        for (Number num : numbers) {
            total += num.doubleValue();
        }
        return total;
    }

    // Метод для возведения числа X в степень Y
    public static double power(String xStr, String yStr) {
        // Преобразуем строки в числа
        int x = Integer.parseInt(xStr);
        int y = Integer.parseInt(yStr);

        // Возводим x в степень y
        return Math.pow(x, y);
    }
}


