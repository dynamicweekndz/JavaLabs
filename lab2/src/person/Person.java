package person;

public class Person {
    private String name;
    private int height;

    // Конструктор
    public Person(String name, int height) {
        this.name = name;
        this.height = height;
    }

    // Метод toString
    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}
