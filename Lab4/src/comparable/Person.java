package comparable;

// Пример класса, реализующего интерфейс ComparableType
public class Person implements ComparableType<Person> {
    private String name;
    private int age;

    // Конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Геттер для имени
    public String getName() {
        return name;
    }

    // Геттер для возраста
    public int getAge() {
        return age;
    }

    // Реализация метода сравнения
    @Override
    public int compareTo(Person other) {
        // Сравниваем по возрасту
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
