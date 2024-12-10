package main;

import box.Box;
import comparable.Person;
import utils.BoxUtils;
import utils.ApplyFunction;
import utils.ApplyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Работа с коробкой
        System.out.println("Работа с коробкой:");
        Box<Integer> integerBox = new Box<>();
        try {
            System.out.println("Введите целое число для помещения в коробку: ");
            int number = scanner.nextInt();
            scanner.nextLine(); // Поглощение переноса строки
            integerBox.put(number);
            System.out.println("Коробка заполнена? " + integerBox.isFull());
            System.out.println("Содержимое коробки: " + integerBox.get());
            System.out.println("Коробка заполнена? " + integerBox.isFull());
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Работа с сравнимыми объектами
        System.out.println("\nРабота с сравнимыми объектами:");
        System.out.println("Введите имя и возраст первого человека:");
        System.out.print("Имя: ");
        String name1 = scanner.nextLine();
        System.out.print("Возраст: ");
        int age1 = scanner.nextInt();
        scanner.nextLine(); // Поглощение переноса строки

        System.out.println("Введите имя и возраст второго человека:");
        System.out.print("Имя: ");
        String name2 = scanner.nextLine();
        System.out.print("Возраст: ");
        int age2 = scanner.nextInt();

        // Создаём два объекта Person
        Person person1 = new Person(name1, age1);
        Person person2 = new Person(name2, age2);

        // Сравниваем два объекта
        int comparisonResult = person1.compareTo(person2);
        System.out.println("\nСравнение объектов:");
        System.out.println(person1);
        System.out.println(person2);
        if (comparisonResult > 0) {
            System.out.println(person1.getName() + " старше " + person2.getName());
        } else if (comparisonResult < 0) {
            System.out.println(person1.getName() + " младше " + person2.getName());
        } else {
            System.out.println(person1.getName() + " и " + person2.getName() + " одного возраста.");
        }

        // Работа с набором коробок
        System.out.println("\nРабота с набором коробок:");

        // Создаем список коробок
        List<Box<? extends Number>> boxes = new ArrayList<>();

        System.out.println("Введите количество коробок:");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Введите число для коробки " + (i + 1) + ":");
            double value = scanner.nextDouble();

            // Создаем коробку и добавляем в список
            Box<Number> box = new Box<>();
            box.put(value); // Можно хранить любые числа (Double, Integer и т.д.)
            boxes.add(box);
        }

        // Вызываем метод поиска максимума
        double max = BoxUtils.findMax(boxes);
        System.out.println("Максимальное значение среди коробок: " + max);

        // Пример 1: Разбиение чисел на положительные и отрицательные
        System.out.println("\nРазбиение чисел на положительные и отрицательные:");
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<List<Integer>> splitNumbers = collect(numbers, ArrayList::new, number -> number >= 0);
        System.out.println("Положительные числа: " + splitNumbers.get(0));
        System.out.println("Отрицательные числа: " + splitNumbers.get(1));

        // Пример 2: Разбиение строк по длине
        System.out.println("\nРазбиение строк по длине:");
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx", "qw");
        Map<Integer, List<String>> groupedStrings = collectByLength(strings);
        for (Map.Entry<Integer, List<String>> entry : groupedStrings.entrySet()) {
            System.out.println("Длина " + entry.getKey() + ": " + entry.getValue());
        }

        // Пример 3: Удаление дубликатов из списка строк
        System.out.println("\nУдаление дубликатов из списка строк:");
        List<String> stringList = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
        Set<String> uniqueStrings = collect(stringList, HashSet::new, Function.identity());
        System.out.println("Уникальные строки: " + uniqueStrings);
    }

    // Метод для коллекционирования
    public static <T, P> P collect(List<T> list, Supplier<P> collectionFactory, Function<T, ?> mapper) {
        P collection = collectionFactory.get();  // Используем Supplier для получения нового объекта коллекции
        if (collection instanceof List) {
            for (T item : list) {
                ((List) collection).add(item);  // Добавляем элементы в список
            }
        } else if (collection instanceof Set) {
            for (T item : list) {
                ((Set) collection).add(item);  // Добавляем элементы в Set
            }
        }
        return collection;
    }

    // Метод для разбиения строк по длине
    public static Map<Integer, List<String>> collectByLength(List<String> list) {
        Map<Integer, List<String>> grouped = new HashMap<>();
        for (String str : list) {
            int length = str.length();
            grouped.putIfAbsent(length, new ArrayList<>());
            grouped.get(length).add(str);
        }
        return grouped;
    }
}
