package cat;

public class Cat {
    private String name;

    // Конструктор для создания кота с именем
    public Cat(String name) {
        this.name = name;
    }

    // Метод для вывода кота в строковом формате
    @Override
    public String toString() {
        return "кот: " + name;
    }

    // Метод для того, чтобы кот помяукал один раз
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    // Метод для того, чтобы кот помяукал N раз
    public void meow(int times) {
        StringBuilder meowSound = new StringBuilder();
        for (int i = 0; i < times; i++) {
            meowSound.append("мяу");
            if (i < times - 1) {
                meowSound.append("-");
            }
        }
        System.out.println(name + ": " + meowSound + "!");
    }
}
