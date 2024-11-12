package main;

import cat.Cat;
import person.Person;
import name.Name;
import namedperson.NamedPerson;
import city.City;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // --- Задача 1: Человек ---
        Person cleopatra = new Person("Клеопатра", 152);
        Person pushkin = new Person("Пушкин", 167);
        Person vladimir = new Person("Владимир", 189);

        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(vladimir);

        // --- Задача 2: Имена ---
        Name cleoName = new Name("Клеопатра", null, null);
        Name pushkinName = new Name("Пушкин", "Александр", "Сергеевич");
        Name mayakovskyName = new Name("Маяковский", "Владимир", null);

        System.out.println(cleoName);
        System.out.println(pushkinName);
        System.out.println(mayakovskyName);

        // --- Задача 3: Человек с именем ---
        NamedPerson namedCleopatra = new NamedPerson(cleoName, 152);
        NamedPerson namedPushkin = new NamedPerson(pushkinName, 167);
        NamedPerson namedMayakovsky = new NamedPerson(mayakovskyName, 189);

        System.out.println(namedCleopatra);
        System.out.println(namedPushkin);
        System.out.println(namedMayakovsky);

        // --- Задача 4: Города(для задачи 3.3) ---
        City A = new City("A");
        City B = new City("B");
        City C = new City("C");
        City D = new City("D");
        City E = new City("E");
        City F = new City("F");

        // Добавление путей согласно изображению (для задачи 3.3)
        A.addPath(B, 5);
        A.addPath(F, 1);
        A.addPath(D, 6);

        B.addPath(C, 3);

        F.addPath(B, 1);
        F.addPath(E, 2);

        E.addPath(D, 2);

        C.addPath(D, 4);

        // Вывод информации о городах (для задачи 3.3)
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        System.out.println(F);

        // --- Создание города только с названием ---
        City cityA = new City("A");

        // --- Создание города с названием и набором путей ---
        City cityB = new City("B");
        City cityC = new City("C");
        City cityD = new City("D");

        Map<City, Integer> pathsFromE = new HashMap<>();
        pathsFromE.put(cityC, 4);
        pathsFromE.put(cityD, 2);

        City cityE = new City("E", pathsFromE);

        // Добавляем пути к городу A
        cityA.addPath(cityB, 5);
        cityA.addPath(cityD, 6);

        // Выводим информацию о городах
        System.out.println(cityA);
        System.out.println(cityE);

        // --- Создание кота по имени "Барсик" ---
        Cat barsik = new Cat("Барсик");

        // Выводим информацию о коте
        System.out.println(barsik);

        // Кот мяукает один раз
        barsik.meow();

        // Кот мяукает три раза
        barsik.meow(3);
    }
}
