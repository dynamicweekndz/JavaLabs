package namedperson;

import name.Name;

public class NamedPerson {
    private Name name;
    private int height;

    // Конструктор
    public NamedPerson(Name name, int height) {
        this.name = name;
        this.height = height;
    }

    // Метод toString
    @Override
    public String toString() {
        return name.toString() + ", рост: " + height;
    }
}
